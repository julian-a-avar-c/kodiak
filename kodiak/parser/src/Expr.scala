package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

import kodiak.parser.ast.Ast

import Parser.expr

import Terminal.{DIGIT, DIGITS, WORD, ID, RAW_BLOCK, `true`, `false`, SIGN}

object Expr:

  def id[$: P]: P[Ast.Id] = P:
    NoCut(`raw-id`) | `natural-id`

  def group[$: P]: P[Ast.Expr] = P:
    import KodiakWhitespace.given
    ("(" ~ !"?" ~/ expr ~ !"," ~ ")") |
      ("[" ~ !"?" ~/ expr ~ !"," ~ "]") |
      ("{" ~ !"?" ~/ expr ~ !"," ~ "}")

  def boolean[$: P]: P[Ast.Boolean] = P:
    `true` | `false`

  def number[$: P]: P[Ast.Number] = P:
    decimal | integer

  def integer[$: P]: P[Ast.Integer] = P:
    (SIGN.? ~~ DIGITS)
      .map((sign, value) => Ast.Integer(sign.getOrElse(1) * value.toInt))

  def decimal[$: P]: P[Ast.Decimal] = P:
    (SIGN.? ~~ DIGITS ~~ "." ~~ DIGITS)
      .map((sign, integral, decimal) =>
        Ast.Decimal(sign.getOrElse(1) * (integral + "." + decimal).toDouble),
      )

  def `natural-id`[$: P]: P[Ast.Id] = P:
    ((!DIGIT ~~ ID) ~~ ID.repX(min = 0)).!.map(value => Ast.Id(value))

  def `raw-id`[$: P]: P[Ast.Id] = P:
    def `word-id`[$: P] = P:
      ("`" ~~/ WORD)
    def `block-id`[$: P] = P:
      ("`" ~~/ RAW_BLOCK)
    (NoCut(`block-id`) | `word-id`)
      .map(value => Ast.Id(value))

  def `raw-number`[$: P]: P[Ast.RawNumber] = P:
    def `number-word`[$: P]: P[Ast.RawNumber] = P:
      (id ~~ "#" ~~/ WORD)
        .map((id, value) => Ast.RawNumber(value, id))
    def `number-block`[$: P]: P[Ast.RawNumber] = P:
      (id ~~ "#" ~~/ RAW_BLOCK)
        .map((interpolator, value) => Ast.RawNumber(value, interpolator))
    NoCut(`number-block`) | `number-word`

  def text[$: P]: P[Ast.Text] = P:
    def `text-word`[$: P] = P:
      ("\"" ~~/ WORD)
    def `text-block`[$: P] = P:
      ("\"" ~~/ RAW_BLOCK)

    (NoCut(`text-block`) | `text-word`)
      .map((value) => Ast.Text(value))

  // ------------------------------------------------------------------------

  def collection[$: P]: P[Ast.Collection] = P:
    NoCut(tuple) | NoCut(sequence) | set

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

  def sequence[$: P]: P[Ast.Sequence] = P:
    import KodiakWhitespace.given
    def empty[$: P] = P:
      "[]".map(_ => Seq.empty[Ast.Expr])./
    def single[$: P] = P:
      "[" ~~ !"?" ~/ expr.map(Seq(_)) ~ "," ~ "]"
    def multi[$: P] = P:
      "[" ~~ !"?" ~/ expr.rep(min = 2, sep = ",") ~ ",".? ~ "]"
    (empty | NoCut(single) | multi)
      .map(exprs => Ast.Sequence(exprs*))
  end sequence

  def set[$: P]: P[Ast.Set] = P:
    import KodiakWhitespace.given
    def empty[$: P] = P:
      "{}".map(_ => Seq.empty[Ast.Expr])./
    def single[$: P] = P:
      "{" ~~ !"?" ~/ expr.map(Seq(_)) ~ "," ~ "}"
    def multi[$: P] = P:
      "{" ~~ !"?" ~/ expr.rep(min = 2, sep = ",") ~ ",".? ~ "}"
    (empty | NoCut(single) | multi)
      .map(exprs => Ast.Set(exprs*))
  end set

  // ------------------------------------------------------------------------

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
      ("let" ~/ id ~ "=" ~ expr)
        .map((id, value) => Ast.For.Generator(id, value))
    ("for" ~/ generator ~ "do" ~ expr)
      .map((generator, body) => Ast.For(Seq(generator), body))
  end `for`

  // ------------------------------------------------------------------------

  def `function-application`[$: P]: P[Ast.FunctionApplication] = P:
    import KodiakWhitespace.given
    def args[$: P]: P[Ast.Collection] = P:
      collection | group.map(expr => Ast.Tuple(expr))
    def `arg-groups`[$: P]: P[Seq[Ast.Collection]] = P:
      args.rep(min = 1)
    (id ~ `arg-groups`)
      .map((function, args) => Ast.FunctionApplication(function, args*))
  end `function-application`

end Expr
