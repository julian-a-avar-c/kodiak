package kodiak.parser
package expr

import kodiak.parser.ast.*

class ExprSpec extends ParserSpec:

  "Kodiak's expression parser" should "parse a group" in {
    val input    = "(42)"
    val expected = Ast.Integer(42)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.group)
  }

  // --------------------------------------------------------------------------

  "Kodiak's id parser" should "parse a word id" in {
    val input    = "abc"
    val expected = Ast.Id("abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.id)
    assertParse(input, expected, Expr.`word-id`)
  }

  it should "parse a raw word id" in {
    val input    = "`123abc"
    val expected = Ast.Id("123abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.id)
    assertParse(input, expected, Expr.`raw-id`)
  }

  it should "parse a raw block id" in {
    val input    = "`(123abc)"
    val expected = Ast.Id("123abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.id)
    assertParse(input, expected, Expr.`raw-id`)
  }

end ExprSpec
