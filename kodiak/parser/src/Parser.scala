package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

import ast.*
import Terminal.*

object Parser:

  def parse[T <: Ast](
      input: String,
      parser: ParsingRun[Any] ?=> ParsingRun[T],
  ): Parsed[T] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def document[$: P] = P:
    import KodiakWhitespace.given
    (Start ~ line.rep(min = 0) ~ End)
      .map(exprs => Ast.Document(exprs*))

  def line[$: P] = P:
    import KodiakSinglelineWhitespace.given
    expr ~ ("\n" | ";")

  def expr[$: P]: P[Ast.Expr] = P:
    import Expr.*
    import Literal.*

    boolean |
      number |
      NoCut(control) |
      NoCut(`val-definition`) |
      NoCut(`var-definition`) |
      NoCut(`set-definition`) |
      NoCut(`let-definition`) |
      // NoCut(function) |
      NoCut(`function-application`) |
      NoCut(collection) |
      NoCut(group) |
      `raw-number` |
      `raw-id` |
      `plain-text` |
      `raw-text` |
      // NoCut(`operator-application`) |
      // `method-application` |
      `plain-id`
  end expr

  def keyword[$: P](value: String) = P(value ~~ !ID)(using value, summon)

end Parser
