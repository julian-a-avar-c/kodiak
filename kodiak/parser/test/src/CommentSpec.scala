package kodiak.parser
import kodiak.parser.ParserSpec

import kodiak.parser.ast.*

class CommentSpec extends ParserSpec:

  "Kodiak's comment parser" should "parse singleline comments" in {
    // val input    = "(?) Hello, World!"
    // val expected = Document()

    // assertParse(input, expected, document)
  }

  "Kodiak's literal parser" should "parse positive integers" in {
    val input    = "1"
    val expected = Ast.Integer(1)

    assertParse(input, expected, Parser)
  }

end CommentSpec
