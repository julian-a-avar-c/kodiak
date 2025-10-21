package kodiak.parser

sealed trait Ast derives CanEqual

object Ast:
  case class Program(statements: Stmts) extends Ast
  case class Stmts(value: Seq[Expr])    extends Ast
  abstract class Expr                   extends Ast

  case object True                                               extends Ast.Expr
  case object False                                              extends Ast.Expr
  case class OpApp(left: Ast.Expr, op: Ast.Id, right: Ast.Expr)  extends Ast.Expr
  case class If(
      condition: Ast.Expr,
      consequent: Ast.Expr,
      alternative: Ast.Expr,
  ) extends Ast.Expr
  case class Id(value: String)                                   extends Ast.Expr
  case class Integer(value: Int)                                 extends Ast.Expr
  case class Decimal(value: Double)                              extends Ast.Expr
  case class RawNumber(interpolator: Option[Ast.Id], value: String)
      extends Ast.Expr
  case class Text(value: String)                                 extends Ast.Expr
  case class ComplexText(interpolator: Option[Ast.Id], value: String)
      extends Ast.Expr
  object RawNumber:
    def apply(value: String): RawNumber = RawNumber(None, value)
  case class Match(scrutinee: Ast.Expr, patterns: Seq[Ast.MatchPattern])
      extends Ast.Expr
  case class MatchPattern(guard: Ast.MatchGuard, body: Ast.Expr) extends Ast
  sealed trait MatchGuard                                        extends Ast
  object MatchGuard:
    case object Else                               extends Ast.MatchGuard
    case class UntypedSimpleExpr(`with`: Ast.Expr) extends Ast.MatchGuard
end Ast
