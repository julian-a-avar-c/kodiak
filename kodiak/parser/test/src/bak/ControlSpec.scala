package kodiak.parser.bak

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

class ControlSpec extends ParserSpec:

  "Kodiak's parser" should "parse if control structures" in {
    val input    = "if true then 1"
    val expected = If(Boolean(true), Integer(1), None)

    // assertParse(input, expected, `if`)
    assertParse(input, Document(expected), document)
  }

  it should "parse if-else control structures" in {
    val input    = "if true then 1 else 2"
    val expected =
      Document(
        If(
          Boolean(true),
          Integer(1),
          Some(Integer(2)),
        ),
      )

    assertParse(input, expected, document)
  }

  it should "parse if-elseif-else control structures" in {
    val input    = "if true then 1 elseif true then 2 else 3"
    val expected = Document(
      If(
        Boolean(true),
        Integer(1),
        Some(
          If(
            Boolean(true),
            Integer(2),
            Some(Integer(3)),
          ),
        ),
      ),
    )

    assertParse(input, expected, document)
  }

  it should "parse while control structures" in {
    val input    = "while true do 5"
    val expected = Document(
      While(Boolean(true), Integer(5)),
    )

    assertParse(input, expected, document)
  }

  ignore should "parse for-do control structures with expression extractors" in {
    val input    = "for [1, 2, 3] do 5"
    val expected = Document(
      For(
        Seq(
          For.ExpressionGenerator(Sequence(Exprs(Integer(1), Integer(2), Integer(3)))),
        ),
        Integer(5),
      ),
    )

    assertParse(input, expected, document)
  }

  it should "parse for-do control structures" in {
    val input    = "for let i = 5 do 5"
    val expected = Document(
      For(
        Seq(For.ExtractorGenerator(Id("i"), Integer(5))),
        Integer(5),
      ),
    )

    assertParse(input, expected, document)
  }

  ignore should "parse match control structures" in {
    val input = "n match case 0 then 10 case 1 then 11 case 2 then 12 else 13"
    val expected = Document(
      For(
        ???,
        Integer(5),
      ),
    )

    assertParse(input, expected, document)
  }

end ControlSpec
