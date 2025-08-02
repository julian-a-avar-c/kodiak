package kodiak.parser

private sealed trait Ast
private object Ast:
  class Document() extends Ast
