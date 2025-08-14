package kodiak.cli

import kodiak.parser.{Ast, Parser}
import kodiak.interpreter.Interpreter

object Main:
  def main(args: Array[String]): Unit =
    val input = "printline(\"[Hello, World!])"

    Parser.parse(input) match
      case Left(error) =>
        ???
      case Right(value: Ast.Document) =>
        Interpreter.interpret(value)
    end match
  end main
end Main
