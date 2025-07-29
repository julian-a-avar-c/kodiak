package kodiak.parser
package expr

import kodiak.parser.ast.*

class CollectionSpec extends ParserSpec:

  "Kodiak's tuple parser" should "parse an empty tuple" in {
    val input    = "()"
    val expected = Ast.Tuple()

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.collection)
    assertParse(input, expected, Expr.tuple)
  }

  it should "parse a single item tuple" in {
    val input    = "(42,)"
    val expected = Ast.Tuple(Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.collection)
    assertParse(input, expected, Expr.tuple)
  }

  it should "parse a multi item tuple" in {
    val input    = "(1, 2, 3)"
    val expected = Ast.Tuple(Ast.Integer(1), Ast.Integer(2), Ast.Integer(3))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.collection)
    assertParse(input, expected, Expr.tuple)
  }

end CollectionSpec
