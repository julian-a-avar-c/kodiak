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

object Literal:
  def id[$: P]: P[Ast.Id] = P:
    NoCut(`raw-id`) | `plain-id`

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

  def `raw-number`[$: P]: P[Ast.RawNumber] = P:
    def `number-word`[$: P]: P[Ast.RawNumber] = P:
      (id ~~ "#" ~~/ WORD)
        .map((id, value) => Ast.RawNumber(value, id))
    def `number-block`[$: P]: P[Ast.RawNumber] = P:
      (id ~~ "#" ~~/ RAW_BLOCK)
        .map((interpolator, value) => Ast.RawNumber(value, interpolator))
    NoCut(`number-block`) | `number-word`

  def `plain-text`[$: P] = P:
    (NoCut(TEXT_BLOCK) | TEXT_WORD)
      .map((value) => Ast.PlainText(value))

  def `raw-text`[$: P] = P:
    (id ~~ (NoCut(TEXT_BLOCK) | TEXT_WORD))
      .map((interpolator, value) => Ast.RawText(interpolator, value))

  def `plain-id`[$: P]: P[Ast.Id] = P:
    ((!DIGIT ~~ ID) ~~ ID.repX(min = 0)).!.map(value => Ast.Id(value))

  def `raw-id`[$: P]: P[Ast.Id] = P:
    def `raw-word-id`[$: P] = P:
      ("`" ~~/ WORD)
    def `raw-block-id`[$: P] = P:
      ("`" ~~/ RAW_BLOCK)
    (NoCut(`raw-block-id`) | `raw-word-id`)
      .map(value => Ast.Id(value))

  // ------------------------------------------------------------------------

  def collection[$: P]: P[Ast.Collection] = P:
    NoCut(tuple) | NoCut(sequence) | set

  def tuple[$: P]: P[Ast.Tuple] = P:
    Expr
      .ItemCollection("(", ")")
      .parse
      .map(exprs => Ast.Tuple(exprs*))

  def sequence[$: P]: P[Ast.Sequence] = P:
    Expr
      .ItemCollection("[", "]")
      .parse
      .map(exprs => Ast.Sequence(exprs*))

  def set[$: P]: P[Ast.Set] = P:
    Expr
      .ItemCollection("{", "}")
      .parse
      .map(exprs => Ast.Set(exprs*))

  // ------------------------------------------------------------------------

  def function[$: P]: P[Ast.Function] = P:
    import KodiakWhitespace.given
    (Expr.`group-collection` ~ "=>" ~ expr)
      .map((collection, expr) => Ast.Function(collection, expr))
end Literal
