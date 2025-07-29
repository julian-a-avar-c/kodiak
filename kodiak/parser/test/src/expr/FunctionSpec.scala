package kodiak.parser
package expr

import kodiak.parser.ast.*

class FunctionSpec extends ParserSpec:

  "Kodiak's application parser" should "parse an empty tuple application" in {
    val input    = "function()"
    val expected = Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a tuple grouping application" in {
    val input    = "function(1)"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a 1 element tuple application" in {
    val input    = "function(1,)"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a 2 element tuple application" in {
    val input    = "function(1, 2)"
    val expected = Ast.FunctionApplication(
      Ast.Id("function"),
      Ast.Tuple(Ast.Integer(1), Ast.Integer(2)),
    )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse an empty sequence application" in {
    val input    = "function[]"
    val expected = Ast.FunctionApplication(Ast.Id("function"), Ast.Sequence())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a sequence grouping application" in {
    val input    = "function[1]"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a 1 element sequence application" in {
    val input    = "function[1,]"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Sequence(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

  it should "parse a 2 element sequence application" in {
    val input    = "function[1, 2]"
    val expected = Ast.FunctionApplication(
      Ast.Id("function"),
      Ast.Sequence(Ast.Integer(1), Ast.Integer(2)),
    )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`function-application`)
  }

end FunctionSpec
