package kodiak.parser.bak

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class OopSpec extends ParserSpec:

  // "Kodiak's parser"
  ignore should "parse an object application" in {
    val input    = "subject.verb(object)"
    val expected = Document(
      ObjectApplication(
        Id("subject"),
        Id("verb"),
        Seq(Id("object")),
      ),
    )

    assertParse(input, expected, document)
  }

end OopSpec
