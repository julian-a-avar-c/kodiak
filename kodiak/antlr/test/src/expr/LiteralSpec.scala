package kodiak.antlr.expr

import kodiak.antlr.ParserSpec
import kodiak.antlr.Ast
// import kodiak.antlr.Parser

class LiteralSpec extends ParserSpec:
  test("Identifier") {
    assertParse(
      input = "identifier",
      expected = Ast.Program(Ast.Stmts(Ast.Id("identifier"))),
    )
  }
  test("True") {
    assertParse(
      input = "true",
      expected = Ast.Program(Ast.Stmts(Ast.True)),
    )
  }
  test("False") {
    assertParse(
      input = "false",
      expected = Ast.Program(Ast.Stmts(Ast.False)),
    )
  }
  test("Unit") {
    assertParse(
      input = "unit",
      expected = Ast.Program(Ast.Stmts(Ast.Unit)),
    )
  }
  test("Simple integer") {
    assertParse(
      input = "7",
      expected = Ast.Program(Ast.Stmts(Ast.Integer(7))),
    )
  }
  test("Simple decimal") {
    assertParse(
      input = "42.31",
      expected = Ast.Program(Ast.Stmts(Ast.Decimal(42.31))),
    )
  }
  test("Text word") {
    assertParse(
      input = "\"Hello",
      expected = Ast.Program(Ast.Stmts(Ast.SimpleText("Hello"))),
    )
  }
  // test("Raw number word") {
  //   assertParse(
  //     input = "abc#123",
  //     expected = Ast.Program(Ast.Stmts(Ast.MetaNumber(Ast.Id("abc"), "124"))),
  //   )
  // }
  test("Tuple group") {
    assertParse(
      input = "(42)",
      expected = Ast.Program(Ast.Stmts(Ast.Integer(42))),
    )
  }
  test("Seq group") {
    assertParse(
      input = "[42]",
      expected = Ast.Program(Ast.Stmts(Ast.Integer(42))),
    )
  }
  test("Set group") {
    assertParse(
      input = "{42}",
      expected = Ast.Program(Ast.Stmts(Ast.Integer(42))),
    )
  }
  test("Tuple with one item") {
    assertParse(
      input = "(42,)",
      expected = Ast.Program(Ast.Tuple(Ast.Integer(42))),
    )
  }
  test("Tuple with two items") {
    assertParse(
      input = "(42,43)",
      expected = Ast.Program(Ast.Tuple(Ast.Integer(42), Ast.Integer(43))),
    )
  }
  test("Tuple with two items and optional comma") {
    assertParse(
      input = "(42,43,)",
      expected = Ast.Program(Ast.Tuple(Ast.Integer(42), Ast.Integer(43))),
    )
  }
  test("Seq with one item") {
    assertParse(
      input = "[42,]",
      expected = Ast.Program(Ast.Array(Ast.Integer(42))),
    )
  }
  test("Seq with two items") {
    assertParse(
      input = "[42,43]",
      expected = Ast.Program(Ast.Array(Ast.Integer(42), Ast.Integer(43))),
    )
  }
  test("Seq with two items and optional comma") {
    assertParse(
      input = "[42,43,]",
      expected = Ast.Program(Ast.Array(Ast.Integer(42), Ast.Integer(43))),
    )
  }
  test("Set with one item") {
    assertParse(
      input = "{42,}",
      expected = Ast.Program(Ast.Set(Ast.Integer(42))),
    )
  }
  test("Set with two items") {
    assertParse(
      input = "{42,43}",
      expected = Ast.Program(Ast.Set(Ast.Integer(42), Ast.Integer(43))),
    )
  }
  test("Set with two items and optional comma") {
    assertParse(
      input = "{42,43,}",
      expected = Ast.Program(Ast.Set(Ast.Integer(42), Ast.Integer(43))),
    )
  }
end LiteralSpec
