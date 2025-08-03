package kodiak.parser.expr

import kodiak.parser.ParserSpec
import kodiak.parser.Ast
import kodiak.parser.Parser

class Literal extends ParserSpec:
  test("True") {
    assertParse(
      input = "true",
      expected = Ast.Document(Ast.True),
      Parser.Document,
    )
  }
  test("False") {
    assertParse(
      input = "false",
      expected = Ast.Document(Ast.False),
      Parser.Document,
    )
  }
  test("Unit") {
    assertParse(
      input = "unit",
      expected = Ast.Document(Ast.Unit),
      Parser.Document,
    )
  }
  test("Simple integer") {
    assertParse(
      input = "42",
      expected = Ast.Document(Ast.Integer(42)),
      Parser.Document,
    )
  }
  test("Simple decimal") {
    assertParse(
      input = "42.31",
      expected = Ast.Document(Ast.Decimal(42.31)),
      Parser.Document,
    )
  }
  test("Text word") {
    assertParse(
      input = "\"Hello",
      expected = Ast.Document(Ast.PlainText("Hello")),
      Parser.Document,
    )
  }
  test("Raw number word") {
    assertParse(
      input = "abc#123",
      expected = Ast.Document(Ast.RawNumber(Ast.Id("abc"), "123")),
      Parser.Document,
    )
  }
  test("Tuple group") {
    assertParse(
      input = "(42)",
      expected = Ast.Document(Ast.Integer(42)),
      Parser.Document,
    )
  }
  test("Seq group") {
    assertParse(
      input = "[42]",
      expected = Ast.Document(Ast.Integer(42)),
      Parser.Document,
    )
  }
  test("Set group") {
    assertParse(
      input = "{42}",
      expected = Ast.Document(Ast.Integer(42)),
      Parser.Document,
    )
  }
  test("Tuple with one item") {
    assertParse(
      input = "(42,)",
      expected = Ast.Document(Ast.Tuple(Ast.Integer(42))),
      Parser.Document,
    )
  }
  test("Tuple with two items") {
    assertParse(
      input = "(42,43)",
      expected = Ast.Document(Ast.Tuple(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
  test("Tuple with two items and optional comma") {
    assertParse(
      input = "(42,43,)",
      expected = Ast.Document(Ast.Tuple(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
  test("Seq with one item") {
    assertParse(
      input = "[42,]",
      expected = Ast.Document(Ast.Seq(Ast.Integer(42))),
      Parser.Document,
    )
  }
  test("Seq with two items") {
    assertParse(
      input = "[42,43]",
      expected = Ast.Document(Ast.Seq(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
  test("Seq with two items and optional comma") {
    assertParse(
      input = "[42,43,]",
      expected = Ast.Document(Ast.Seq(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
  test("Set with one item") {
    assertParse(
      input = "{42,}",
      expected = Ast.Document(Ast.Set(Ast.Integer(42))),
      Parser.Document,
    )
  }
  test("Set with two items") {
    assertParse(
      input = "{42,43}",
      expected = Ast.Document(Ast.Set(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
  test("Set with two items and optional comma") {
    assertParse(
      input = "{42,43,}",
      expected = Ast.Document(Ast.Set(Ast.Integer(42), Ast.Integer(43))),
      Parser.Document,
    )
  }
end Literal
