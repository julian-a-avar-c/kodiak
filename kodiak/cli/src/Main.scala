package kodiak.cli

import kodiak.parser.{Ast, Parser}
import kodiak.parser.ParserException
import kodiak.interpreter.Interpreter
import kodiak.interpreter.Interpreter.given

object Main:
  def main(args: Array[String]): Unit throws Exception =
    val input = "printline(\"[Hello, World!])"

    val value =
      try Parser.parse(input)
      catch
        case e: ParserException =>
          System.err.println(s"Error: ${e.getMessage}")
          Ast.Document()

    Interpreter.interpret(value)
  end main
end Main
