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
      decimal |
      integer |
      NoCut(`if`) |
      NoCut(`match`) |
      NoCut(`while`) |
      NoCut(`for`) |
      NoCut(tuple) |
      NoCut(group) |
      `raw-number` |
      `raw-id` |
      `function-application` |
      `word-id`
  end expr

  def keyword[$: P](value: String) = P(value ~~ !ID)(using value, summon)

end Parser
