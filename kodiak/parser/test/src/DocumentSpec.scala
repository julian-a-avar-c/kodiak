package kodiak.parser

import kodiak.parser.{Ast, Parser}
import kodiak.parser.ParserSpec

class DocumentSpec extends ParserSpec:
  test("Empty documents") {
    assertParse(
      input = "",
      expected = Ast.Document(),
      Parser.document,
    )
  }
end DocumentSpec
