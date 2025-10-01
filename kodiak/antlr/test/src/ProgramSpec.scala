package kodiak.antlr

import kodiak.antlr.ParserSpec
import kodiak.antlr.Ast
// import kodiak.antlr.Parser

class ProgramSpec extends ParserSpec:
  test("Empty program") {
    assertParse(
      input = "",
      expected = Ast.Program.empty,
    )
  }
end ProgramSpec
