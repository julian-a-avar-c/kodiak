package kodiak.parser

import fastparse.*

import ast.*
import Expr.*
import Literal.*
import Terminal.*
import fastparse.Implicits.{Repeater, LowPriRepeater}
import fastparse.Implicits.Sequencer
import scala.collection.mutable.Buffer
import kodiak.parser.ast.Ast.Id
import kodiak.parser.ast.Ast.Sequence
import kodiak.parser.ast.Ast.Collection

object Parser:

  def parse[A](
      input: String,
      parser: ParsingRun[?] ?=> ParsingRun[A],
  ): Parsed[A] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def document[$: P] = P {
    import KodiakWhitespace.multiline0
    Start ~ lines ~ End
  }.map(exprs => Ast.Document(exprs*))

  def lines[$: P]: P[Seq[Ast.Expr]] = P:
    stmt.repX(min = 0, sep = LINE_SEP)

  def stmt[$: P] = P:
    expr

  def expr[$: P]: ParsingRun[Ast.Expr] = P {
    import KodiakWhitespace.multiline0;
    `expr-head` ~ `expr-tail`.rep(min = 1).?
  }.map {
    case (expr, None) =>
      expr
    case (expr, Some(tails)) =>
      tails.foldLeft(expr):
        case (function, args: Ast.Collection) =>
          Ast.FunctionApplication(function, args)
        case (receiver, path: Ast.Id) =>
          Ast.PathApplication(receiver, path)
  }

  def `expr-head`[$: P]: P[Ast.Expr] = P:
    (&(CharIn("(", "{", "[")) ~~
      (collection | group)) |
      (&(DIGIT) ~~
        (decimal | integer)) |
      (&(CharIn("+", "\\-", "\"", "`")) ~~
        (`signed-decimal` | `signed-integer` | text | `raw-id`)) |
      (&(`plain-id`) ~~
        (TRUE | FALSE | UNIT |
          `raw-number` |
          `plain-id`))

  def `expr-tail`[$: P]: ParsingRun[Ast.Collection | Ast.Id] = P {
    ("." ~~ `plain-id`) | args
  }

end Parser
