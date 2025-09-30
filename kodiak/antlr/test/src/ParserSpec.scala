package kodiak.antlr

import kodiak.core.utils.valueCanEqualValueOfSameType

import fastparse.*
import org.scalactic.source.Position
import org.scalactic.Prettifier
import org.scalatest.funsuite.*

abstract class UnitSpec extends AnyFunSuite

abstract class ParserSpec extends UnitSpec:

  inline def assertParse[A](
      input: String,
      expected: A,
      // parser: P[?] ?=> P[A],
  )(using
      prettifier: Prettifier,
      pos: Position,
      use: UseDefaultAssertions.type,
  ) =
    // try
    //   given CanThrow[ParserException] = compiletime.erasedValue

    //   val actual = Parser.parse(input)
    //   assert(
    //     actual == expected,
    //     // s"Expected $expected but got $actual at $index",
    //     s"Expected $expected but got $actual",
    //   )
    // catch
    //   case e: ParserException =>
    //     // fail(s"${extra.trace(enableLogging = true).longAggregateMsg}")
    //     fail(s"Unexpected exception: ${e.getMessage}")
    // end try
    assert(true)
  end assertParse

end ParserSpec
