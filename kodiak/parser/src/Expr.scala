package kodiak.parser

import fastparse.*

import kodiak.parser.ast.Ast

import Parser.*
import Literal.*
import Terminal.*

object Expr:

  def `empty-collection`[$: P](
      open: String,
      close: String,
  ): P[Unit] = P {
    open ~~ close
  }

  def `group-collection`[$: P](
      open: String,
      close: String,
  ): P[Ast.Expr] = P {
    import KodiakWhitespace.multiline0
    open ~~ !"?" ~/ expr ~ !"," ~ close
  }

  def `single-collection`[$: P](
      open: String,
      close: String,
  ): P[Ast.Expr] = P {
    import KodiakWhitespace.multiline0
    open ~~ !"?" ~/ expr ~ "," ~ close
  }

  def `multi-collection`[$: P](
      open: String,
      close: String,
  ): P[Seq[Ast.Expr]] = P {
    import KodiakWhitespace.multiline0
    open ~~ !"?" ~/ expr.rep(min = 2, sep = ",") ~ ",".? ~ close
  }

  // --------------------------------------------------------------------------

  def `if`[$: P]: P[Ast.If] = P {
    import KodiakWhitespace.multiline
    "if" ~ expr ~ "then" ~ expr ~ ("else" ~ expr).?
  }.map: (condition, thenBranch, elseBranch) =>
    Ast.If(condition, thenBranch, elseBranch)

  def `match`[$: P]: P[Ast.Match] = P {
    def `else-pattern`[$: P]: P[Ast.Match.ElsePattern] = P {
      import KodiakWhitespace.multiline
      "else" ~ expr
    }.map(body => Ast.Match.ElsePattern(body))
    def patterns[$: P]: P[Seq[Ast.Match.Pattern]] = P {
      `else-pattern`
    }.map(elsePattern => Seq[Ast.Match.Pattern](elsePattern))
    import KodiakWhitespace.multiline
    ("match" ~ expr ~ patterns)
  }.map((selector, patterns) => Ast.Match(selector, patterns*))

  def `while`[$: P]: P[Ast.While] = P {
    import KodiakWhitespace.multiline
    "while" ~ expr ~ "do" ~ expr
  }.map((condition, body) => Ast.While(condition, body))

  def `for`[$: P]: P[Ast.For] = P {
    def generator[$: P]: P[Ast.For.Generator] = P {
      `let-definition`
    }.map(definition => Ast.For.Generator(definition.lhs, definition.rhs))
    import KodiakWhitespace.multiline
    "for" ~ generator ~ "do" ~ expr
  }.map((generator, body) => Ast.For(Seq(generator), body))
  end `for`

  // ------------------------------------------------------------------------

  def `val-definition`[$: P]: P[Ast.ValDefinition] = P {
    import KodiakWhitespace.multiline
    "val" ~ id ~ "=" ~ expr
  }.map((id, value) => Ast.ValDefinition(id, value))

  def `var-definition`[$: P]: P[Ast.VarDefinition] = P {
    import KodiakWhitespace.multiline
    "var" ~ id ~ "=" ~ expr
  }.map((id, value) => Ast.VarDefinition(id, value))

  def `set-definition`[$: P]: P[Ast.SetDefinition] = P {
    import KodiakWhitespace.multiline
    "set" ~ id ~ "=" ~ expr
  }.map((id, value) => Ast.SetDefinition(id, value))

  def `let-definition`[$: P]: P[Ast.LetDefinition] = P {
    import KodiakWhitespace.multiline
    "let" ~ id ~ "=" ~ expr
  }.map((id, value) => Ast.LetDefinition(id, value))

  // ------------------------------------------------------------------------

  def args[$: P]: P[Ast.Collection] = P:
    `empty-tuple` |
      `empty-sequence` |
      `empty-set` |
      NoCut(`group-tuple`).map(Ast.Tuple(_)) |
      NoCut(`group-sequence`).map(Ast.Sequence(_)) |
      NoCut(`group-set`).map(Ast.Set(_)) |
      NoCut(`multi-tuple`) |
      NoCut(`multi-sequence`) |
      NoCut(`multi-set`) |
      NoCut(`single-tuple`) |
      NoCut(`single-sequence`) |
      NoCut(`single-set`)

  // def `arg-groups`[$: P]: P[Seq[Ast.Collection]] = P:
  //   args.repX(min = 1)

  // def `function-application`[$: P]: P[Ast.FunctionApplication] = P {
  //   expr ~~ args
  // }.map((function, args) => Ast.FunctionApplication(function, args))

  // def `path-application`[$: P]: P[Ast.PathApplication] = P {
  //   expr ~~ ("." ~~ id.repX(min = 0, sep = "."))
  // }.map((receiver, paths) => Ast.PathApplication(receiver, paths.head))

  // def `operator-application`[$: P]: P[Ast.OperatorApplication] = P {
  //   expr ~~ id ~~/ expr
  // }.map: (left, operator, right) =>
  //   Ast.OperatorApplication(left, operator, right)

end Expr
