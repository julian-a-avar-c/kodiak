package kodiak.cli

import kodiak.interpreter.Interpreter
import kodiak.interpreter.InterpreterException
import kodiak.interpreter.Interpreter.given
import kodiak.parser.Ast
import kodiak.parser.Parser
import kodiak.parser.ParserException

object Main:
  def main(args: Array[String]): Unit =
    val input = "printline(2)"

    val value =
      try Parser.parse(input)
      catch
        case e: ParserException =>
          System.err.println(s"Error: ${e.getMessage}")
          Ast.Document()

    try
      given CanThrow[InterpreterException] = compiletime.erasedValue
      Interpreter.interpret(value)
    catch
      case e =>
        System.err.println(s"Error: ${e.getMessage}")
    end try
  end main
end Main
