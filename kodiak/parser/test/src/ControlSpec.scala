package kodiak.parser

import kodiak.parser.{Ast, Parser}
import kodiak.parser.ParserSpec

class ControlSpec extends ParserSpec:
  test("if") {
    assertParse(
      input = "if true then 1",
      expected = Ast.Document(Ast.If(Ast.True, Ast.Integer(1), None)),
      Parser.Document,
    )
  }
  test("if/else") {
    assertParse(
      input = "if true then 1 else 2",
      expected =
        Ast.Document(Ast.If(Ast.True, Ast.Integer(1), Some(Ast.Integer(2)))),
      Parser.Document,
    )
  }
  test("if/else/if") {
    assertParse(
      input = "if true then 1 else if false then 2",
      expected = Ast.Document(
        Ast.If(
          Ast.True,
          Ast.Integer(1),
          Some(Ast.If(Ast.False, Ast.Integer(2), None)),
        ),
      ),
      Parser.Document,
    )
  }
  test("if/else/if/else") {
    assertParse(
      input = "if true then 1 else if false then 2 else 3",
      expected = Ast.Document(
        Ast.If(
          Ast.True,
          Ast.Integer(1),
          Some(Ast.If(Ast.False, Ast.Integer(2), Some(Ast.Integer(3)))),
        ),
      ),
      Parser.Document,
    )
  }

  // --------------------------------------------------------------------------

  test("while") {
    assertParse(
      input = "while true do printline(\">)",
      expected = Ast.Document(
        Ast.While(
          Ast.True,
          Ast.FunctionApplication(
            Ast.Id("printline"),
            Ast.Tuple(Ast.PlainText(">")),
          ),
        ),
      ),
      Parser.Document,
    )
  }

end ControlSpec
