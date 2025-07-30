package kodiak.parser
package expr
package literal

import kodiak.parser.ast.*

class FunctionSpec extends ParserSpec:

  "Kodiak's function parser" should "parse unit to unit function" in {
    val input    = "() => ()"
    val expected = Ast.Function(Ast.Tuple(), Ast.Tuple())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.function)
  }

  it should "parse a unit to integer function" in {
    val input    = "() => 1"
    val expected = Ast.Function(Ast.Tuple(), Ast.Integer(1))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.function)
  }

  it should "parse a single argument function" in {
    val input    = "(n) => 1"
    val expected =
      Ast.Function(Ast.Tuple(Ast.Id("n")), Ast.Integer(1))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.function)
  }

  it should "parse a two argument function" in {
    val input    = "(n, m) => 1"
    val expected =
      Ast.Function(Ast.Tuple(Ast.Id("n"), Ast.Id("m")), Ast.Integer(1))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Literal.function)
  }

  // --------------------------------------------------------------------------

end FunctionSpec
