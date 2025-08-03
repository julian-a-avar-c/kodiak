package kodiak.parser

import kodiak.parser.{Ast, Parser}
import kodiak.parser.ParserSpec

class ExprSpec extends ParserSpec:
  test("Raw id") {
    assertParse(
      input = "`{a very important number}",
      expected = Ast.Document(Ast.Id("a very important number")),
      Parser.Document,
    )
  }
  test("Plain id") {
    assertParse(
      input = "number",
      expected = Ast.Document(Ast.Id("number")),
      Parser.Document,
    )
  }
  test("Raw id function application with empty args") {
    assertParse(
      input = "`{a very important function}()",
      expected = Ast.Document(
        Ast
          .FunctionApplication(Ast.Id("a very important function"), Ast.Tuple()),
      ),
      Parser.Document,
    )
  }
  test("Plain id function application with empty args") {
    assertParse(
      input = "function()",
      expected = Ast.Document(
        Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple()),
      ),
      Parser.Document,
    )
  }
  test("Plain id function application with arg tuple group") {
    assertParse(
      input = "function(1)",
      expected = Ast.Document(
        Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1))),
      ),
      Parser.Document,
    )
  }
  test("Plain id function application with arg tuple of 1 item") {
    assertParse(
      input = "function(1,)",
      expected = Ast.Document(
        Ast.FunctionApplication(Ast.Id("function"), Ast.Tuple(Ast.Integer(1))),
      ),
      Parser.Document,
    )
  }
  test("Plain id function application with arg tuple of 2 item") {
    assertParse(
      input = "function(1,2)",
      expected = Ast.Document(
        Ast.FunctionApplication(
          Ast.Id("function"),
          Ast.Tuple(Ast.Integer(1), Ast.Integer(2)),
        ),
      ),
      Parser.Document,
    )
  }
  test(
    "Plain id function application with arg tuple of 2 item with optional comma",
  ) {
    assertParse(
      input = "function(1,2,)",
      expected = Ast.Document(
        Ast.FunctionApplication(
          Ast.Id("function"),
          Ast.Tuple(Ast.Integer(1), Ast.Integer(2)),
        ),
      ),
      Parser.Document,
    )
  }
  test("Raw id path application with empty args") {
    assertParse(
      input = "`{abc}.def",
      expected = Ast.Document(
        Ast.PathApplication(Ast.Id("abc"), Ast.Id("def")),
      ),
      Parser.Document,
    )
  }
  test("Plain id path application with empty args") {
    assertParse(
      input = "abc.def",
      expected = Ast.Document(
        Ast.PathApplication(Ast.Id("abc"), Ast.Id("def")),
      ),
      Parser.Document,
    )
  }

  // --------------------------------------------------------------------------

  test("Plain id method application with arg tuple group") {
    assertParse(
      input = "account.add(1)",
      expected = Ast.Document(
        Ast.FunctionApplication(
          Ast.PathApplication(Ast.Id("account"), Ast.Id("add")),
          Ast.Tuple(Ast.Integer(1)),
        ),
      ),
      Parser.Document,
    )
  }
end ExprSpec
