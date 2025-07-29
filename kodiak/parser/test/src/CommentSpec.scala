package kodiak.parser
import kodiak.parser.ParserSpec

import kodiak.parser.ast.*

class CommentSpec extends ParserSpec:

  "Kodiak's comment parser" should "parse a single singleline comment" in {
    val input    = "(?) Hello, World!"
    val expected = Ast.Document()

    assertParse(input, expected, Parser.document)
  }

  it  should "parse a single multiline comment" in {
    val input    = "(? Hello, World! ?)"
    val expected = Ast.Document()

    assertParse(input, expected, Parser.document)
  }

end CommentSpec
