package kodiak.parser
package expr
package literal

import kodiak.parser.ast.*

class NumberSpec extends ParserSpec:

  // --------------------------------------------------------------------------

  "Kodiak's decimal parser" should "parse a single decimal" in {
    val input    = "1.2"
    val expected = Ast.Decimal(1.2)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  it should "parse a grouped decimal" in {
    val input    = "123_456.789"
    val expected = Ast.Decimal(123_456.789)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  it should "parse a negative decimal" in {
    val input    = "-1.2"
    val expected = Ast.Decimal(-1.2)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  it should "parse a positive decimal" in {
    val input    = "+1.2"
    val expected = Ast.Decimal(1.2)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  it should "parse a negative grouped decimal" in {
    val input    = "-123_456.789"
    val expected = Ast.Decimal(-123_456.789)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  it should "parse a positive grouped decimal" in {
    val input    = "+123_456.789"
    val expected = Ast.Decimal(123_456.789)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`decimal`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's integer parser" should "parse a single integer" in {
    val input    = "1"
    val expected = Ast.Integer(1)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  it should "parse a grouped integer" in {
    val input    = "123_456"
    val expected = Ast.Integer(123_456)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  it should "parse a negative integer" in {
    val input    = "-1"
    val expected = Ast.Integer(-1)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  it should "parse a positive integer" in {
    val input    = "+1"
    val expected = Ast.Integer(1)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  it should "parse a negative grouped integer" in {
    val input    = "-123_456"
    val expected = Ast.Integer(-123_456)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  it should "parse a positive grouped integer" in {
    val input    = "+123_456"
    val expected = Ast.Integer(123_456)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`integer`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's raw number parser" should "parse a number word" in {
    val input    = "f#abc_def"
    val expected = Ast.RawNumber("abc_def", Ast.Id("f"))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-number`)
  }

  it should "parse a parenthesized number block" in {
    val input    = "f#(abc_def.ghi_jfk)"
    val expected = Ast.RawNumber("abc_def.ghi_jfk", Ast.Id("f"))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-number`)
  }

  it should "parse a square bracketed number block" in {
    val input    = "f#[abc_def.ghi_jfk]"
    val expected = Ast.RawNumber("abc_def.ghi_jfk", Ast.Id("f"))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-number`)
  }

  it should "parse a curly bracketed number block" in {
    val input    = "f#{abc_def.ghi_jfk}"
    val expected = Ast.RawNumber("abc_def.ghi_jfk", Ast.Id("f"))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`raw-number`)
  }

end NumberSpec
