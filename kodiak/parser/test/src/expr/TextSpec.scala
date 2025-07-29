package kodiak.parser
package expr

import kodiak.parser.ast.*

class TextSpec extends ParserSpec:

  "Kodiak's text parser" should "parse text word" in {
    val input    = "\"hello"
    val expected = Ast.Text("hello")

    // assertParse(input, Ast.Document(expected), Parser.document)
    // assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.text)
  }
end TextSpec
