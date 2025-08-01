package kodiak.parser

import fastparse.*

import kodiak.parser.ast.Ast

import Parser.*
import Literal.*
import Expr.*
import Terminal.*

object Literal:
  def integer[$: P]: P[Ast.Integer] = P {
    DIGITS
  }.map(value => Ast.Integer(value.toInt))

  def decimal[$: P]: P[Ast.Decimal] = P {
    DIGITS ~~ "." ~~ DIGITS
  }.map: (integral, decimal) =>
    Ast.Decimal((integral + "." + decimal).toDouble)

  def `signed-integer`[$: P]: P[Ast.Integer] = P {
    SIGN ~~ DIGITS
  }.map((sign, value) => Ast.Integer(sign * value.toInt))

  def `signed-decimal`[$: P]: P[Ast.Decimal] = P {
    SIGN ~~ DIGITS ~~ "." ~~ DIGITS
  }.map: (sign, integral, decimal) =>
    Ast.Decimal(sign * (integral + "." + decimal).toDouble)

  def id[$: P]: P[Ast.Id] = P:
    `raw-id` | `plain-id`

  def `plain-id`[$: P]: P[Ast.Id] = P {
    // !`any-keyword` ~~
    (!DIGIT ~~ ID) ~~ ID.repX(min = 0)
  }.!.map(value => Ast.Id(value))

  def `raw-id`[$: P]: P[Ast.Id] = P {
    "`" ~~ (RAW_BLOCK | WORD)
  }.map(value => Ast.Id(value))

  def text[$: P]: P[Ast.PlainText] = P {
    "\"" ~~ (RAW_BLOCK | WORD)
  }.map(value => Ast.PlainText(value))

  def `raw-number`[$: P]: P[Ast.RawNumber] = P {
    id ~~ "#" ~~ (RAW_BLOCK | WORD)
  }.map((interpolator, value) => Ast.RawNumber(value, interpolator))

  def `raw-text`[$: P]: P[Ast.RawText] = P {
    id ~~ "\"" ~~ (RAW_BLOCK | WORD)
  }.map((interpolator, value) => Ast.RawText(interpolator, value))

  // ------------------------------------------------------------------------

  def group[$: P]: P[Ast.Expr] = P:
    NoCut(`group-tuple`) |
      NoCut(`group-sequence`) |
      NoCut(`group-set`)

  def collection[$: P]: P[Ast.Collection] = P:
    `empty-tuple` |
      `empty-sequence` |
      `empty-set` |
      NoCut(`multi-tuple`) |
      NoCut(`multi-sequence`) |
      NoCut(`multi-set`) |
      NoCut(`single-tuple`) |
      NoCut(`single-sequence`) |
      NoCut(`single-set`)

  def `empty-tuple`[$: P]: P[Ast.Tuple] = P:
    `empty-collection`("(", ")").map(_ => Ast.Tuple())

  def `empty-sequence`[$: P]: P[Ast.Sequence] = P:
    `empty-collection`("[", "]").map(_ => Ast.Sequence())

  def `empty-set`[$: P]: P[Ast.Set] = P:
    `empty-collection`("{", "}").map(_ => Ast.Set())

  def `group-tuple`[$: P]: P[Ast.Expr] = P:
    `group-collection`("(", ")")

  def `group-sequence`[$: P]: P[Ast.Expr] = P:
    `group-collection`("[", "]")

  def `group-set`[$: P]: P[Ast.Expr] = P:
    `group-collection`("{", "}")

  def `single-tuple`[$: P]: P[Ast.Tuple] = P:
    `single-collection`("(", ")").map(expr => Ast.Tuple(expr))

  def `single-sequence`[$: P]: P[Ast.Sequence] = P:
    `single-collection`("[", "]").map(expr => Ast.Sequence(expr))

  def `single-set`[$: P]: P[Ast.Set] = P:
    `single-collection`("{", "}").map(expr => Ast.Set(expr))

  def `multi-tuple`[$: P]: P[Ast.Tuple] = P:
    `multi-collection`("(", ")").map(exprs => Ast.Tuple(exprs*))

  def `multi-sequence`[$: P]: P[Ast.Sequence] = P:
    `multi-collection`("[", "]").map(exprs => Ast.Sequence(exprs*))

  def `multi-set`[$: P]: P[Ast.Set] = P:
    `multi-collection`("{", "}").map(exprs => Ast.Set(exprs*))

  // ------------------------------------------------------------------------

  def function[$: P]: P[Ast.Function] = P {
    import KodiakWhitespace.none
    args ~~ "=>" ~~ expr
  }.map((collection, expr) => Ast.Function(collection, expr))
end Literal
