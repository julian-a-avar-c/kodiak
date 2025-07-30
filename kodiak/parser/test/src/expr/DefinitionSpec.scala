package kodiak.parser
package expr

import kodiak.parser.ast.*

class DefinitionSpec extends ParserSpec:

  "Kodiak's val definition parser" should "parse a val expression" in {
    val input    = "val x = 42"
    val expected = Ast.ValDefinition(Ast.Id("x"), Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`val-definition`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's var definition parser" should "parse a var expression" in {
    val input    = "var x = 42"
    val expected = Ast.VarDefinition(Ast.Id("x"), Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`var-definition`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's set definition parser" should "parse a set expression" in {
    val input    = "set x = 42"
    val expected = Ast.SetDefinition(Ast.Id("x"), Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`set-definition`)
  }

  // --------------------------------------------------------------------------

  "Kodiak's let definition parser" should "parse a let expression" in {
    val input    = "let x = 42"
    val expected = Ast.LetDefinition(Ast.Id("x"), Ast.Integer(42))

    assertParse(input, Ast.Document(expected), Parser.document)
    assertParse(input, expected, Parser.expr)
    assertParse(input, expected, Expr.`let-definition`)
  }

end DefinitionSpec
