package kodiak.parser

import fastparse.*

object Parser:
  def parse[A](input: String, parser: P[?] ?=> P[A]): Parsed[A] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def document[$: P]: P[Ast.Document] =
    P { Start ~~ expr.? ~~ End }
      .map(expr => Ast.Document(expr.toSeq*))

  def expr[$: P]: P[Ast.Expr] =
    P { TRUE | FALSE }

  def TRUE[$: P]: P[Ast.True.type] =
    P { "true" ~~ !WS }
      .map(_ => Ast.True)

  def FALSE[$: P]: P[Ast.False.type] =
    P { "false" ~~ !WS }
      .map(_ => Ast.False)

  def WS[$: P]: P[Unit] =
    P { " " }

end Parser
