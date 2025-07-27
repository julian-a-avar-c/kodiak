package kodiak.parser

import fastparse.Parsed.{Success, Failure}

import kodiak.ast.{Document, Expr, Integer}

class ParserSpec extends UnitSpec:
  "Kodiak's parser" should "parse an integer" in {
    val input    = "42"
    val expected = Document(Seq(Integer(42)))

    parse(input) match
      case Success(actual, index) =>
        assert(
          actual == expected,
          s"Expected $expected but got $actual at $index",
        )
      case Failure(msg, index, extra) =>
        fail(s"${extra.trace(enableLogging = true).longAggregateMsg}")
    end match
  }

  // it should "parse a boolean" in {
  //   val input  = "true"
  //   val output = true

  //   parse(input, boolean) match
  //     case Success(Boolean(value), index) =>
  //       assert(value == output)
  //     case Failure(msg, index, extra) =>
  //       fail(s"${extra.trace(enableLogging = true).longAggregateMsg}")
  //   end match
  // }

  // it should "parse a single singleline comment" in {
  //   val input  = "{?} Hello World!"
  //   val output = KodiakParser.Output.empty
  //   assertParse(input, output)
  // }

  // it should "parse a single multiline comment" in {
  //   val input  = "{? Hello World! ?}"
  //   val output = KodiakParser.Output.empty
  //   assertParse(input, output)
  // }

  // it should "parse an integer" in {
  //   val input  = "42"
  //   val output = KodiakParser.Output(
  //     Some(KodiakParser.Integer(input.toInt)),
  //   )
  //   assertParse(input, output)
  // }

  // it should "parse a boolean" in {
  //   val input  = "true"
  //   val output = KodiakParser.Output(
  //     Some(KodiakParser.Boolean(input.toBoolean)),
  //   )
  //   assertParse(input, output)
  // }
end ParserSpec
