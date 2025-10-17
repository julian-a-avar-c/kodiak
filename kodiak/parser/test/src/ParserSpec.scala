package kodiak.parser

import util.given
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ParserSpec extends AnyFunSuite with Matchers:
  inline def setup(input: String)(
      expected: Ast.Program,
  ) =
    val actual = Parser.parse(input)
    if actual.isEmpty then fail("Parsing failed")
    assertResult(expected) { actual.get }
  end setup

  test("Empty program") {
    setup("")(
      Ast.Program(Ast.Stmts(Seq.empty)),
    )
  }
  test("Simple id") {
    setup("a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    setup("ab")(Ast.Program(Ast.Stmts(Seq(Ast.Id("ab")))))
    setup("a~")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a~")))))
    setup("~a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~a")))))
    setup("a4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a4")))))
    setup("~4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~4")))))
  }
  test("Simple one symbol ids") {
    setup("~")(Ast.Program(Ast.Stmts(Seq(Ast.Id("~")))))
    setup("!")(Ast.Program(Ast.Stmts(Seq(Ast.Id("!")))))
    setup("%")(Ast.Program(Ast.Stmts(Seq(Ast.Id("%")))))
    setup("^")(Ast.Program(Ast.Stmts(Seq(Ast.Id("^")))))
    setup("&")(Ast.Program(Ast.Stmts(Seq(Ast.Id("&")))))
    setup("*")(Ast.Program(Ast.Stmts(Seq(Ast.Id("*")))))
    setup("_")(Ast.Program(Ast.Stmts(Seq(Ast.Id("_")))))
    setup("+")(Ast.Program(Ast.Stmts(Seq(Ast.Id("+")))))
    setup("|")(Ast.Program(Ast.Stmts(Seq(Ast.Id("|")))))
    setup("<")(Ast.Program(Ast.Stmts(Seq(Ast.Id("<")))))
    setup(">")(Ast.Program(Ast.Stmts(Seq(Ast.Id(">")))))
    setup("/")(Ast.Program(Ast.Stmts(Seq(Ast.Id("/")))))
  }
  test("Raw id word") {
    setup("`a")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    setup("`4")(Ast.Program(Ast.Stmts(Seq(Ast.Id("4")))))
    setup("`if")(Ast.Program(Ast.Stmts(Seq(Ast.Id("if")))))
  }
  test("Raw id block") {
    setup("`(a)")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    setup("`[a]")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
    setup("`{a}")(Ast.Program(Ast.Stmts(Seq(Ast.Id("a")))))
  }
  test("Integer") {
    setup("1")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(1)))))
    setup("12")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(12)))))
    setup("-1")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(-1)))))
    setup("-12")(Ast.Program(Ast.Stmts(Seq(Ast.Integer(-12)))))
  }
  test("Decimal") {
    setup("1.2")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(1.2)))))
    setup("12.34")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(12.34)))))
    setup("-1.2")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(-1.2)))))
    setup("-12.34")(Ast.Program(Ast.Stmts(Seq(Ast.Decimal(-12.34)))))
  }
  test("Raw Number Word") {
    setup("#1")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("1")))))
    setup("#a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a")))))
    setup("#12")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("12")))))
    setup("#ab")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("ab")))))
    setup("#a~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a~")))))
    setup("#~a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~a")))))
    setup("#a4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a4")))))
    setup("#~4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~4")))))
    setup("#4~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("4~")))))

    setup("#1.1")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("1.1")))))
    setup("#a.a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a.a")))))
    setup("#12.12")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("12.12")))))
    setup("#ab.ab")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("ab.ab")))))
    setup("#a~.a~")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a~.a~")))))
    setup("#~a.~a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~a.~a")))))
    setup("#a4.a4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("a4.a4")))))
    setup("#~4.~4")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("~4.~4")))))
    setup("#4a.4a")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("4a.4a")))))

    setup("a#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    setup("`a#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    setup("`(a)#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    setup("`[a]#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
    setup("`{a}#b")(
      Ast.Program(Ast.Stmts(Seq(Ast.RawNumber(Some(Ast.Id("a")), "b")))),
    )
  }
  test("Raw Number Block") {
    setup("#(abc)")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
    setup("#[abc]")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
    setup("#{abc}")(Ast.Program(Ast.Stmts(Seq(Ast.RawNumber("abc")))))
  }
  test("Text word") {
    setup("\"abc")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
  }
  test("Text block") {
    setup("\"(abc)")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
    setup("\"[abc]")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
    setup("\"{abc}")(Ast.Program(Ast.Stmts(Seq(Ast.Text("abc")))))
  }
end ParserSpec
