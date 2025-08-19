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
                  // Stmt
                  case stmt: Ast.ValDefinition => ???
                  case stmt: Ast.VarDefinition => ???
                  case stmt: Ast.LetDefinition => ???
                  case stmt: Ast.SetDefinition => ???
                  case stmt: Ast.While         => ???
                  // Expr
                  case expr: Ast.True.type           => ???
                  case expr: Ast.False.type          => ???
                  case expr: Ast.Unit.type           => ???
                  case expr: Ast.Id                  => expr
                  case expr: Ast.PlainText           => expr
                  case expr: Ast.RawText             => expr
                  case expr: Ast.Integer             => expr
                  case expr: Ast.Decimal             => ???
                  case expr: Ast.RawNumber           => ???
                  case expr: Ast.Tuple               => expr
                  case expr: Ast.Seq                 => expr
                  case expr: Ast.Set                 => expr
                  case expr: Ast.FunctionApplication => expr
                  case expr: Ast.PathApplication     => ???
                  case expr: Ast.If                  => ???
                  case expr: Ast.Match               => ???
                  case expr: Ast.For                 => ???
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
