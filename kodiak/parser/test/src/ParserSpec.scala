package kodiak.parser

import fastparse.ParsingRun
import fastparse.Parsed.{Success, Failure}
import org.scalactic.source.Position
import org.scalactic.Prettifier
import kodiak.parser.UnitSpec

import kodiak.parser.ast.Ast

abstract class ParserSpec extends UnitSpec:

  inline def assertParse[A <: Ast](
      input: String,
      expected: A,
      parser: ParsingRun[Any] ?=> ParsingRun[A],
  )(using
      prettifier: Prettifier,
      pos: Position,
      use: UseDefaultAssertions.type,
  ) =
    parse(input, Parser) match
      case Success(actual, index) =>
        assert(
          actual == expected,
          s"Expected $expected but got $actual at $index",
        )
      case Failure(msg, index, extra) =>
        fail(s"${extra.trace(enableLogging = true).longAggregateMsg}")
    end match
  end assertParse

end ParserSpec
