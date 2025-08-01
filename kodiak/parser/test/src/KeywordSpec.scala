package kodiak.parser

import kodiak.parser.ast.*

class KeywordSpec extends ParserSpec:

  "Kodiak's unit parser" should "parse unit" in {
    val input    = "unit"
    val expected = Ast.Unit

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Terminal.UNIT)
  }

  // --------------------------------------------------------------------------

  "Kodiak's boolean parser" should "parse true" in {
    val input    = "true"
    val expected = Ast.True

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Terminal.TRUE)
  }

  it should "parse false" in {
    val input    = "false"
    val expected = Ast.False

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Terminal.FALSE)
  }

  // --------------------------------------------------------------------------

end KeywordSpec
