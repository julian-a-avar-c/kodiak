package kodiak.antlr

case class ParserException(message: String) extends Exception(message)

sealed trait Ast
object Ast:
  case class Program(stmts: Ast.Stmts) extends Ast
  case class Stmts(value: Stmt*)       extends Ast
  sealed trait Stmt                    extends Ast
  object Program:
    def apply(stmts: Ast.Stmt*): Ast.Program = Ast.Program(Ast.Stmts(stmts*))
    def empty                                = Ast.Program(Ast.Stmts())

  sealed trait Expr extends Stmt

  case object Unit            extends Expr
  case class Id(name: String) extends Expr
  sealed trait Boolean        extends Expr
  sealed trait Text           extends Expr
  sealed trait Number         extends Expr
  sealed trait Collection     extends Expr
  sealed trait App            extends Expr

  case object True  extends Expr
  case object False extends Expr

  case class PlainText(value: String)                       extends Text
  case class RawText(interpolator: Ast.Expr, value: String) extends Text

  case class Integer(value: Int)                              extends Number
  case class Decimal(value: Double)                           extends Number
  case class RawNumber(interpolator: Ast.Expr, value: String) extends Number

  case class FnApp(fn: Expr, args: Ast.Collection)      extends App
  case class PathApp(receiver: Expr, member: Ast.Expr)  extends App
  case class OpApp(left: Expr, op: Ast.Id, right: Expr) extends App

  case class Tuple(items: Collection.Items) extends Collection
  case class Array(items: Collection.Items) extends Collection
  case class Set(items: Collection.Items)   extends Collection
  object Collection:
    class Items(value: Expr*) extends Ast
  object Tuple:
    def apply(items: Expr*): Ast.Tuple = Ast.Tuple(Ast.Collection.Items(items*))
  object Array:
    def apply(items: Expr*): Ast.Array = Ast.Array(Ast.Collection.Items(items*))
  object Set:
    def apply(items: Expr*): Ast.Set = Ast.Set(Ast.Collection.Items(items*))
end Ast
