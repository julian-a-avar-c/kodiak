package kodiak.parser

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class LiteralSpec extends ParserSpec:

  "Kodiak's text parser" should "parse words" in {
    val input    = """"Hello"""
    val expected = Document(Text("Hello"))

    assertParse(input, expected, document)
  }

  it should "parse parenthesis blocks" in {
    val input    = """"(Hello, World!)"""
    val expected = Document(Text("Hello, World!"))

    assertParse(input, expected, document)
  }

  it should "parse square bracket blocks" in {
    val input    = """"[Hello, World!]"""
    val expected = Document(Text("Hello, World!"))

    assertParse(input, expected, document)
  }

  it should "parse curly bracket blocks" in {
    val input    = """"{Hello, World!}"""
    val expected = Document(Text("Hello, World!"))

    assertParse(input, expected, document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's number parser" should "parse an integer" in {
    val input    = "42"
    val expected = Document(Integer(42))

    assertParse(input, expected, document)
  }

  it should "parse a negative integer" in {
    val input    = "-42"
    val expected = Document(Integer(-42))

    assertParse(input, expected, document)
  }

  it should "parse a decimal" in {
    val input    = "42.31"
    val expected = Document(Decimal(42.31))

    assertParse(input, expected, document)
  }

  it should "parse a negative decimal" in {
    val input    = "-42.31"
    val expected = Document(Decimal(-42.31))

    assertParse(input, expected, document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's parser" should "parse a boolean" in {
    val input    = "true"
    val expected = Document(Boolean(true))

    assertParse(input, expected, document)
  }

  it should "parse a unit" in {
    val input    = "unit"
    val expected = Document(Unit)

    assertParse(input, expected, document)
  }

  // --------------------------------------------------------------------------

  "Kodiak's collection parser" should "parse a tuple" in {
    val input    = "(1, 2, 3)"
    val expected = Document(
      Tuple(Integer(1), Integer(2), Integer(3)),
    )

    assertParse(input, expected, document)
  }

end LiteralSpec
