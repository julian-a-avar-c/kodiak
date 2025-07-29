package kodiak.parser
package expr

import kodiak.parser.ast.*

class DecimalSpec extends ParserSpec:

  "Kodiak's expression parser" should "parse a group" in {
    val input    = "(42)"
    val expected = Ast.Integer(42)

    assertParse(input, expected, Expr.group)
  }

  // --------------------------------------------------------------------------

  "Kodiak's decimal parser" should "parse a single decimal" in {
    val input    = "1.2"
    val expected = Ast.Decimal(1.2)

    assertParse(input, expected, Expr.decimal)
  }

  it should "parse a grouped decimal" in {
    val input    = "123_456.789"
    val expected = Ast.Decimal(123_456.789)

    assertParse(input, expected, Expr.decimal)
  }

  it should "parse a negative decimal" in {
    val input    = "-1.2"
    val expected = Ast.Decimal(-1.2)

    assertParse(input, expected, Expr.decimal)
  }

  it should "parse a positive decimal" in {
    val input    = "+1.2"
    val expected = Ast.Decimal(1.2)

    assertParse(input, expected, Expr.decimal)
  }

  it should "parse a negative grouped decimal" in {
    val input    = "-123_456.789"
    val expected = Ast.Decimal(-123_456.789)

    assertParse(input, expected, Expr.decimal)
  }

  it should "parse a positive grouped decimal" in {
    val input    = "+123_456.789"
    val expected = Ast.Decimal(123_456.789)

    assertParse(input, expected, Expr.decimal)
  }

  // --------------------------------------------------------------------------

  "Kodiak's integer parser" should "parse a single integer" in {
    val input    = "1"
    val expected = Ast.Integer(1)

    assertParse(input, expected, Expr.integer)
  }

  it should "parse a grouped integer" in {
    val input    = "123_456"
    val expected = Ast.Integer(123_456)

    assertParse(input, expected, Expr.integer)
  }

  it should "parse a negative integer" in {
    val input    = "-1"
    val expected = Ast.Integer(-1)

    assertParse(input, expected, Expr.integer)
  }

  it should "parse a positive integer" in {
    val input    = "+1"
    val expected = Ast.Integer(1)

    assertParse(input, expected, Expr.integer)
  }

  it should "parse a negative grouped integer" in {
    val input    = "-123_456"
    val expected = Ast.Integer(-123_456)

    assertParse(input, expected, Expr.integer)
  }

  it should "parse a positive grouped integer" in {
    val input    = "+123_456"
    val expected = Ast.Integer(123_456)

    assertParse(input, expected, Expr.integer)
  }

  // --------------------------------------------------------------------------

  "Kodiak's raw number parser" should "parse a raw block number" in {
    val input    = "f#(123_456.789)"
    val expected = Ast.RawNumber("123_456.789", Ast.Id("f"))

    assertParse(input, expected, Expr.`raw-number`)
  }

  it should "parse a raw word number" in {
    val input    = "f#123_456"
    val expected = Ast.RawNumber("123_456", Ast.Id("f"))

    assertParse(input, expected, Expr.`raw-number`)
  }

end DecimalSpec
