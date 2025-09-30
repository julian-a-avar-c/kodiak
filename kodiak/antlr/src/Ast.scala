package kodiak.antlr

case class ParserException(message: String) extends Exception(message)

sealed trait Ast
object Ast:
  case class Program(stmts: Stmts) extends Ast
  case class Stmts(stmtSeq: Stmt*) extends Ast
  sealed trait Whitespace          extends Ast
  sealed trait Stmt                extends Ast
  sealed trait Control             extends Ast

  sealed trait Decl    extends Stmt
  sealed trait Expr    extends Stmt
  sealed trait CtlStmt extends Stmt

  case class ValDecl(id: Id, op: Id, value: Expr) extends Decl derives CanEqual
  case class VarDecl(id: Id, op: Id, value: Expr) extends Decl
  case class LetDecl(id: Id, op: Id, value: Expr) extends Decl
  case class SetDecl(id: Id, op: Id, value: Expr) extends Decl

  case object Singleline extends Whitespace
  case object Newline    extends Whitespace

  sealed trait Literal                                            extends Expr
  sealed trait CtlExpr                                            extends Expr
  case class Block(heads: scala.collection.Seq[Stmt], last: Expr) extends Expr

  case object True             extends Literal
  case object False            extends Literal
  case object Unit             extends Literal
  case class Id(value: String) extends Literal
  sealed trait Number          extends Literal
  sealed trait Text            extends Literal
  sealed trait Application     extends Literal
  sealed trait Collection      extends Literal:
    val exprs: collection.Iterable[Expr]

  case class PlainText(value: String)                 extends Text
  case class RawText(interpolator: Id, value: String) extends Text

  case class Integer(value: Int)                        extends Number
  case class Decimal(value: Double)                     extends Number
  case class RawNumber(interpolator: Id, value: String) extends Number

  case class Tuple(exprs: Expr*)            extends Collection
  case class Seq(exprs: Expr*)              extends Collection
  case class Set(private val _exprs: Expr*) extends Collection:
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
  ) extends CtlExpr
  case class Match(expr: Expr, branches: Match.Branch*) extends CtlExpr
  object Match:
    case class Branch(pattern: Match.Pattern, thenBranch: Expr) extends Ast
    sealed trait Pattern                                        extends Ast

    case class LiteralPattern(literal: Literal) extends Pattern
    case object ElsePattern                     extends Pattern
  end Match

  case class While(
      predicate: Expr,
      body: Expr,
  ) extends CtlStmt
  case class For(
      enumerators: scala.Seq[Ast.For.Enumerator],
      body: Expr,
  ) extends CtlExpr
  object For:
    case class Enumerator(id: Id, expr: Expr) extends Ast
  end For

end Ast
