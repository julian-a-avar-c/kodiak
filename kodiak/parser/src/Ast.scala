package kodiak.parser

private sealed trait Ast
private object Ast:
  case class Document() extends Ast
