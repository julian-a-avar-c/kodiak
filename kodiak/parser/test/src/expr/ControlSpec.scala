package kodiak.parser
package expr

import kodiak.parser.ast.*

class ControlSpec extends ParserSpec:

  "Kodiak's if parser" should "parse an if expression" in {
    val input    = "if true then 42"
    val expected = Ast.If(Ast.True, Ast.Integer(42))

    assertParse(input, expected, Expr.`if`)
  }

  it should "parse an if-else expression" in {
    val input    = "if true then 42 else 69"
    val expected = Ast.If(Ast.True, Ast.Integer(42), Some(Ast.Integer(69)))

    assertParse(input, expected, Expr.`if`)
  }

  it should "parse an if-else-if expression" in {
    val input    = "if true then 42 else if true then 69"
    val expected =
      Ast.If(Ast.True, Ast.Integer(42), Some(Ast.If(Ast.True, Ast.Integer(69))))

    assertParse(input, expected, Expr.`if`)
  }

  it should "parse an if-else-if-else expression" in {
    val input    = "if true then 42 else if true then 69 else 7"
    val expected = Ast.If(
      Ast.True,
      Ast.Integer(42),
      Some(Ast.If(Ast.True, Ast.Integer(69), Some(Ast.Integer(7)))),
    )

    assertParse(input, expected, Expr.`if`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's match parser" should "parse a match expression with a single else" in {
    val input    = "match 42 else 7"
    val expected =
      Ast.Match(Ast.Integer(42), Ast.Match.ElsePattern(Ast.Integer(7)))

    assertParse(input, expected, Expr.`match`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's while parser" should "parse an while-do expression" in {
    val input    = "while true do 7"
    val expected = Ast.While(Ast.True, Ast.Integer(7))

    assertParse(input, expected, Expr.`while`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's for parser" should "parse an for-do expression" in {
    val input    = "for let i = (1, 2, 3) do 7"
    val expected = Ast.For(
      Seq(
        Ast.For.Generator(
          Ast.Id("i"),
          Ast.Tuple(Ast.Integer(1), Ast.Integer(2), Ast.Integer(3)),
        ),
      ),
      Ast.Integer(7),
    )

    assertParse(input, expected, Expr.`for`)
  }

end ControlSpec
