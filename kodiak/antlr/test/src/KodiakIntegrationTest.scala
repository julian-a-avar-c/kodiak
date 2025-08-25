package kodiak.antlr

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.antlr.v4.runtime._
import org.antlr.v4.runtime.tree._

class KodiakIntegrationTest extends AnyFunSuite with Matchers {

  private def createParser(input: String): KodiakParser = {
    val charStream = CharStreams.fromString(input)
    val lexer = new KodiakLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    val parser = new KodiakParser(tokens)

    // Remove default error listeners
    parser.removeErrorListeners()
    lexer.removeErrorListeners()

    parser
  }

  private def parseAndValidate(input: String): ParseTree = {
    val parser = createParser(input)

    // Add error listener to catch any parse errors
    val errorListener = new BaseErrorListener {
      var errors = List.empty[String]

      override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: Any,
                             line: Int, charPositionInLine: Int, msg: String,
                             e: RecognitionException): Unit = {
        errors = s"line $line:$charPositionInLine $msg" :: errors
      }
    }

    parser.addErrorListener(errorListener)
    val tree = parser.program()

    if (errorListener.errors.nonEmpty) {
      fail(s"Parse errors: ${errorListener.errors.reverse.mkString("; ")}")
    }

    tree
  }

  test("integration: parse complete kodiak program") {
    val program = """
      {?} Complete Kodiak program test

      val name :text = "World"
      var counter :int = 0

      fn greet(person :text) :text =>
        "[Hello, ${person}!]"

      fn factorial(n :int) :int => {
        if n <= 1 then
          1
        else
          n * factorial(n - 1)
      }

      plex person(name :text, age :int) =>
        fn introduce() :text => "[I'm ${name}, age ${age}]"
        fn isAdult() :bool => age >= 18
      end person

      val alice = person("Alice", 25)
      val numbers = [1, 2, 3, 4, 5]
      val coords = (10, 20)
      val settings = {debug = true, timeout = 30}

      for i = 1 to 5 do
        set counter += i

      val squares = for i = 1 to 4 yield i * i

      match counter
        with 0 then "zero"
        with n :int then "[Total: ${n}]"
        else "unknown"
    """

    val tree = parseAndValidate(program)
    tree should not be null

    // Basic validation of parse tree structure
    val context = tree.asInstanceOf[KodiakParser.ProgramContext]
    context.statement() should not be null
    context.statement().size() should be > 10
  }

  test("integration: lexer tokenizes correctly") {
    val input = """val x :int = 42 + 3 * (5 - 1)"""

    val charStream = CharStreams.fromString(input)
    val lexer = new KodiakLexer(charStream)
    val tokens = new CommonTokenStream(lexer)
    tokens.fill()

    val tokenList = tokens.getTokens
    tokenList should not be empty

    // Verify we get expected token types
    val tokenTypes = tokenList.map(_.getType).filter(_ != Token.EOF)
    tokenTypes should contain (KodiakLexer.VAL)
    tokenTypes should contain (KodiakLexer.COLON)
    tokenTypes should contain (KodiakLexer.INT)
    tokenTypes should contain (KodiakLexer.ASSIGN)
    tokenTypes should contain (KodiakLexer.INTEGER)
    tokenTypes should contain (KodiakLexer.PLUS)
    tokenTypes should contain (KodiakLexer.MULTIPLY)
    tokenTypes should contain (KodiakLexer.LPAREN)
    tokenTypes should contain (KodiakLexer.RPAREN)
  }

  test("integration: visitor pattern works") {
    val input = """val x = 42"""
    val tree = parseAndValidate(input)

    // Simple visitor to count variable declarations
    val visitor = new KodiakBaseVisitor[Int] {
      override def visitValDecl(ctx: KodiakParser.ValDeclContext): Int = {
        1 + Option(ctx.expr()).map(visit).getOrElse(0)
      }

      override def visitProgram(ctx: KodiakParser.ProgramContext): Int = {
        ctx.statement().foldLeft(0)((acc, stmt) => acc + visit(stmt))
      }

      override def defaultResult(): Int = 0

      override def aggregateResult(aggregate: Int, nextResult: Int): Int =
        aggregate + nextResult
    }

    val count = visitor.visit(tree)
    count should be(1)
  }

  test("integration: listener pattern works") {
    val input = """
      val x = 1
      val y = 2
      var z = 3
    """
    val tree = parseAndValidate(input)

    // Simple listener to count declarations
    class DeclarationCounter extends KodiakBaseListener {
      var valCount = 0
      var varCount = 0

      override def enterValDecl(ctx: KodiakParser.ValDeclContext): Unit = {
        valCount += 1
      }

      override def enterVarDecl(ctx: KodiakParser.VarDeclContext): Unit = {
        varCount += 1
      }
    }

    val counter = new DeclarationCounter()
    val walker = new ParseTreeWalker()
    walker.walk(counter, tree)

    counter.valCount should be(2)
    counter.varCount should be(1)
  }

  test("integration: error recovery") {
    // Test that parser can handle and report errors gracefully
    val badInput = """val x = """

    val parser = createParser(badInput)
    val errorListener = new BaseErrorListener {
      var errorCount = 0

      override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: Any,
                             line: Int, charPositionInLine: Int, msg: String,
                             e: RecognitionException): Unit = {
        errorCount += 1
      }
    }

    parser.addErrorListener(errorListener)
    val tree = parser.program()

    // Should have detected the error
    errorListener.errorCount should be > 0
    tree should not be null // Parser should still return a tree
  }
}
