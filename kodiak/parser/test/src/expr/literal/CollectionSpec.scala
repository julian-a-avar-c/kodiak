package kodiak.parser
package expr
package literal

import kodiak.parser.ast.*

class CollectionSpec extends ParserSpec:

  "Kodiak's tuple parser" should "parse an empty tuple" in {
    val input    = "()"
    val expected = Ast.Tuple()

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`empty-tuple`)
  }

  it should "parse a single item tuple" in {
    val input    = "(42,)"
    val expected = Ast.Tuple(Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`single-tuple`)
  }

  it should "parse a multi item tuple" in {
    val input    = "(1, 2, 3)"
    val expected = Ast.Tuple(Ast.Integer(1), Ast.Integer(2), Ast.Integer(3))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`multi-tuple`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's sequence parser" should "parse an empty sequence" in {
    val input    = "[]"
    val expected = Ast.Sequence()

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`empty-sequence`)
  }

  it should "parse a single item sequence" in {
    val input    = "[42,]"
    val expected = Ast.Sequence(Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`single-sequence`)
  }

  it should "parse a multi item sequence" in {
    val input    = "[1, 2, 3]"
    val expected = Ast.Sequence(Ast.Integer(1), Ast.Integer(2), Ast.Integer(3))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`multi-sequence`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's set parser" should "parse an empty set" in {
    val input    = "{}"
    val expected = Ast.Set()

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`empty-set`)
  }

  it should "parse a single item set" in {
    val input    = "{42,}"
    val expected = Ast.Set(Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`single-set`)
  }

  it should "parse a multi item set" in {
    val input    = "{1, 2, 3}"
    val expected = Ast.Set(Ast.Integer(1), Ast.Integer(2), Ast.Integer(3))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Literal.collection)
    assertParse(input, expected, Literal.`multi-set`)
  }

end CollectionSpec
