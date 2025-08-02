package kodiak.parser.expr

import kodiak.parser.ParserSpec
import kodiak.parser.Ast
import kodiak.parser.Parser

class Literal extends ParserSpec:
  test("True") {
    assertParse(
      input = "true",
      expected = Ast.Document(Ast.True),
      Parser.document,
    )
  }
  test("False") {
    assertParse(
      input = "false",
      expected = Ast.Document(Ast.False),
      Parser.document,
    )
  }
end Literal
