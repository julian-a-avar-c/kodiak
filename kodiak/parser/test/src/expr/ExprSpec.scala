package kodiak.parser
package expr

import kodiak.parser.ast.*

class ExprSpec extends ParserSpec:

  "Kodiak's id parser" should "parse a word id" in {
    val input    = "abc"
    val expected = Ast.Id("abc")

    assertParse(input, expected, Expr.`word-id`)
  }

  it should "parse a raw word id" in {
    val input    = "`123abc"
    val expected = Ast.Id("123abc")

    assertParse(input, expected, Expr.`raw-id`)
  }

  it should "parse a raw block id" in {
    val input    = "`(123abc)"
    val expected = Ast.Id("123abc")

    assertParse(input, expected, Expr.`raw-id`)
  }

end ExprSpec
