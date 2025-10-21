package kodiak.parser

import util.given
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ParserSpec extends AnyFunSuite with Matchers:
  inline def assertParse(input: String)(
      expected: Ast.Program,
  ) =
    val actual = Parser.parse(input)
    if actual.isEmpty then fail("Parsing failed")
    assertResult(expected) { actual.get }
  end assertParse

  test("Empty program") {
    assertParse("")(
      Ast.Program(Ast.Stmts(Seq.empty)),
    )
  }

  test("Statements") {
    assertParse("abc;abc")(
      Ast.Program(Ast.Stmts(Seq(Ast.Id("abc"), Ast.Id("abc")))),
    )
  }

  // --------------------------------------------------------------------------

  test("Boolean") {
    assertParse("true")(Ast.Program(Ast.Stmts(Seq(Ast.True))))
    assertParse("false")(Ast.Program(Ast.Stmts(Seq(Ast.False))))
  }

  test("Simple id") {
    assertParse("a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    assertParse("ab")(Ast.Program(Ast.Stmts(Seq(Ast.Id("ab")))))
    assertParse("a~")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a~")))))
    assertParse("~a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~a")))))
    assertParse("a4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a4")))))
    assertParse("~4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~4")))))
  }
  test("Simple one symbol ids") {
    assertParse("~")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~")))))
    assertParse("!")(Ast.Program(Ast.Stmts(Seq(Ast.Id("!")))))
    assertParse("%")(Ast.Program(Ast.Stmts(Seq(Ast.Id("%")))))
    assertParse("^")(Ast.Program(Ast.Stmts(Seq(Ast.Id("^")))))
    assertParse("&")(Ast.Program(Ast.Stmts(Seq(Ast.Id("&")))))
    assertParse("*")(Ast.Program(Ast.Stmts(Seq(Ast.Id("*")))))
    assertParse("_")(Ast.Program(Ast.Stmts(Seq(Ast.Id("_")))))
    assertParse("+")(Ast.Program(Ast.Stmts(Seq(Ast.Id("+")))))
    assertParse("|")(Ast.Program(Ast.Stmts(Seq(Ast.Id("|")))))
    assertParse("<")(Ast.Program(Ast.Stmts(Seq(Ast.Id("<")))))
    assertParse(">")(Ast.Program(Ast.Stmts(Seq(Ast.Id(">")))))
    assertParse("/")(Ast.Program(Ast.Stmts(Seq(Ast.Id("/")))))
  }
  test("Raw id word") {
    assertParse("`a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    assertParse("`4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("4")))))
    assertParse("`if")(Ast.Program(Ast.Stmts(Seq(Ast.Id("if")))))
  }
  test("Raw id block") {
    assertParse("`(a)")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    assertParse("`[a]")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    assertParse("`{a}")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
  }

  test("Integer") {
    assertParse("1")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(1)))))
    assertParse("12")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(12)))))
  }
  test("Decimal") {
    assertParse("1.2")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(1.2)))))
    assertParse("12.34")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(12.34)))))
  }
  test("Signed Number") {
    assertParse("-1")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(-1)))))
    assertParse("-12")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(-12)))))
    assertParse("-1.2")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(-1.2)))))
    assertParse("-12.34")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(-12.34)))))
  }
  test("Raw Number Word") {
    assertParse("#1")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("1")))))
    assertParse("#a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a")))))
    assertParse("#12")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("12")))))
    assertParse("#ab")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("ab")))))
    assertParse("#a~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a~")))))
    assertParse("#~a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~a")))))
    assertParse("#a4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a4")))))
    assertParse("#~4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~4")))))
    assertParse("#4~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("4~")))))

    assertParse("#1.1")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("1.1")))))
    assertParse("#a.a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a.a")))))
    assertParse("#12.12")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("12.12")))))
    assertParse("#ab.ab")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("ab.ab")))))
    assertParse("#a~.a~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a~.a~")))))
    assertParse("#~a.~a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~a.~a")))))
    assertParse("#a4.a4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a4.a4")))))
    assertParse("#~4.~4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~4.~4")))))
    assertParse("#4a.4a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("4a.4a")))))
  }
  test("Raw Interpolated Number Word") {
    assertParse("a#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`a#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`(a)#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`[a]#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`{a}#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
  }
  test("Raw Number Block") {
    assertParse("#(abc)")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
    assertParse("#[abc]")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
    assertParse("#{abc}")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
  }

  test("Text word") {
    assertParse("\"1")(Ast.Program(Ast.Stmts(Seq(Ast.Text("1")))))
    assertParse("\"a")(Ast.Program(Ast.Stmts(Seq(Ast.Text("a")))))
    assertParse("\"12")(Ast.Program(Ast.Stmts(Seq(Ast.Text("12")))))
    assertParse("\"ab")(Ast.Program(Ast.Stmts(Seq(Ast.Text("ab")))))
    assertParse("\"a~")(Ast.Program(Ast.Stmts(Seq(Ast.Text("a~")))))
    assertParse("\"~a")(Ast.Program(Ast.Stmts(Seq(Ast.Text("~a")))))
    assertParse("\"a4")(Ast.Program(Ast.Stmts(Seq(Ast.Text("a4")))))
    assertParse("\"~4")(Ast.Program(Ast.Stmts(Seq(Ast.Text("~4")))))
    assertParse("\"4~")(Ast.Program(Ast.Stmts(Seq(Ast.Text("4~")))))
  }
  test("Text block") {
    assertParse("\"(abc)")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
    assertParse("\"[abc]")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
    assertParse("\"{abc}")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
  }
  test("Interpolated Text") {
    assertParse("a\"b")(
      Ast.Program(Ast.Stmts(Seq(Ast.ComplexText(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`a\"b")(
      Ast.Program(Ast.Stmts(Seq(Ast.ComplexText(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`(a)\"b")(
      Ast.Program(Ast.Stmts(Seq(Ast.ComplexText(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`[a]\"b")(
      Ast.Program(Ast.Stmts(Seq(Ast.ComplexText(Some(Ast.Id("a")), "b")))),
    )
    assertParse("`{a}\"b")(
      Ast.Program(Ast.Stmts(Seq(Ast.ComplexText(Some(Ast.Id("a")), "b")))),
    )
  }

  test("If Expressions") {
    assertParse("(if true then 1 else 0)")(
      Ast.Program(
        Ast.Stmts(
          Seq(
            Ast.If(
              condition = Ast.True,
              consequent = Ast.Integer(1),
              alternative = Ast.Integer(0),
            ),
          ),
        ),
      ),
    )
  }

  // --------------------------------------------------------------------------

  test("Op App") {
    assertParse("a a a")(
      Ast.Program(
        Ast.Stmts(
          Seq(
            Ast.OpApp(left = Ast.Id("a"), op = Ast.Id("a"), right = Ast.Id("a")),
          ),
        ),
      ),
    )
  }
end ParserSpec
