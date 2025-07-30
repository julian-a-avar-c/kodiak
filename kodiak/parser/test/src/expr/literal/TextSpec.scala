package kodiak.parser
package expr
package literal

import kodiak.parser.ast.*

class TextSpec extends ParserSpec:

  "Kodiak's text parser" should "parse text word" in {
    val input    = "\"hello"
    val expected = Ast.PlainText("hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`plain-text`)
  }

  it should "parse text tuple-block" in {
    val input    = "\"(hello)"
    val expected = Ast.PlainText("hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`plain-text`)
  }

  it should "parse text sequence-block" in {
    val input    = "\"[hello]"
    val expected = Ast.PlainText("hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`plain-text`)
  }

  it should "parse text set-block" in {
    val input    = "\"{hello}"
    val expected = Ast.PlainText("hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`plain-text`)
  }

  it should "parse interpolated text tuple-block" in {
    val input    = "raw\"(hello)"
    val expected = Ast.RawText(Ast.Id("raw"), "hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-text`)
  }

  it should "parse interpolated text sequence-block" in {
    val input    = "raw\"[hello]"
    val expected = Ast.RawText(Ast.Id("raw"), "hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-text`)
  }

  it should "parse interpolated text set-block" in {
    val input    = "raw\"{hello}"
    val expected = Ast.RawText(Ast.Id("raw"), "hello")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-text`)
  }
end TextSpec
