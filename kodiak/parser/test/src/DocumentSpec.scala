package kodiak.parser

import fastparse.ParsingRun
import fastparse.Parsed.{Success, Failure}
import org.scalactic.source.Position
import org.scalactic.Prettifier
import kodiak.parser.UnitSpec

class DocumentSpec extends ParserSpec:
  "Empty documents" should "be parsed" in {
    val input    = ""
    val expected = Ast.Document()
    assertParse(input, expected, Parser.document)
  }
end DocumentSpec
