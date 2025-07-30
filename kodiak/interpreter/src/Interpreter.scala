package kodiak.interpreter

import kodiak.parser.ast.*

object Interpreter:
  def evaluate(ast: Ast): Unit = Interpreter().evaluate(ast)

class Interpreter():
  val stack = scala.collection.mutable.ArrayStack.empty[Ast.Expr]
  val heap  = scala.collection.mutable.HashMap.empty[String, Ast.Expr]

  def evaluate(ast: Ast): Ast =
    ast match
      case Ast.Document(value*) =>
        value.foreach(evaluate)
        Ast.Unit
      case Ast.Function(params, body)               => ???
      case Ast.FunctionApplication(function, args*) =>
        function match
          case Ast.Id("printline") =>
            val firstArgGroup: Ast.Collection = args(0)
            val firstArg: Ast.Expr            = firstArgGroup match
              case Ast.Tuple(exprs*)    => exprs(0)
              case Ast.Sequence(exprs*) => exprs(0)
              case Ast.Set(exprs*)      => exprs(0)
            firstArg match
              case Ast.PlainText(value) =>
                printf(value)
                Ast.Unit
              case _ => ???
            end match
          case _ => ???
      case Ast.Unit                           => Ast.Unit
      case Ast.True                           => ???
      case Ast.False                          => ???
      case Ast.Integer(value)                 => ???
      case Ast.Decimal(value)                 => ???
      case Ast.RawNumber(value, interpolator) => ???
      case Ast.PlainText(value)               => ???
      case Ast.RawText(interpolator, value)   => ???
      case id @ Ast.Id(value)                 =>
        value match
          case "printline" => id
          case _           => ???
      case tuple @ Ast.Tuple(exprs*)                 => tuple
      case Ast.Sequence(exprs*)                      => ???
      case Ast.Set(exprs*)                           => ???
      case Ast.If(condition, thenBranch, elseBranch) => ???
      case Ast.Match(selector, patterns*)            => ???
      case Ast.Match.ElsePattern(body)               => ???
      case Ast.While(condition, body)                => ???
      case Ast.For(generators, body)                 => ???
      case Ast.For.Generator(lhs, hrs)               => ???
      case Ast.ValDefinition(lhs, rhs)               => ???
      case Ast.VarDefinition(lhs, rhs)               => ???
      case Ast.SetDefinition(lhs, rhs)               => ???
      case Ast.LetDefinition(lhs, rhs)               => ???
    end match
  end evaluate

  def show(ast: Ast): String =
    ast match
      case Ast.Document(value*)                     => ???
      case Ast.Id(value)                            => ???
      case Ast.Unit                                 => ???
      case Ast.Function(params, body)               => ???
      case Ast.FunctionApplication(function, args*) => ???
      case Ast.True                                 => "true"
      case Ast.False                                => "false"
      case Ast.Integer(value)                       => ???
      case Ast.Decimal(value)                       => ???
      case Ast.RawNumber(value, interpolator)       => ???
      case Ast.PlainText(value)                     => value
      case Ast.RawText(interpolator, value)         => ???
      case Ast.Tuple(exprs*)                        =>
        exprs.map(show).mkString("(", ", ", ")")
      case Ast.Sequence(exprs*)                      => ???
      case Ast.Set(exprs*)                           => ???
      case Ast.If(condition, thenBranch, elseBranch) => ???
      case Ast.Match(selector, patterns*)            => ???
      case Ast.Match.ElsePattern(body)               => ???
      case Ast.While(condition, body)                => ???
      case Ast.For(generators, body)                 => ???
      case Ast.For.Generator(lhs, rhs)               => ???
      case Ast.ValDefinition(lhs, rhs)               => ???
      case Ast.VarDefinition(lhs, rhs)               => ???
      case Ast.SetDefinition(lhs, rhs)               => ???
      case Ast.LetDefinition(lhs, rhs)               => ???
end Interpreter
