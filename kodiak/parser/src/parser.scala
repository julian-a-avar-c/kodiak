package kodiak.parser

import fastparse.*

import kodiak.parser.KodiakWhitespace.*
import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*

def parse[T <: Ast](
    input: String,
    parser: ParsingRun[Any] ?=> ParsingRun[T],
): Parsed[T] =
  fastparse.parse(input, parser(using _))

// ----------------------------------------------------------------------------

def WORD_ID[$: P]: P[scala.Unit] =
  inline val spacing       = " \r\n\t"
  inline val interpolators = "`\"#"
  inline val grouping      = "\\(\\)\\[\\]\\{\\}"
  inline val other         = "\\\\:;,./"
  !CharIn(spacing + interpolators + grouping + other) ~~ AnyChar
end WORD_ID

def NUMBER[$: P]: P[String]         = P { CharIn("0-9").! }
def NUMBER_SEP[$: P]: P[scala.Unit] = P { "_" }
def NUMBER_SEQ[$: P]: P[String]     = P:
  NUMBER.repX(min = 1, sep = NUMBER_SEP.?).!
end NUMBER_SEQ

def NUMBER_SIGN[$: P]: P[-1 | 1] = P:
  ("+" | "-").!.map {
    case "+" => 1
    case "-" => -1
  }
end NUMBER_SIGN

// ----------------------------------------------------------------------------

def `raw-word`[$: P]: P[java.lang.String] = P { WORD_ID.repX(min = 1).! }

def `raw-block`[$: P] = P:
  def bracketed(`start`: java.lang.String, `end`: java.lang.String)[$: P] = P {
    `start` ~~/ (!`end` ~~ AnyChar).repX(min = 0).! ~~ `end`
  }
  bracketed("(", ")") | bracketed("[", "]") | bracketed("{", "}")
end `raw-block`

// ----------------------------------------------------------------------------

def document[$: P]: P[Document] = P:
  (Start ~ expr ~ End)
    .map(stmts => Document(stmts))
end document

def expr[$: P]: P[Expr] = P:
  control |
    literal
end expr

// ----------------------------------------------------------------------------

/** Simpler structures first, but id last because it's very generic
  *
  * @return
  */
def literal[$: P]: P[Expr] = P:
  collection |
    unit |
    boolean |
    number |
    text |
    application |
    id
end literal

def id[$: P]: P[Id] = P:
  (`raw-word` | ("`" ~~/ `raw-block`)).map(value => Id(value))
end id

def unit[$: P]: P[Unit] = P { "unit".map(_ => Unit) }

def boolean[$: P]: P[Boolean] = P:
  ("true" | "false").!.map {
    case "true"  => Boolean(true)
    case "false" => Boolean(false)
  }
end boolean

def number[$: P]: P[Number] = P { decimal | integer }

def integer[$: P]: P[Integer] = P:
  (NUMBER_SIGN.? ~~ NUMBER_SEQ)
    .map((sign, value) => Integer(sign.getOrElse(1) * value.toInt))
end integer

def decimal[$: P]: P[Decimal] = P:
  (NUMBER_SIGN.? ~~ (NUMBER_SEQ ~~ "." ~~ NUMBER_SEQ).!)
    .map((sign, value) => Decimal(sign.getOrElse(1) * value.toDouble))
end decimal

def text[$: P]: P[Text] = P:
  ("\"" ~~/ (`raw-word` | `raw-block`))
    .map(value => Text(value))
end text

// ----------------------------------------------------------------------------

def collection[$: P]: P[Collection] = P:
  tuple | sequence | set
end collection

def tuple[$: P]: P[Tuple] = P:
  ("(" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ ")")
    .map(exprs => Tuple(exprs*))
end tuple

def sequence[$: P]: P[Sequence] = P:
  ("[" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ "]")
    .map(exprs => Sequence(exprs*))
end sequence

def set[$: P]: P[Set] = P:
  ("{" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ "}")
    .map(exprs => Set(exprs*))
end set

// ----------------------------------------------------------------------------

def control[$: P]: P[Control] = P:
  `if` | `while` | `for`
end control

def `if`[$: P]: P[If] = P:
  ("if" ~ expr ~ "then" ~ expr ~ ("else" ~ expr).?)
    .map((condition, thenBranch, elseBranch) =>
      If(condition, thenBranch, elseBranch),
    )
end `if`

def `match`[$: P]: P[Match] = P:
  def `pattern-clause`[$: P]: P[Match.Clause] = P {
    ("when" ~ expr ~ "then" ~ expr)
      .map((pattern, body) => Match.PatternClause(pattern, body))
  }
  def `else-clause`[$: P]: P[Match.Clause] = P {
    ("else" ~ expr)
      .map((body) => Match.ElseClause(body))
  }

  ("match" ~ expr ~ "with" ~ `pattern-clause`.rep(min = 0) ~ `else-clause`)
    .map((selector, patternClauses, elseClause) =>
      Match(
        selector,
        Seq.empty[Match.Clause] ++ patternClauses :+ elseClause,
      ),
    )
end `match`

def `while`[$: P]: P[While] = P:
  ("while" ~ expr ~ "do" ~ expr)
    .map((condition, action) => While(condition, action))
end `while`

def `for`[$: P]: P[For] = P:
  def `extractor-generators`[$: P]: P[Seq[For.ExtractorGenerator]] = P {
    ("let" ~ id ~ "=" ~ expr)
      .map((id, expr) => For.ExtractorGenerator(id, expr))
      .rep(min = 1)
  }
  def `expression-generator`[$: P]: P[Seq[For.ExpressionGenerator]] = P {
    expr.map(expr => Seq(For.ExpressionGenerator(expr)))
  }
  ("for" ~ (`extractor-generators` | `expression-generator`) ~ "do" ~ expr)
    .map((generators, action) => For(generators, action))
end `for`

// ----------------------------------------------------------------------------

def application[$: P]: P[Application] = P:
  (id ~~ collection)
    .map((id, collection) => FunctionApplication(id, collection))
end application
