package kodiak.ast

sealed trait Ast

case class Document(stmts: Stmts) extends Ast

type Stmts = Seq[Expr]

sealed trait Expr extends Ast

sealed trait Stmt    extends Expr
sealed trait Literal extends Expr
sealed trait Control extends Expr

// ----------------------------------------------------------------------------

case class Val(name: java.lang.String, value: Expr) extends Stmt
case class Var(name: java.lang.String, value: Expr) extends Stmt
case class Set(name: java.lang.String, value: Expr) extends Stmt

// ----------------------------------------------------------------------------

case class Integer(value: scala.Int)     extends Literal
case class Boolean(value: scala.Boolean) extends Literal

// ----------------------------------------------------------------------------

case class If(condition: Expr, thenBranch: Expr, elseBranch: Option[Expr])
    extends Control
case class While(condition: Expr, body: Expr)               extends Control
case class For(enumerators: Seq[For.Generator], body: Expr) extends Control
object For:
  case class Generator(variable: java.lang.String, value: Expr) extends Ast
