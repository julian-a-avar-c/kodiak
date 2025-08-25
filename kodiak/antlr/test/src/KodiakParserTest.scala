package kodiak.antlr

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.*

class KodiakParserTest extends AnyFunSuite with Matchers:

  private def parseProgram(input: String): ParseTree =
    val charStream = CharStreams.fromString(input)
    val lexer      = new KodiakLexer(charStream)
    val tokens     = new CommonTokenStream(lexer)
    val parser     = new KodiakParser(tokens)

    // Remove default error listeners to avoid console spam during tests
    parser.removeErrorListeners()
    lexer.removeErrorListeners()

    // Add custom error listener to capture errors
    val errorListener = new BaseErrorListener:
      var hasErrors     = false
      var errorMessages = List.empty[String]

      override def syntaxError(
          recognizer: Recognizer[?, ?],
          offendingSymbol: Any,
          line: Int,
          charPositionInLine: Int,
          msg: String,
          e: RecognitionException,
      ): Unit =
        hasErrors = true
        errorMessages = s"line $line:$charPositionInLine $msg" :: errorMessages
      end syntaxError

    parser.addErrorListener(errorListener)
    lexer.addErrorListener(errorListener)

    val tree = parser.program()

    if errorListener.hasErrors then
      fail(
        s"Parse errors: ${errorListener.errorMessages.reverse.mkString(", ")}",
      )
    end if

    tree
  end parseProgram

  test("parse simple variable declaration") {
    val input = """val x :int = 42"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse variable declaration without type annotation") {
    val input = """val name = "Alice""""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse mutable variable declaration") {
    val input = """var count :int = 0"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse set statement") {
    val input = """set count = 10"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse set statement with compound assignment") {
    val input = """set count += 5"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse let declaration") {
    val input = """let temp = 25"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse simple function declaration") {
    val input = """fn greet(name :text) :text => "Hello, " + name"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse function with multiple parameters") {
    val input = """fn add(a :int, b :int) :int => a + b"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse function without parameters") {
    val input = """fn getCurrentTime() :text => "now""""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse if expression") {
    val input = """if x > 0 then "positive" else "negative""""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse while loop") {
    val input = """while i < 10 do set i += 1"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse for loop") {
    val input = """for i = 1 to 10 do printline(i)"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse for loop with step") {
    val input = """for i = 1 to 10 step 2 do printline(i)"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse for yield") {
    val input = """for i = 1 to 5 yield i * i"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse match expression") {
    val input =
      """match x with 0 then "zero" with n :int then "number" else "unknown""""
    val tree = parseProgram(input)
    tree should not be null
  }

  test("parse simple plex declaration") {
    val input =
      """plex person(name :text, age :int) => fn greet :text => "Hello" end person"""
    val tree = parseProgram(input)
    tree should not be null
  }

  test("parse plex with fields and methods") {
    val input = """
      plex counter(initial :int) =>
        var count :int = initial
        fn increment() :unit => set count += 1
        fn getValue() :int => count
      end counter
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse extension declaration") {
    val input = """
      extension int =>
        fn isEven() :bool => this % 2 == 0
      end extension
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse collections") {
    val input = """
      val numbers = [1, 2, 3, 4, 5]
      val coords = (10, 20)
      val uniqueItems = {1, 2, 3}
      val mapping = {name = "test", value = 42}
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse string literals") {
    val input = """
      val simple = "hello"
      val raw = r"no\nescapes"
      val interpolated = "[Hello, ${name}!]"
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse numeric literals") {
    val input = """
      val decimal = 42
      val float = 3.14
      val hex = x#FF
      val binary = b#1010
      val octal = o#77
      val scientific = 1.23e-4
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse boolean and unit literals") {
    val input = """
      val isTrue = true
      val isFalse = false
      val nothing = unit
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse function calls and member access") {
    val input = """
      val result = add(1, 2)
      val length = text.length()
      val first = tuple.0
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse binary expressions with precedence") {
    val input = """val result = 2 + 3 * 4 - 1"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse unary expressions") {
    val input = """
      val neg = -x
      val notTrue = !flag
      val bitwise = ~value
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse parenthesized expressions") {
    val input = """val result = (2 + 3) * (4 - 1)"""
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse block expressions") {
    val input = """
      val result = {
        val temp = 10
        temp * 2
      }
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse try-catch statements") {
    val input = """
      try
        riskyOperation()
      catch e :Exception then
        handleError(e)
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse comments") {
    val input = """
      {?} This is a single line comment
      val x = 42
      {? This is a
         multi-line comment ?}
      val y = 24
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse raw identifiers") {
    val input = """
      val `special-name` = 42
      val `type` = "keyword as identifier"
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse complex program") {
    val input = """
      {?} Complex Kodiak program
      val name :text = "Alice"
      var counter :int = 0

      fn fibonacci(n :int) :int => {
        if n <= 1 then
          n
        else
          fibonacci(n - 1) + fibonacci(n - 2)
      }

      plex person(name :text, age :int) =>
        fn greet() :text => "[Hello, I'm ${name}]"
        fn isAdult() :bool => age >= 18
      end person

      val alice = person("Alice", 25)
      val greeting = alice.greet()

      for i = 1 to 10 do
        set counter += i

      val squares = for i = 1 to 5 yield i * i

      match counter
        with 0 then "zero"
        with n :int then "[number: ${n}]"
        else "unknown"
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  test("parse type annotations") {
    val input = """
      val seqOfInts :[int] = [1, 2, 3]
      val setOfText :{text} = {"a", "b", "c"}
      val tupleType :(int, text) = (42, "hello")
      val mapType :{text = int} = {name = "test", value = 42}
      val fnType :fn(int, int) -> int = add
    """
    val tree  = parseProgram(input)
    tree should not be null
  }

  // Error cases
  test("invalid syntax should fail") {
    assertThrows[AssertionError] {
      parseProgram("val = 42") // missing identifier
    }
  }

  test("unmatched parentheses should fail") {
    assertThrows[AssertionError] {
      parseProgram("val x = (1 + 2")
    }
  }

  test("invalid function syntax should fail") {
    assertThrows[AssertionError] {
      parseProgram("fn (a :int) => a") // missing function name
    }
  }

  test("parse sample kodiak file") {
    val resourcePath = "/sample.kodiak"
    val inputStream  = getClass.getResourceAsStream(resourcePath)

    if inputStream == null then fail(s"Could not find resource: $resourcePath")

    val source = scala.io.Source.fromInputStream(inputStream)
    val input  =
      try source.mkString
      finally source.close()

    val tree = parseProgram(input)
    tree should not be null

    // Verify that the tree has the expected structure
    val statements = tree.asInstanceOf[KodiakParser.ProgramContext].statement()
    statements should not be null
    statements.size() should be > 0
  }
end KodiakParserTest
