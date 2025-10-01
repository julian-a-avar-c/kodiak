package kodiak.antlr

case class ParserException(message: String) extends Exception(message)

sealed trait Ast
object Ast:
  case class Program(stmts: Stmts) extends Ast
  case class Stmts(stmt: Stmt*)    extends Ast
  sealed trait Stmt                extends Ast
  sealed trait Ctl                 extends Ast
  object Program:
    inline def empty = Program(Stmts.empty)
  object Stmts:
    inline def empty = Stmts(Seq.empty*)

  sealed trait Decl extends Stmt
  sealed trait Expr extends Stmt

  case class ValDecl(id: Ast.Id, eq: Ast.Id, expr: Ast.Expr) extends Decl

  case object Unit                           extends Expr
  sealed trait Boolean(value: scala.Boolean) extends Expr
  case class Text(value: String)             extends Expr
  sealed trait Collection                    extends Expr
  sealed trait Number                        extends Expr
  case class Id(value: String)               extends Expr
  sealed trait App                           extends Expr

  case object True  extends Boolean(true)
  case object False extends Boolean(false)

  case class Tuple(items: Collection.Items) extends Collection
  case class Array(items: Collection.Items) extends Collection
  case class Set(items: Collection.Items)   extends Collection
  object Collection:
    case class Items(seq: Seq[Ast.Expr]) extends Ast

  case class Decimal(value: Double)                extends Number
  case class Integer(value: Int)                   extends Number
  case class MetaNumber(fn: Ast.Id, value: String) extends Number

  case class FnApp(fn: Ast.Expr, args: Ast.Collection) extends App
  case class PathApp(fn: Ast.Expr, path: Ast.Id)       extends App

  case class If(cond: Ast.Expr, thenBranch: Ast.Expr, elseBranch: Ast.Expr)
      extends Expr,
        Ctl
  case class Match(cond: Ast.Expr, branches: Seq[Match.Branch])
      extends Expr,
        Ctl
  case class For(generators: Seq[For.Generator], body: Ast.Expr)
      extends Expr,
        Ctl
  case class While(cond: Ast.Expr, body: Ast.Expr) extends Stmt, Ctl

  object Match:
    case class Branch(pattern: Match.Pattern, expr: Ast.Expr) extends Ast
    sealed trait Pattern                                      extends Ast
    case class Else(value: Ast.Expr)                          extends Pattern
  end Match

  object For:
    case class Generator(id: Ast.Id, expr: Ast.Expr) extends Ast
  end For

end Ast
