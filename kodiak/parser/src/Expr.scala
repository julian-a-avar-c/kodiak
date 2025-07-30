package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

import kodiak.parser.ast.Ast

import Parser.expr

import Terminal.{
  DIGIT,
  DIGITS,
  WORD,
  ID,
  RAW_BLOCK,
  `true`,
  `false`,
  SIGN,
  TEXT_BLOCK,
  TEXT_WORD,
}

object Expr:
  sealed trait Collection[T](open: String, close: String):
    import KodiakWhitespace.given
    def empty[$: P]: P[Unit] = P:
      (open ~~ close)./
    def group[$: P]: P[Ast.Expr] = P:
      (open ~~ !"?" ~/ expr ~ !"," ~ close)./
    def single[$: P]: P[Seq[Ast.Expr]] = P:
      (open ~~ !"?" ~/ expr.map(Seq(_)) ~ "," ~ close)./
    def multi[$: P]: P[Seq[Ast.Expr]] = P:
      (open ~~ !"?" ~/ expr.rep(min = 2, sep = ",") ~ ",".? ~ close)./

    def parse[$: P]: P[T]
  end Collection

  case class ItemCollection(open: String, close: String)
      extends Collection[Seq[Ast.Expr]](open, close):
    def parse[$: P] = P:
      empty.map(_ => Seq.empty) | NoCut(single) | multi
  end ItemCollection

  case class GroupCollection(open: String, close: String)
      extends Collection[Seq[Ast.Expr]](open, close):
    def parse[$: P] = P:
      empty.map(_ => Seq.empty) |
        NoCut(single) |
        NoCut(this.group).map(Seq(_)) |
        multi
  end GroupCollection

  case class Group(open: String, close: String)
      extends Collection[Ast.Expr](open, close):
    def parse[$: P] = this.group

  def `group-collection`[$: P]: P[Ast.Collection] = P:
    GroupCollection("(", ")").parse.map(Ast.Tuple(_*)) |
      GroupCollection("[", "]").parse.map(Ast.Sequence(_*)) |
      GroupCollection("{", "}").parse.map(Ast.Set(_*))

  def group[$: P]: P[Ast.Expr] = P:
    Group("(", ")").parse |
      Group("[", "]").parse |
      Group("{", "}").parse

  // --------------------------------------------------------------------------

  def control[$: P]: P[Ast.Control] = P:
    NoCut(`if`) | NoCut(`match`) | NoCut(`while`) | `for`

  def `if`[$: P]: P[Ast.If] = P:
    import KodiakWhitespace.given
    ("if" ~/ expr ~ "then" ~ expr ~ ("else" ~ expr).?)
      .map((condition, thenBranch, elseBranch) =>
        Ast.If(condition, thenBranch, elseBranch),
      )
  end `if`

  def `match`[$: P]: P[Ast.Match] = P:
    import KodiakWhitespace.given
    def `else-pattern`[$: P]: P[Ast.Match.ElsePattern] = P:
      ("else" ~/ expr)
        .map(body => Ast.Match.ElsePattern(body))
    def patterns[$: P]: P[Seq[Ast.Match.Pattern]] = P:
      NoCut(`else-pattern`)
        .map(elsePattern => Seq.empty[Ast.Match.Pattern] :+ elsePattern)
    ("match" ~/ expr ~ patterns)
      .map((selector, patterns) => Ast.Match(selector, patterns*))
  end `match`

  def `while`[$: P]: P[Ast.While] = P:
    import KodiakWhitespace.given
    ("while" ~/ expr ~ "do" ~ expr)
      .map((condition, body) => Ast.While(condition, body))

  def `for`[$: P]: P[Ast.For] = P:
    import KodiakWhitespace.given
    def generator[$: P]: P[Ast.For.Generator] = P:
      `let-definition`
        .map(definition => Ast.For.Generator(definition.lhs, definition.rhs))
    ("for" ~/ generator ~ "do" ~ expr)
      .map((generator, body) => Ast.For(Seq(generator), body))
  end `for`

  // ------------------------------------------------------------------------

  def `val-definition`[$: P]: P[Ast.ValDefinition] = P:
    import KodiakWhitespace.given
    ("val" ~/ Literal.id ~ "=" ~ expr)
      .map((id, value) => Ast.ValDefinition(id, value))

  def `var-definition`[$: P]: P[Ast.VarDefinition] = P:
    import KodiakWhitespace.given
    ("var" ~/ Literal.id ~ "=" ~ expr)
      .map((id, value) => Ast.VarDefinition(id, value))

  def `set-definition`[$: P]: P[Ast.SetDefinition] = P:
    import KodiakWhitespace.given
    ("set" ~/ Literal.id ~ "=" ~ expr)
      .map((id, value) => Ast.SetDefinition(id, value))

  def `let-definition`[$: P]: P[Ast.LetDefinition] = P:
    import KodiakWhitespace.given
    ("let" ~/ Literal.id ~ "=" ~ expr)
      .map((id, value) => Ast.LetDefinition(id, value))

  // ------------------------------------------------------------------------

  def `function-application`[$: P]: P[Ast.FunctionApplication] = P:
    import KodiakWhitespace.given
    def `arg-groups`[$: P]: P[Seq[Ast.Collection]] = P:
      `group-collection`.rep(min = 1)
    (Literal.id ~ `arg-groups`)
      .map((function, args) => Ast.FunctionApplication(function, args*))
  end `function-application`

end Expr
