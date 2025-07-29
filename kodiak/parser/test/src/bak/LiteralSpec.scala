package kodiak.parser.bak

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class LiteralSpec extends ParserSpec:

  "Kodiak's text parser" should "parse words" in {
    val input    = """"Hello"""
    val expected = Text("Hello")

    // assertParse(input, expected, text)
    assertParse(input, Document(expected), document)
  }

  it should "parse parenthesis blocks" in {
    val input    = """"(Hello, World!)"""
    val expected = Text("Hello, World!")

    // assertParse(input, expected, text)
    assertParse(input, Document(expected), document)
  }

  it should "parse square bracket blocks" in {
    val input    = """"[Hello, World!]"""
    val expected = Text("Hello, World!")

    // assertParse(input, expected, text)
    assertParse(input, Document(expected), document)
  }

  it should "parse curly bracket blocks" in {
    val input    = """"{Hello, World!}"""
    val expected = Text("Hello, World!")

    // assertParse(input, expected, text)
    assertParse(input, Document(expected), document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's number parser" should "parse an integer" in {
    val input    = "42"
    val expected = Integer(42)

    assertParse(input, expected, integer)
    assertParse(input, Document(expected), document)
  }

  it should "parse a negative integer" in {
    val input    = "-42"
    val expected = Integer(-42)

    assertParse(input, expected, integer)
    assertParse(input, Document(expected), document)
  }

  it should "parse a separated integer" in {
    val input    = "123_456"
    val expected = Integer(123_456)

    assertParse(input, expected, integer)
    assertParse(input, Document(expected), document)
  }

  it should "parse a decimal" in {
    val input    = "42.31"
    val expected = Decimal(42.31)

    assertParse(input, expected, decimal)
    assertParse(input, Document(expected), document)
  }

  it should "parse a negative decimal" in {
    val input    = "-42.31"
    val expected = Decimal(-42.31)

    assertParse(input, expected, decimal)
    assertParse(input, Document(expected), document)
  }

  it should "parse a separated decimal" in {
    val input    = "12_34.56_78"
    val expected = Decimal(12_34.56_78)

    assertParse(input, expected, decimal)
    assertParse(input, Document(expected), document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's generic literal parser" should "parse a boolean" in {
    val input    = "true"
    val expected = Boolean(true)

    assertParse(input, expected, boolean)
    assertParse(input, Document(expected), document)
  }

  it should "parse a unit" in {
    val input    = "unit"
    val expected = Unit

    assertParse(input, expected, unit)
    assertParse(input, Document(expected), document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's collection parser" should "parse an empty tuple" in {
    val input    = "()"
    val expected = Tuple(Exprs())

    assertParse(input, expected, tuple)
    assertParse(input, Document(expected), document)
  }

  it should "parse a single item tuple" in {
    val input    = "(1,)"
    val expected = Tuple(Exprs(Integer(1)))

    assertParse(input, expected, tuple)
    assertParse(input, Document(expected), document)
  }

  it should "parse a tuple" in {
    val input    = "(1, 2, 3)"
    val expected = Tuple(Exprs(Integer(1), Integer(2), Integer(3)))

    assertParse(input, expected, tuple)
    assertParse(input, Document(expected), document)
  }

  ignore should "parse a sequence" in {
    val input    = "[1, 2, 3]"
    val expected = Sequence(Exprs(Integer(1), Integer(2), Integer(3)))

    // assertParse(input, expected, sequence)
    assertParse(input, Document(expected), document)
  }

  ignore should "parse a set" in {
    val input    = "{1, 2, 3}"
    val expected = Set(Exprs(Integer(1), Integer(2), Integer(3)))

    // assertParse(input, expected, set)
    assertParse(input, Document(expected), document)
  }

end LiteralSpec
