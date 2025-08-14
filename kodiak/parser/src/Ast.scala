package kodiak.parser

sealed trait Ast
object Ast:
  case class Document(stmts: Stmt*) extends Ast
  sealed trait Whitespace           extends Ast
  sealed trait Stmt                 extends Ast

  sealed trait Definition extends Stmt
  sealed trait Expr       extends Stmt

  case class ValDefinition(id: Id, value: Expr) extends Definition
  case class VarDefinition(id: Id, value: Expr) extends Definition
  case class LetDefinition(id: Id, value: Expr) extends Definition
  case class SetDefinition(id: Id, value: Expr) extends Definition

  case object Singleline extends Whitespace
  case object Newline    extends Whitespace

  case object True             extends Expr
  case object False            extends Expr
  case object Unit             extends Expr
  sealed trait Number          extends Expr
  case class Id(value: String) extends Expr
  sealed trait Text            extends Expr
  sealed trait Collection      extends Expr
  sealed trait Application     extends Expr
  sealed trait Control         extends Expr

  case class PlainText(value: String)                 extends Text
  case class RawText(interpolator: Id, value: String) extends Text

  case class Integer(value: Int)                        extends Number
  case class Decimal(value: Double)                     extends Number
  case class RawNumber(interpolator: Id, value: String) extends Number

  case class Tuple(exprs: Expr*) extends Collection
  case class Seq(exprs: Expr*)   extends Collection
  case class Set(exprs: Expr*)   extends Collection

  case class FunctionApplication(function: Expr, argsGroups: Collection*)
      extends Application
  case class PathApplication(receiver: Expr, paths: Ast.Id*) extends Application

  case class If(
      predicate: Ast.Expr,
      thenBranch: Ast.Expr,
      elseBranch: Option[Ast.Expr],
  ) extends Control
  case class While(
      predicate: Ast.Expr,
      body: Ast.Expr,
  ) extends Control
end Ast
