package kodiak.parser.bak

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class CommentSpec extends ParserSpec:

  "Kodiak's comment parser" should "parse singleline comments" in {
    val input    = "(?) Hello, World!"
    val expected = Document()

    assertParse(input, expected, document)
  }

  it should "parse multiline comments" in {
    val input    = "(? Hello, World! ?)"
    val expected = Document()

    assertParse(input, expected, document)
  }

  it should "parse multiple singleline comments" in {
    val input    = "(?) Hello, World!\n(?) Hello, World!"
    val expected = Document()

    assertParse(input, expected, document)
  }

  it should "parse multiple multiline comments" in {
    val input    = "(? Hello, World! ?)\n(? Hello, World! ?)"
    val expected = Document()

    assertParse(input, expected, document)
  }

  ignore should "parse nested multiline comments" in {
    val input    = """(? 1 (? 2 ?) 3 ?)"""
    val expected = Document()

    assertParse(input, expected, document)
  }

end CommentSpec
