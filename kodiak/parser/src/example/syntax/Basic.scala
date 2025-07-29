package kodiak.parser.example.syntax

import fastparse.*
import fastparse.NoWhitespace.*
import fastparse.CharPredicates.*

import kodiak.parser.example.syntax.Identifiers.NamedFunction

object Basic:

  def UnicodeEscape[$: P] = P("u" ~ HexDigit ~ HexDigit ~ HexDigit ~ HexDigit)

  // Numbers and digits
  def Digit[$: P] = P(CharIn("0-9"))

  def HexDigit[$: P]  = P(CharIn("0-9a-fA-F"))
  def HexNum[$: P]    = P("0x" ~ CharsWhileIn("0-9a-fA-F"))
  def DecNum[$: P]    = P(CharsWhileIn("0-9"))
  def Exp[$: P]       = P(CharIn("Ee") ~ CharIn("+\\-").? ~ DecNum)
  def FloatType[$: P] = P(CharIn("fFdD"))

  def WSChars[$: P] = P { NoTrace(CharsWhileIn("\u0020\u0009")) }
  def Newline[$: P] = P { NoTrace(StringIn("\r\n", "\n")) }
  def Semi[$: P]    = P { ";" | Newline.rep(1) }
  def OpChar[$: P]  = P(CharPred(isOpChar))

  val isOpChar = NamedFunction {
    case '!' | '#' | '%' | '&' | '*' | '+' | '-' | '/' | ':' | '<' | '=' | '>' |
        '?' | '@' | '\\' | '^' | '|' | '~' =>
      true
    case c => isOtherSymbol(c) || isMathSymbol(c)
  }

  val LetterDigitDollarUnderscore =
    NamedFunction(c => isLetter(c) | isDigit(c) | c == '$' | c == '_')
  val LowerChar = NamedFunction(c => isLower(c) || c == '$' | c == '_')
  val UpperChar = NamedFunction(isUpper)

  def Lower[$: P] = P(CharPred(LowerChar))
  def Upper[$: P] = P(CharPred(UpperChar))

end Basic
