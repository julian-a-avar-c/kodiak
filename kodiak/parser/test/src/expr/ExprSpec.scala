package kodiak.parser
package expr

import kodiak.parser.ast.*

class ExprSpec extends ParserSpec:

  "Kodiak's expression parser" should "parse a tuple-group" in {
    val input    = "(42)"
    val expected = Ast.Integer(42)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`group-tuple`)
  }

  it should "parse a sequence-group" in {
    val input    = "[42]"
    val expected = Ast.Integer(42)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`group-sequence`)
  }

  it should "parse a set-group" in {
    val input    = "{42}"
    val expected = Ast.Integer(42)

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.`group-set`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's id parser" should "parse a word id" in {
    val input    = "abc"
    val expected = Ast.Id("abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(
    //   input,
    //   expected,
    //   (NoCut(`raw-block-id`) | NoCut(`raw-word-id`) | `plain-id`),
    // )
    assertParse(input, expected, Literal.`plain-id`)
  }

  it should "parse a raw id word" in {
    val input    = "`123abc"
    val expected = Ast.Id("123abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(
    //   input,
    //   expected,
    //   (NoCut(`raw-block-id`) | NoCut(`raw-word-id`) | `plain-id`),
    // )
    assertParse(input, expected, Literal.`raw-id`)
  }

  it should "parse a parenthesized id block" in {
    val input    = "`(123 abc)"
    val expected = Ast.Id("123 abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(
    //   input,
    //   expected,
    //   (NoCut(`raw-block-id`) | NoCut(`raw-word-id`) | `plain-id`),
    // )
    assertParse(input, expected, Literal.`raw-id`)
  }

  it should "parse a square bracket id block" in {
    val input    = "`[123 abc]"
    val expected = Ast.Id("123 abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(
    //   input,
    //   expected,
    //   id,
    // )
    assertParse(input, expected, Literal.`raw-id`)
  }

  it should "parse a curly bracket id block" in {
    val input    = "`{123 abc}"
    val expected = Ast.Id("123 abc")

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    // assertParse(
    //   input,
    //   expected,
    //   (NoCut(`raw-block-id`) | NoCut(`raw-word-id`) | `plain-id`),
    // )
    assertParse(input, expected, Literal.`raw-id`)
  }

end ExprSpec
