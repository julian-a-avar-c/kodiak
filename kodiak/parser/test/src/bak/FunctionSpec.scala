package kodiak.parser.bak

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class FunctionSpec extends ParserSpec:

  "Kodiak's parser" should "parse a function application" in {
    val input    = "add1(5)"
    val expected = FunctionApplication(Id("add1"), Tuple(Exprs(Integer(5))))

    assertParse(input, expected, `function-application`)
    assertParse(input, Document(expected), document)
  }

  it should "parse an operator application" in {
    val input    = "7 + 42"
    val expected = OperatorApplication(Integer(7), Id("+"), Integer(42))

    // assertParse(input, expected, `operator-application`)
    assertParse(input, Document(expected), document)
  }

end FunctionSpec
