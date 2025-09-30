package kodiak.cli

import kodiak.interpreter.{Interpreter, InterpreterException}
import kodiak.interpreter.Interpreter.given
import kodiak.parser.{Ast, Parser, ParserException}

import mainargs.*

object Cli:
  def interpret(input: String, printAst: Boolean) =
    val value: Ast.Document =
      try
        given CanThrow[ParserException] = compiletime.erasedValue
        Parser.parse(input)
      catch
        case e =>
          System.err.println(s"Parser Error: ${e.getMessage}")
          Ast.Document()

    if printAst then println(value)

    try
      given CanThrow[InterpreterException] = compiletime.erasedValue
      Interpreter.interpret(value)
    catch
      case e =>
        System.err.println(s"Interpreter Error: ${e.getMessage}")
    end try
  end interpret
end Cli

object Main:
  given TokensReader.Simple[os.FilePath]:
    def shortName               = "filepath"
    def read(strs: Seq[String]) = Right(os.Path(strs.head, os.pwd))

  @main
  def interpret(
      @arg(doc = "Source file")
      file: Option[os.FilePath],
      @arg(doc = "Input string")
      rawInput: Option[String],
      @arg(doc = "Whether to print the AST")
      printAst: Flag,
  ) =
    // Either file or input must be defined, but not both
    assert(file.isDefined ^ rawInput.isDefined)

    val input = rawInput getOrElse file
      .map { file =>
        os.read {
          file match
            case file: os.Path    => file
            case file: os.RelPath => os.pwd / file
            case file: os.SubPath => os.pwd / file
        }
      }
      .getOrElse(exampleInput)
    Cli.interpret(input, printAst.value)
  end interpret

  def main(args: Array[String]): Unit = ParserForMethods(this).runOrExit(args)

end Main

val exampleInput = """
  |{?} Welcome to the Kodiak programming language!
  |{? Comments can be single-line or multi-line. ?}
  |
  |{?} Here is a simple program that prints "Hello, World!".
  |printline("[Hello, World!])
  |
  |{?} You'll notice that in Kodiak, strings are enclosed square brackets prefixed with double quotes.
  |{?} If a piece of text doesn't contain any special characters, one can drop the brackets.
  |printline("Hello)
  |
  |{?} There exists other data types in Kodiak, such as integers, decimals, and booleans.
  |
  |printline(42)
  |printline(3.14)
  |printline(false)
  |""".stripMargin
