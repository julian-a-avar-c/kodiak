package kodiak.parser

import kodiak.parser.{Ast, Parser}
import kodiak.parser.ParserSpec

class DefinitionSpec extends ParserSpec:
  test("val") {
    assertParse(
      input = "val a = 1",
      expected = Ast.Document(Ast.ValDefinition(Ast.Id("a"), Ast.Integer(1))),
      Parser.Document,
    )
  }

end DefinitionSpec
