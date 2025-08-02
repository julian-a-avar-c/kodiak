package kodiak.parser

import fastparse.*

object Parser:
  def parse[A](input: String, parser: P[?] ?=> P[A]): Parsed[A] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def document[$: P]: P[Ast.Document] =
    P { Start ~~ End }
      .map(_ => Ast.Document())
end Parser
