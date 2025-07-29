package kodiak.parser.bak

import fastparse.*

import kodiak.parser.bak.KodiakWhitespace.given
import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*
import kodiak.parser.ast.OperatorApplication

def parse[T <: Ast](
    input: String,
    parser: ParsingRun[Any] ?=> ParsingRun[T],
): Parsed[T] =
  fastparse.parse(input, parser(using _))

// ----------------------------------------------------------------------------

def WORD_ID_CHAR[$: P]: P[scala.Unit] =
  inline val spacing       = " \r\n\t"
  inline val interpolators = "`\"#"
  inline val grouping      = "\\(\\)\\[\\]\\{\\}"
  inline val other         = "\\\\:;,./"
  !CharIn(spacing + interpolators + grouping + other) ~~ AnyChar
end WORD_ID_CHAR

def NUMBER[$: P]: P[String]         = P { CharIn("0-9").! }
def NUMBER_SEP[$: P]: P[scala.Unit] = P { "_" }
def NUMBER_SEQ[$: P]: P[String]     = P:
  NUMBER
    .repX(min = 1, sep = NUMBER_SEP.?)
    .map(value => value.filter(_ != "_").mkString)

def NUMBER_SIGN[$: P]: P[-1 | 1] = P:
  ("+" | "-").!.map:
    case "+" => 1
    case "-" => -1

def TRUE[$: P]: P[scala.Boolean] = P:
  "true".map(_ => true)

def FALSE[$: P]: P[scala.Boolean] = P:
  "false".map(_ => false)

def UNIT[$: P]: P[Unit] = P:
  "unit".map(_ => Unit)

// ----------------------------------------------------------------------------

def `raw-word`[$: P]: P[java.lang.String] = P { WORD_ID_CHAR.repX(min = 1).! }

def `raw-block`[$: P] = P:
  def bracketed(`start`: java.lang.String, `end`: java.lang.String)[$: P] = P:
    `start` ~~/ (!`end` ~~ AnyChar).repX(min = 0).! ~~ `end`

  bracketed("(", ")") | bracketed("[", "]") | bracketed("{", "}")
end `raw-block`

// ----------------------------------------------------------------------------

def document[$: P]: P[Document] = P:
  (Start ~ stmts ~ End)
    .map(stmts => Document(stmts*))

def stmts[$: P]: P[Stmts] = P:
  expr.rep(min = 0, sep = ";")

def expr[$: P]: P[Expr] = P:
  control |
    literal |
    // `function-application` |
    // (expr ~ tuple).map((f, a) => FunctionApplication(f, a)) |
    id
end expr

def exprs[$: P]: P[Exprs] = P:
  (expr.rep(min = 2, sep = ",") ~ ",".?)
    .map(exprs => Exprs(exprs*))

def id[$: P]: P[Id] = P:
  `raw-word`
    .map(value => Id(value))

// ----------------------------------------------------------------------------

def literal[$: P]: P[Expr] = P:
  tuple | unit | boolean | number

// def text[$: P]: P[Text] = P:
//   ???

def number[$: P]: P[Number] = P:
  decimal | integer

def decimal[$: P]: P[Decimal] = P:
  (NUMBER_SIGN.? ~~ NUMBER_SEQ ~~ "." ~~ NUMBER_SEQ)
    .map: (sign, integral, decimal) =>
      Decimal(sign.getOrElse(1) * (integral + "." + decimal).toDouble)

def integer[$: P]: P[Integer] = P:
  (NUMBER_SIGN.? ~~ NUMBER_SEQ)
    .map((sign, value) => Integer(sign.getOrElse(1) * value.toInt))

def boolean[$: P]: P[Boolean] = P:
  (TRUE | FALSE)
    .map(value => Boolean(value))

def unit[$: P]: P[Unit] = P { UNIT }

// ----------------------------------------------------------------------------

def collection[$: P]: P[Collection] = P:
  tuple | sequence | set

def tuple[$: P]: P[Tuple] = P:
  def empty[$: P] = P { "()".map(_ => Exprs()) }
  def item[$: P] = P { (expr ~ ",").map(Exprs(_)) }

  (empty | "(" ~~ !"?" ~/ (exprs | item) ~ ")")
    .map(items => Tuple(items))
end tuple

def sequence[$: P]: P[Sequence] = P:
  def empty[$: P] = P { "()".map(_ => Exprs()) }
  def item[$: P] = P { (expr ~ ",").map(Exprs(_)) }

  (empty | "[" ~~ !"?" ~/ (exprs | item) ~ "]")
    .map(items => Sequence(items))
end sequence

def set[$: P]: P[Set] = P:
  def empty[$: P] = P { "()".map(_ => Exprs()) }
  def item[$: P] = P { (expr ~ ",").map(Exprs(_)) }

  (empty | "{" ~~ !"?" ~/ (exprs | item) ~ "}")
    .map(items => Set(items))
end set

// ----------------------------------------------------------------------------

def control[$: P]: P[Unit] = P:
  ("if" | "match" | "while" | "for")
    .map(_ => Unit)

// ----------------------------------------------------------------------------

def `function-application`[$: P]: P[FunctionApplication] = P:
  (expr ~ tuple)
    .map((function, args) => FunctionApplication(function, args))

// /** Simpler structures first, but id last because it's very generic
//   *
//   * @return
//   */
// def literal[$: P]: P[Expr] = P:
//   collection |
//     unit |
//     boolean |
//     number |
//     text |
//     application |
//     id
// end literal

// def id[$: P]: P[Id] = P:
//   (`raw-word` | ("`" ~~/ `raw-block`)).map(value => Id(value))

// def unit[$: P]: P[Unit] = P { "unit".map(_ => Unit) }

// def boolean[$: P]: P[Boolean] = P:
//   ("true" | "false").!.map:
//     case "true"  => Boolean(true)
//     case "false" => Boolean(false)

// def number[$: P]: P[Number] = P { decimal | integer }

// def integer[$: P]: P[Integer] = P:
//   (NUMBER_SIGN.? ~~ NUMBER_SEQ)
//     .map((sign, value) => Integer(sign.getOrElse(1) * value.toInt))

// def decimal[$: P]: P[Decimal] = P:
//   (NUMBER_SIGN.? ~~ (NUMBER_SEQ ~~ "." ~~ NUMBER_SEQ).!)
//     .map((sign, value) => Decimal(sign.getOrElse(1) * value.toDouble))

// def text[$: P]: P[Text] = P:
//   ("\"" ~~/ (`raw-word` | `raw-block`))
//     .map(value => Text(value))

// // ----------------------------------------------------------------------------

// def collection[$: P]: P[Collection] = P { tuple | sequence }

// def tuple[$: P]: P[Tuple] = P:
//   ("(" ~~ !"?" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ ")")
//     .map(exprs => Tuple(exprs*))

// def sequence[$: P]: P[Sequence] = P:
//   ("[" ~~ !"?" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ "]")
//     .map(exprs => Sequence(exprs*))

// def set[$: P]: P[Set] = P:
//   ("{" ~~ !"?" ~/ expr.rep(min = 1, sep = ",") ~ ",".? ~ "}")
//     .map(exprs => Set(exprs*))

// // ----------------------------------------------------------------------------

// def control[$: P]: P[Control] = P { `if` | `while` | `for` }

// def `if`[$: P]: P[If] = P:
//   ("if" ~/ expr ~ "then" ~ expr ~ ("else" ~ expr).?)
//     .map: (condition, thenBranch, elseBranch) =>
//       If(condition, thenBranch, elseBranch)

// def `match`[$: P]: P[Match] = P:
//   def `pattern-clause`[$: P]: P[Match.Clause] = P:
//     ("when" ~/ expr ~ "then" ~ expr)
//       .map((pattern, body) => Match.PatternClause(pattern, body))

//   def `else-clause`[$: P]: P[Match.Clause] = P:
//     ("else" ~/ expr)
//       .map((body) => Match.ElseClause(body))

//   ("match" ~/ expr ~ "with" ~ `pattern-clause`.rep(min = 0) ~ `else-clause`)
//     .map((selector, patternClauses, elseClause) =>
//       Match(
//         selector,
//         Seq.empty[Match.Clause] ++ patternClauses :+ elseClause,
//       ),
//     )
// end `match`

// def `while`[$: P]: P[While] = P:
//   ("while" ~/ expr ~ "do" ~ expr)
//     .map((condition, action) => While(condition, action))

// def `for`[$: P]: P[For] = P:
//   def `extractor-generators`[$: P]: P[Seq[For.ExtractorGenerator]] = P:
//     ("let" ~/ id ~ "=" ~ expr)
//       .map((id, expr) => For.ExtractorGenerator(id, expr))
//       .rep(min = 1)

//   def `expression-generator`[$: P]: P[Seq[For.ExpressionGenerator]] = P:
//     expr.map(expr => Seq(For.ExpressionGenerator(expr)))

//   ("for" ~/ (`extractor-generators` | `expression-generator`) ~ "do" ~ expr)
//     .map((generators, action) => For(generators, action))
// end `for`

// // ----------------------------------------------------------------------------

// def application[$: P]: P[Application] = P:
//   `function-application` | `operator-application`

// def `operator-application`[$: P]: P[OperatorApplication] = P:
//   (expr ~ &(" ") ~ id ~/ &(" ") ~ expr)
//     .map((left, op, right) => OperatorApplication(left, op, right))

// def `function-application`[$: P]: P[FunctionApplication] = P:
//   (id ~~ collection)
//     .map((id, collection) => FunctionApplication(id, collection))
