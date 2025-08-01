package kodiak.parser
package expr

import kodiak.parser.ast.*

class ApplicationSpec extends ParserSpec:

  "Kodiak's application parser" should "parse an empty tuple application" in {
    val input    = "function()"
    val expected = Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a tuple grouping application" in {
    val input    = "function(1)"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 1 element tuple application" in {
    val input    = "function(1,)"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 2 element tuple application" in {
    val input    = "function(1, 2)"
    val expected = Ast.FunctionApplication(
      Ast.Id("function"),
      Ast.Tuple(Ast.Integer(1), Ast.Integer(2)),
    )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse an empty sequence application" in {
    val input    = "function[]"
    val expected = Ast.FunctionApplication(Ast.Id("function"), Ast.Sequence())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a sequence grouping application" in {
    val input    = "function[1]"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Sequence(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 1 element sequence application" in {
    val input    = "function[1,]"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Sequence(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 2 element sequence application" in {
    val input    = "function[1, 2]"
    val expected = Ast.FunctionApplication(
      Ast.Id("function"),
      Ast.Sequence(Ast.Integer(1), Ast.Integer(2)),
    )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse an empty set application" in {
    val input    = "function{}"
    val expected = Ast.FunctionApplication(Ast.Id("function"), Ast.Set())

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a set grouping application" in {
    val input    = "function{1}"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Set(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 1 element set application" in {
    val input    = "function{1,}"
    val expected =
      Ast.FunctionApplication(Ast.Id("function"), Ast.Set(Ast.Integer(1)))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a 2 element set application" in {
    val input    = "function{1, 2}"
    val expected = Ast.FunctionApplication(
      Ast.Id("function"),
      Ast.Set(Ast.Integer(1), Ast.Integer(2)),
    )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  // --------------------------------------------------------------------------

  "Kodiak's path application parser" should "parse a simple selector" in {
    val input    = "duck.name"
    val expected =
      Ast.PathApplication(
        Ast.Id("duck"),
        Ast.Id("name"),
      )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a nested selector" in {
    val input    = "duck.name.length"
    val expected =
      Ast.PathApplication(
        Ast.PathApplication(
          Ast.Id("duck"),
          Ast.Id("name"),
        ),
        Ast.Id("length"),
      )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  it should "parse a function selector" in {
    val input    = "duck.set-name(\"[John])"
    val expected =
      Ast.FunctionApplication(
        Ast.PathApplication(
          Ast.Id("duck"),
          Ast.Id("set-name"),
        ),
        Ast.Tuple(Ast.PlainText("John")),
      )

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
  }

  // --------------------------------------------------------------------------

  "Kodiak's operator application parser" should "parse a sum of two integers" in {
    val input    = "2 + 3"
    val expected =
      Ast.OperatorApplication(Ast.Integer(2), Ast.Id("+"), Ast.Integer(3))

    // assertParse(input, Ast.Document(expected), Parser.document)
    // assertParse(input, expected, Parser.expr)
    // assertParse(input, expected, Expr.`operator-application`)
  }

end ApplicationSpec
