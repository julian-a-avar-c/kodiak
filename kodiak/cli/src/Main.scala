package kodiak.cli

import kodiak.interpreter.Interpreter
import kodiak.interpreter.InterpreterException
import kodiak.interpreter.Interpreter.given
import kodiak.parser.Ast
import kodiak.parser.Parser
import kodiak.parser.ParserException
import kodiak.parser.Ast.Document

object Main:
  def main(args: Array[String]): Unit =

    // |{?} Welcome to the Kodiak programming language!
    // |{? Comments can be single-line or multi-line. ?}
    // |
    // |{?} Here is a simple program that prints "Hello, World!".
    // |
    // |{?} You'll notice that in Kodiak, strings are enclosed square brackets prefixed with double quotes.
    // |{?} If a piece of text doesn't contain any special characters, one can drop the brackets.
    val input = """
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

    val value: Document =
      try
        given CanThrow[ParserException] = compiletime.erasedValue
        Parser.parse(input)
      catch
        case e =>
          System.err.println(s"Parser Error: ${e.getMessage}")
          Ast.Document()

    println(value)

    try
      given CanThrow[InterpreterException] = compiletime.erasedValue
      Interpreter.interpret(value)
    catch
      case e =>
        System.err.println(s"Interpreter Error: ${e.getMessage}")
    end try
  end main
end Main
