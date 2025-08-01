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

  def expr[$: P]: ParsingRun[Ast.Expr] =
    import KodiakWhitespace.multiline0
    P {
      `expr-head` ~ `expr-tail`.rep(min = 1).?
    }.map {
      case (expr, None)        => expr
      case (expr, Some(tails)) =>
        tails.foldLeft(expr) {
          case (function, args: Ast.Collection) =>
            Ast.FunctionApplication(function, args)
          case (receiver, path: Ast.Id) =>
            Ast.PathApplication(receiver, path)
        }
    }
  end expr

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

  // def stmt[$: P]: P[Ast.Expr] = P {
  //   `val-definition` |
  //     `var-definition` |
  //     `set-definition` |
  //     `let-definition` |
  //     expr
  // }

  // def expr[$: P]: P[Ast.Expr] = P {
  //   `expr-head`
  // }

  // def `path-application`[$: P]: P[Ast.Id] = P { "." ~~/ id }

  // def `expr-head`[$: P]: P[Ast.Expr] = P:
  //   (&(StringIn("if", "match", "while", "for")) ~~
  //     (`if` | `match` | `while` | `for`)) |
  //     (&(StringIn("val", "var", "set", "let")) ~~
  //       (`val-definition` | `var-definition` | `set-definition` | `let-definition`)) |
  //     literal

  // def literal[$: P]: P[Ast.Expr] = P:
  //   `signed-decimal` | `signed-integer` | text |
  //     `raw-number` | `raw-text` | `raw-id` |
  //     (&(`plain-id`) ~~
  //       (`raw-text` | `raw-number` | `plain-id`)) |
  //     TRUE | FALSE | UNIT |
  //     decimal | integer |
  //     group | collection

end Parser
