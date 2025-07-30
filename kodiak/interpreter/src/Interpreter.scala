package kodiak.interpreter

import kodiak.parser.ast.*
import kodiak.parser.ast.Ast.*

object Interpreter extends Interpreter

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
            printline(firstArgGroup)
          case _ => ???
      case Ast.MethodApplication(receiver, method, args*) => ???
      case Ast.OperatorApplication(left, op, right)       =>
        (left, op, right) match
          case (Ast.Integer(leftValue), Ast.Id("+"), Ast.Integer(rightValue)) =>
            Ast.Integer(leftValue + rightValue)
          case (Ast.Decimal(leftValue), Ast.Id("+"), Ast.Decimal(rightValue)) =>
            Ast.Decimal(leftValue + rightValue)
          case _ => ???
      case Ast.Unit                           => Ast.Unit
      case Ast.True                           => ???
      case Ast.False                          => ???
      case _: Ast.Integer                     => ast
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

  def show(expr: Ast.Expr): String =
    expr match
      case Ast.Id(value)                                  => ???
      case Ast.Unit                                       => ???
      case Ast.Function(params, body)                     => ???
      case Ast.True                                       => "true"
      case Ast.False                                      => "false"
      case Ast.Integer(value)                             => value.toString
      case Ast.Decimal(value)                             => value.toString
      case Ast.RawNumber(value, interpolator)             => ???
      case Ast.PlainText(value)                           => value
      case Ast.RawText(interpolator, value)               => ???
      case Ast.Tuple(exprs*)                              => ???
      case Ast.Sequence(exprs*)                           => ???
      case Ast.Set(exprs*)                                => ???
      case Ast.If(condition, thenBranch, elseBranch)      => ???
      case Ast.Match(selector, patterns*)                 => ???
      case Ast.While(condition, body)                     => ???
      case Ast.For(generators, body)                      => ???
      case Ast.ValDefinition(lhs, rhs)                    => ???
      case Ast.VarDefinition(lhs, rhs)                    => ???
      case Ast.SetDefinition(lhs, rhs)                    => ???
      case Ast.LetDefinition(lhs, rhs)                    => ???
      case Ast.FunctionApplication(function, args*)       => ???
      case Ast.MethodApplication(receiver, method, args*) => ???
      case Ast.OperatorApplication(left, operator, right) => ???
    end match
  end show

  def printline(collection: Ast.Collection): Ast.Unit =
    def toString(exprs: Seq[Ast.Expr])(start: String, end: String): String =
      if exprs.length == 1 then show(exprs.head)
      else s"${start}${exprs.map(show).mkString(", ")}${end}"
    val joinedCollection = collection match
      case Ast.Tuple(exprs*) =>
        toString(exprs)("(", ")")
      case Ast.Sequence(exprs*) =>
        toString(exprs)("[", "]")
      case Ast.Set(exprs*) =>
        toString(exprs)("{", "}")
    println(joinedCollection)
    Ast.Unit
  end printline
end Interpreter
