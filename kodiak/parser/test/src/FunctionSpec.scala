package kodiak.parser

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class FunctionSpec extends ParserSpec:

  "Kodiak's parser" should "parse a function application" in {
    val input    = "add1(5)"
    val expected = Document(
      FunctionApplication(
        Id("add1"),
        Tuple(Integer(5)),
      ),
    )

    assertParse(input, expected, document)
  }

end FunctionSpec
