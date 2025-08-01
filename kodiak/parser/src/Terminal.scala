package kodiak.parser

import fastparse.*

import kodiak.parser.ast.Ast

object Terminal:

  def WORD[$: P]: P[String] = P:
    ID.repX(min = 1).!

  def RAW_BLOCK[$: P]: P[String] = P:
    def PAREN[$: P] = P:
      ("(" ~~ !"?" ~~/ (!")" ~~ AnyChar).repX(min = 0).! ~~ ")")
    def SQUARE[$: P] = P:
      ("[" ~~ !"?" ~~/ (!"]" ~~ AnyChar).repX(min = 0).! ~~ "]")
    def CURLY[$: P] = P:
      ("{" ~~ !"?" ~~/ (!"}" ~~ AnyChar).repX(min = 0).! ~~ "}")
    NoCut(PAREN) | NoCut(SQUARE) | NoCut(CURLY)
  end RAW_BLOCK

  def DIGIT[$: P]: P[Unit] = P:
    CharIn("0-9")

  def DIGITS[$: P]: P[String] = P {
    CharIn("0-9")
      .repX(min = 1)
      .!
      .repX(min = 1, sep = "_")
  }.map(groups => groups.mkString)

  def TRUE[$: P]: P[Ast.True.type] =
    P { "true" }.map(_ => Ast.True)

  def FALSE[$: P]: P[Ast.False.type] =
    P { "false" }.map(_ => Ast.False)

  def UNIT[$: P]: P[Ast.Unit.type] =
    P { "unit" }.map(_ => Ast.Unit)

  def LINE_SEP[$: P] = P:
    NL | ";"

  def SIGN[$: P]: P[Int] = P:
    "+".map(_ => 1) | "-".map(_ => -1)

  def NON_ID[$: P]: P[Unit] = P:
    inline val grouping      = "\\(\\)\\[\\]\\{\\}"
    inline val interpolators = "`#\""
    inline val separators    = ":;,./"
    inline val whitespace    = " \t\n\r"
    CharIn(grouping + interpolators + separators + whitespace)

  def ID[$: P]: P[Unit] = P:
    !NON_ID ~~ AnyChar

  def WS[$: P] = P:
    SL | NL

  def SL[$: P] = P:
    " " | "\t"

  def NL[$: P] = P:
    "\r" | "\n"

end Terminal
