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
    (Start ~ expr.rep(min = 0) ~ End)
      .map(exprs => Ast.Document(exprs*))

  def expr[$: P] = P:
    import Expr.*

    boolean |
      number |
      NoCut(control) |
      NoCut(collection) |
      NoCut(group) |
      text |
      `raw-number` |
      `raw-id` |
      `function-application` |
      `natural-id`
  end expr

  def keyword[$: P](value: String) = P(value ~~ !ID)(using value, summon)

end Parser
