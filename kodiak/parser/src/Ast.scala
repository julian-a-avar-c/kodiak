package kodiak.parser

sealed trait Ast derives CanEqual

object Ast:
  case class Program(statements: Stmts) extends Ast
  case class Stmts(value: Seq[Expr])    extends Ast
  abstract class Expr                   extends Ast

  case class Id(value: String)                                      extends Expr
  case class Integer(value: Int)                                    extends Expr
  case class Decimal(value: Double)                                 extends Expr
  case class RawNumber(interpolator: Option[Ast.Id], value: String) extends Expr
  case class Text(value: String)                                    extends Expr
  case class ComplexText(interpolator: Option[Ast.Id], value: String)
      extends Expr
  object RawNumber:
    def apply(value: String): RawNumber = RawNumber(None, value)
end Ast
