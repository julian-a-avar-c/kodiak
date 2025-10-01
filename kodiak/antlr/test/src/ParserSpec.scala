package kodiak.antlr

import kodiak.core.utils.valueCanEqualValueOfSameType

import fastparse.*
import org.scalactic.source.Position
import org.scalactic.Prettifier
import org.scalatest.funsuite.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

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
    // assert(true)
    val inputStream       = CharStreams.fromString(input)
    val kodiakLexer       = new KodiakLexer(inputStream)
    val commonTokenStream = new CommonTokenStream(kodiakLexer)
    val kodiakParser      = new KodiakParser(commonTokenStream)
    // println(5)
    val programContext = kodiakParser.program()
    val listener       = new ParserListener
    val visitor        = new ParserVisitor
    // println(visitor.visitProgram(programContext))
    // println(8)
    assert(visitor.visitProgram(programContext) == expected)
  end assertParse

end ParserSpec
