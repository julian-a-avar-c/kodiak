package kodiak.interpreter

import kodiak.parser.Ast
import kodiak.core.utils.valueCanEqualValueOfSameType

case class InterpreterException(message: String)
    extends scala.Exception(message)

trait Interpreter:
  type Self <: Ast
  extension (ast: Self) def interpret: Ast throws InterpreterException

object Interpreter:
  def interpret[A <: Ast: Interpreter](ast: A): Ast throws
    InterpreterException =
    ast.interpret

  given Ast.Document is Interpreter:
    extension (document: Self)
      def interpret =
        document match
          case Ast.Document() =>
            Ast.Unit
          case Ast.Document(stmts*) =>
            stmts
              .map: stmt =>
                stmt match
                  case stmt: Ast.ValDefinition       => ??? // stmt.interpret
                  case stmt: Ast.VarDefinition       => ??? // stmt.interpret
                  case stmt: Ast.LetDefinition       => ??? // stmt.interpret
                  case stmt: Ast.SetDefinition       => ??? // stmt.interpret
                  case stmt: Ast.True.type           => ??? // stmt.interpret
                  case stmt: Ast.False.type          => ??? // stmt.interpret
                  case stmt: Ast.Unit.type           => ??? // stmt.interpret
                  case stmt: Ast.Id                  => ??? // stmt.interpret
                  case stmt: Ast.PlainText           => stmt.interpret
                  case stmt: Ast.RawText             => stmt.interpret
                  case stmt: Ast.Integer             => stmt.interpret
                  case stmt: Ast.Decimal             => ??? // stmt.interpret
                  case stmt: Ast.RawNumber           => ??? // stmt.interpret
                  case stmt: Ast.Tuple               => ??? // stmt.interpret
                  case stmt: Ast.Seq                 => ??? // stmt.interpret
                  case stmt: Ast.Set                 => ??? // stmt.interpret
                  case stmt: Ast.FunctionApplication => stmt.interpret
                  case stmt: Ast.PathApplication     => ??? // stmt.interpret
                  case stmt: Ast.If                  => ??? // stmt.interpret
                  case stmt: Ast.While               => ??? // stmt.interpret
              .lastOption
              .getOrElse(
                Ast.Unit,
              )
    end extension
  end given

  given Ast.FunctionApplication is Interpreter:
    extension (functionApplication: Self)
      def interpret =
        val Self(function, args) = functionApplication

        function match
          case Ast.Id("printline") =>
            args.exprs.map:
              case arg: Ast.Integer   => print(arg.value)
              case arg: Ast.PlainText => print(arg.value)
              case arg: Ast.RawText   => print(arg.value)
              case _                  => ???
            println()
            Ast.Unit
          case Ast.Id("+") =>
            val interpreted =
              args.exprs.headOption
                .map: arg =>
                  arg.asInstanceOf[Ast.Integer]
            Ast.Integer(interpreted.foldLeft(0)(_ + _.value))
          case _ => ???
        end match
    end extension
  end given

  given Ast.Integer is Interpreter:
    extension (value: Self) def interpret = value

  given Ast.PlainText is Interpreter:
    extension (value: Self) def interpret = value

  given Ast.RawText is Interpreter:
    extension (value: Self) def interpret = value

end Interpreter
