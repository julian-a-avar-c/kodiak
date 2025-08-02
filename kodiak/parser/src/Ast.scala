package kodiak.parser

private sealed trait Ast
private object Ast:
  case class Document(exprs: Expr*) extends Ast
  sealed trait Expr                 extends Ast
  case object True                  extends Expr
  case object False                 extends Expr
end Ast
