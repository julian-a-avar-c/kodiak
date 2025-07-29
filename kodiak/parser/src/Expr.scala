package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

import kodiak.parser.ast.Ast

import Parser.expr

import Terminal.{DIGIT, DIGITS, WORD, ID, RAW_BLOCK, `true`, `false`, SIGN}

object Expr:
  def id[$: P]: P[Ast.Id] = P:
    NoCut(`raw-id`) | `word-id`

  def `word-id`[$: P]: P[Ast.Id] = P:
    ((!DIGIT ~~ ID) ~~ ID.repX(min = 0)).!.map(value => Ast.Id(value))

  def `raw-id`[$: P]: P[Ast.Id] = P:
    ("`" ~~/ (WORD | RAW_BLOCK))
      .map(value => Ast.Id(value))

  def group[$: P]: P[Ast.Expr] = P:
    import KodiakWhitespace.given
    ("(" ~ !"?" ~/ expr ~ !"," ~ ")") |
      ("[" ~ !"?" ~/ expr ~ !"," ~ "]") |
      ("{" ~ !"?" ~/ expr ~ !"," ~ "}")

  def boolean[$: P]: P[Ast.Boolean] = P:
    `true` | `false`

  def integer[$: P]: P[Ast.Integer] = P:
    (SIGN.? ~~ DIGITS)
      .map((sign, value) => Ast.Integer(sign.getOrElse(1) * value.toInt))

  def decimal[$: P]: P[Ast.Decimal] = P:
    (SIGN.? ~~ DIGITS ~~ "." ~~ DIGITS)
      .map((sign, integral, decimal) =>
        Ast.Decimal(sign.getOrElse(1) * (integral + "." + decimal).toDouble),
      )

  def `raw-number`[$: P]: P[Ast.RawNumber] = P:
    (`word-id` ~~ "#" ~~ (WORD | RAW_BLOCK))
      .map((interpolator, value) => Ast.RawNumber(value, interpolator))

  // ------------------------------------------------------------------------

  def collection[$: P]: P[Ast.Collection] = P:
    tuple

  def tuple[$: P]: P[Ast.Tuple] = P:
    import KodiakWhitespace.given
    def empty[$: P] = P:
      "()".map(_ => Seq.empty[Ast.Expr])./
    def single[$: P] = P:
      "(" ~~ !"?" ~/ expr.map(Seq(_)) ~ "," ~ ")"
    def multi[$: P] = P:
      "(" ~~ !"?" ~/ expr.rep(min = 2, sep = ",") ~ ",".? ~ ")"
    (empty | NoCut(single) | multi)
      .map(exprs => Ast.Tuple(exprs*))
  end tuple

  // ------------------------------------------------------------------------

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
      ("let" ~/ id ~ "=" ~ expr)
        .map((id, value) => Ast.For.Generator(id, value))
    ("for" ~/ generator ~ "do" ~ expr)
      .map((generator, body) => Ast.For(Seq(generator), body))
  end `for`

  // ------------------------------------------------------------------------

  def `function-application`[$: P]: P[Ast.FunctionApplication] = P:
    import KodiakWhitespace.given
    def args[$: P]: P[Seq[Ast.Collection]] = P:
      NoCut(group.map(expr => Seq(Ast.Tuple(expr)))) |
        tuple.rep(min = 1)
    (id ~ args)
      .map((function, args) => Ast.FunctionApplication(function, args*))
  end `function-application`

end Expr
