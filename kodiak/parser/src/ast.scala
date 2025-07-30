package kodiak.parser
package ast

sealed trait Ast
object Ast:
  case class Document(value: Expr*) extends Ast
  sealed trait Expr                 extends Ast

  case class Id(value: String)                            extends Expr
  sealed trait Unit                                       extends Expr
  object Unit                                             extends Unit
  sealed trait Boolean                                    extends Expr
  sealed trait Number                                     extends Expr
  sealed trait Text                                       extends Expr
  sealed trait Collection                                 extends Expr
  case class Function(params: Ast.Collection, body: Expr) extends Expr
  sealed trait Control                                    extends Expr
  sealed trait Definition                                 extends Expr
  sealed trait Application                                extends Expr

  case object True  extends Boolean
  case object False extends Boolean

  case class Integer(value: Int)                        extends Number
  case class Decimal(value: Double)                     extends Number
  case class RawNumber(value: String, interpolator: Id) extends Number

  case class PlainText(value: String)                 extends Text
  case class RawText(interpolator: Id, value: String) extends Text

  case class Tuple(exprs: Expr*)    extends Collection
  case class Sequence(exprs: Expr*) extends Collection
  case class Set(exprs: Expr*)      extends Collection

  case class If(
      condition: Expr,
      thenBranch: Expr,
      elseBranch: Option[Expr] = None,
  ) extends Control
  case class Match(
      selector: Expr,
      patterns: Match.Pattern*,
  ) extends Control
  case class While(condition: Expr, body: Expr)              extends Control
  case class For(generators: Seq[For.Generator], body: Expr) extends Control
  object Match:
    sealed trait Pattern               extends Ast
    case class ElsePattern(body: Expr) extends Pattern
  object For:
    case class Generator(lhs: Id, rhs: Expr) extends Ast

  case class ValDefinition(lhs: Id, rhs: Expr) extends Definition
  case class VarDefinition(lhs: Id, rhs: Expr) extends Definition
  case class SetDefinition(lhs: Id, rhs: Expr) extends Definition
  case class LetDefinition(lhs: Id, rhs: Expr) extends Definition

  case class FunctionApplication(function: Expr, args: Collection*)
      extends Application
  case class MethodApplication(receiver: Expr, method: Id, args: Collection*)
      extends Application
  case class OperatorApplication(left: Expr, operator: Id, right: Expr)
      extends Application
end Ast
