package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

import kodiak.parser.ast.Ast

object Terminal:

  def WORD[$: P]: P[String] = P:
    ID.repX(min = 1).!

  def RAW_BLOCK[$: P]: P[String] = P:
    def PAREN[$: P] = P:
      ("(" ~~/ !"?" ~~ (!")" ~~ AnyChar).repX(min = 0).! ~~ ")")
    def SQUARE[$: P] = P:
      ("[" ~~/ !"?" ~~ (!"]" ~~ AnyChar).repX(min = 0).! ~~ "]")
    def CURLY[$: P] = P:
      ("{" ~~/ !"?" ~~ (!"}" ~~ AnyChar).repX(min = 0).! ~~ "}")
    PAREN | SQUARE | CURLY
  end RAW_BLOCK

  def DIGIT[$: P]: P[Unit] = P:
    CharIn("0-9")

  def DIGITS[$: P]: P[String] = P:
    CharIn("0-9")
      .repX(min = 1)
      .!
      .repX(min = 1, sep = "_")
      .map(groups => groups.mkString)
  end DIGITS

  def SIGN[$: P]: P[Int] = P:
    "+".map(_ => 1) | "-".map(_ => -1)

  def `true`[$: P]: P[Ast.Boolean]  = P("true".map(_ => Ast.True))
  def `false`[$: P]: P[Ast.Boolean] = P("false".map(_ => Ast.False))

  def ID[$: P]: P[Unit] = P:
    inline val grouping      = "\\(\\)\\[\\]\\{\\}"
    inline val interpolators = "`#\""
    inline val separators    = ":;,./"
    inline val whitespace    = " \t\n\r"
    !CharIn(grouping + interpolators + separators + whitespace) ~~ AnyChar

  def TEXT_BLOCK[$: P] = P:
    ("\"" ~~/ RAW_BLOCK)
  def TEXT_WORD[$: P] = P:
    ("\"" ~~/ WORD)
end Terminal
