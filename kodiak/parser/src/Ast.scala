package kodiak.parser.ast

sealed trait Ast

case class Document(stmts: Expr*) extends Ast

type Stmts = scala.Seq[Expr]

sealed trait Expr extends Ast

sealed trait Application extends Expr
sealed trait Stmt        extends Expr
sealed trait Literal     extends Expr
sealed trait Control     extends Expr

// ----------------------------------------------------------------------------

case class FunctionApplication(function: Expr, args: Literal.Collection)
    extends Application

case class ObjectApplication(
    subject: Expr,
    method: Literal.Id,
    args: scala.Seq[Expr],
) extends Application

// ----------------------------------------------------------------------------

sealed trait Definition extends Stmt

object Stmt:
  case class Val(name: Literal.Id, value: Expr) extends Definition
  case class Var(name: Literal.Id, value: Expr) extends Definition
  case class Set(name: Literal.Id, value: Expr) extends Definition

// ----------------------------------------------------------------------------

object Literal:
  case class Id(value: java.lang.String) extends Literal

  case object Unit extends Literal
  type Unit = Unit.type
  case class Boolean(value: scala.Boolean) extends Literal
  sealed trait Number                      extends Literal
  case class Text(value: java.lang.String) extends Literal
  sealed trait Collection                  extends Literal

  case class Integer(value: scala.Int)    extends Number
  case class Decimal(value: scala.Double) extends Number

  case class Tuple(values: Expr*)    extends Collection
  case class Sequence(values: Expr*) extends Collection
  case class Set(values: Expr*)      extends Collection
end Literal

// ----------------------------------------------------------------------------

case class If(condition: Expr, thenBranch: Expr, elseBranch: Option[Expr])
    extends Control
case class Match(selector: Expr, clauses: Seq[Match.Clause]) extends Control
object Match:
  sealed trait Clause                                 extends Ast
  case class PatternClause(pattern: Expr, body: Expr) extends Clause
  case class ElseClause(body: Expr)                   extends Clause

case class While(condition: Expr, body: Expr)               extends Control
case class For(generators: Seq[For.Generator], body: Expr) extends Control
object For:
  sealed trait Generator                                     extends Ast
  case class ExtractorGenerator(id: Literal.Id, value: Expr) extends Generator
  case class ExpressionGenerator(expr: Expr)                 extends Generator
