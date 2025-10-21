package kodiak.parser

import util.given
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class ParserCtlSpec extends AnyFunSuite with Matchers:
  inline def assertParse(input: String)(
      expected: Ast.Program,
  ) =
    val actual = Parser.parse(input)
    if actual.isEmpty then fail("Parsing failed")
    assertResult(expected) { actual.get }
  end assertParse

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

  test("Match Expressions") {
    assertParse("(match 0 else \"a)")(
      Ast.Program(
        Ast.Stmts(
          Seq(
            Ast.Match(
              scrutinee = Ast.Integer(0),
              patterns = Seq(
                Ast.MatchPattern(
                  guard = Ast.MatchGuard.Else,
                  body = Ast.Text("a"),
                ),
              ),
            ),
          ),
        ),
      ),
    )
    assertParse("(match 0 with 0 then \"a)")(
      Ast.Program(
        Ast.Stmts(
          Seq(
            Ast.Match(
              scrutinee = Ast.Integer(0),
              patterns = Seq(
                Ast.MatchPattern(
                  guard =
                    Ast.MatchGuard.UntypedSimpleExpr(`with` = Ast.Integer(0)),
                  body = Ast.Text("a"),
                ),
              ),
            ),
          ),
        ),
      ),
    )
  }

end ParserCtlSpec
