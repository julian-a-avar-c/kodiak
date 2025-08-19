package kodiak.parser

sealed trait Ast
object Ast:
  case class Document(stmts: Stmt*) extends Ast
  sealed trait Whitespace           extends Ast
  sealed trait Stmt                 extends Ast
  sealed trait Control              extends Ast

  sealed trait Definition  extends Stmt
  sealed trait Expr        extends Stmt
  sealed trait ControlStmt extends Stmt

  case class ValDefinition(id: Id, value: Expr) extends Definition
  case class VarDefinition(id: Id, value: Expr) extends Definition
  case class LetDefinition(id: Id, value: Expr) extends Definition
  case class SetDefinition(id: Id, value: Expr) extends Definition

  case object Singleline extends Whitespace
  case object Newline    extends Whitespace

  sealed trait Literal     extends Expr
  sealed trait ControlExpr extends Expr

  case object True             extends Literal
  case object False            extends Literal
  case object Unit             extends Literal
  sealed trait Number          extends Literal
  case class Id(value: String) extends Literal
  sealed trait Text            extends Literal
  sealed trait Collection      extends Literal:
    val exprs: collection.Iterable[Expr]
  sealed trait Application extends Literal

  case class PlainText(value: String)                 extends Text
  case class RawText(interpolator: Id, value: String) extends Text

  case class Integer(value: Int)                        extends Number
  case class Decimal(value: Double)                     extends Number
  case class RawNumber(interpolator: Id, value: String) extends Number

  case class Tuple(exprs: Expr*) extends Collection
  case class Seq(exprs: Expr*)   extends Collection
  case class Set(_exprs: Expr*)  extends Collection:
    val exprs: scala.collection.mutable.Set[Expr] =
      scala.collection.mutable.Set(_exprs*)
  end Set

  case class FunctionApplication(function: Expr, args: Collection)
      extends Application
  case class PathApplication(receiver: Expr, path: Id) extends Application

  case class If(
      predicate: Expr,
      thenBranch: Expr,
      elseBranch: Option[Expr],
  ) extends ControlExpr
  case class Match(expr: Expr, branches: Match.Branch*) extends ControlExpr
  object Match:
    case class Branch(pattern: Match.Pattern, thenBranch: Expr) extends Ast
    sealed trait Pattern                                        extends Ast

    case class LiteralPattern(literal: Literal) extends Pattern
    case object ElsePattern                     extends Pattern
  end Match

  case class While(
      predicate: Expr,
      body: Expr,
  ) extends ControlStmt
  case class For(
      enumerators: scala.Seq[Ast.For.Enumerator],
      body: Expr,
  ) extends ControlExpr
  object For:
    case class Enumerator(id: Id, expr: Expr) extends Ast
  end For

end Ast
