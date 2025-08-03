package kodiak.parser

import scala.Seq as ScalaSeq

import fastparse.*
import scala.annotation.unchecked.uncheckedVariance

object Parser:
  def parse[A](input: String, parser: P[?] ?=> P[A]): Parsed[A] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def Document[$: P]: P[Ast.Document] =
    P {
      (Start ~~
        Expr.repX(min = 0)) ~~
        End
    }
      .map(expr => Ast.Document(expr.toSeq*))
  end Document

  def LineSep[$: P]: P[Unit] =
    P { NL | CharIn(";") }

  def Expr[$: P]: P[Ast.Expr] =
    P {
      ExprHead ~~ (Args |
        ("." ~~
          (Digits |
            Args |
            IdBlock |
            IdWord))).repX(min = 1).?
    }
      .map {
        case (expr, None) =>
          expr
        case (head, Some(tails)) =>
          tails.foldLeft(head) {
            case (expr, args: Ast.Collection) =>
              Ast.FunctionApplication(expr, args)
            case (expr, path: Ast.Id) =>
              Ast.PathApplication(expr, path)
            case (expr, digit: String) =>
              ???
          }
      }

  def Args[$: P]: P[Ast.Collection] = P {
    Collection |
      TupleGroup.map(Ast.Tuple(_)) |
      SeqGroup.map(Ast.Seq(_)) |
      SetGroup.map(Ast.Set(_))
  }

  def ExprHead[$: P]: P[Ast.Expr] = P:
    Group |
      Collection |
      IdBlock |
      PlainText |
      Decimal |
      Integer |
      TRUE |
      FALSE |
      UNIT |
      RawNumber |
      RawText |
      IdWord
  end ExprHead

  def Collection[$: P]: P[Ast.Collection] =
    P { Tuple | Seq | Set }

  def Group[$: P]: P[Ast.Expr] =
    P { TupleGroup | SeqGroup | SetGroup }

  def IdBlock[$: P]: P[Ast.Id] =
    P { "`" ~~ RawBlock }
      .map(value => Ast.Id(value))

  def PlainText[$: P]: P[Ast.PlainText] =
    P { "\"" ~~ (RawBlock | Word) }
      .map(value => Ast.PlainText(value))

  def Decimal[$: P]: P[Ast.Decimal] =
    P { Digits ~~ "." ~~ Digits }
      .map((integral, decimal) =>
        Ast.Decimal((s"${integral}.${decimal}".toDouble)),
      )

  def Integer[$: P]: P[Ast.Integer] =
    Digits.map(value => Ast.Integer(value.toInt))

  def RawNumber[$: P]: P[Ast.RawNumber] =
    P { IdWord ~~ "#" ~~ (RawBlock | Word) }
      .map((interpolator, value) => Ast.RawNumber(interpolator, value))

  def RawText[$: P]: P[Ast.RawText] =
    P { IdWord ~~ "\"" ~~ (RawBlock | Word) }
      .map((interpolator, value) => Ast.RawText(interpolator, value))

  def IdWord[$: P]: P[Ast.Id] =
    P { !DIGIT ~~ ID ~~ Word0 }.!.map(value => Ast.Id(value))

  // --------------------------------------------------------------------------

  def GroupSequence[$: P](
      OPEN: P[?] ?=> P[Unit],
      CLOSE: P[?] ?=> P[Unit],
  ): P[Ast.Expr] =
    P { NoCut(OPEN ~~/ Expr ~~ CLOSE) }

  def Sequence[$: P](
      OPEN: P[?] ?=> P[Unit],
      CLOSE: P[?] ?=> P[Unit],
  ): P[ScalaSeq[Ast.Expr]] = P {
    NoCut(
      OPEN ~~/ (Expr.repX(min = 2, sep = ",") ~~ ",".?) ~~ CLOSE,
    ) | NoCut(
      OPEN ~~/ (Expr ~~ ",").repX(min = 0, max = 1) ~~ CLOSE,
    )
  }

  def Tuple[$: P]: P[Ast.Tuple] =
    P { Sequence("(", ")") }
      .map(sequence => Ast.Tuple(sequence*))

  def Seq[$: P]: P[Ast.Seq] =
    P { Sequence("[", "]") }
      .map(sequence => Ast.Seq(sequence*))

  def Set[$: P]: P[Ast.Set] =
    P { Sequence("{", "}") }
      .map(sequence => Ast.Set(sequence*))

  def TupleGroup[$: P]: P[Ast.Expr] =
    P { GroupSequence("(", ")") }

  def SeqGroup[$: P]: P[Ast.Expr] =
    P { GroupSequence("[", "]") }

  def SetGroup[$: P]: P[Ast.Expr] =
    P { GroupSequence("{", "}") }

  // --------------------------------------------------------------------------

  inline def RawBlock[$: P] = P {
    NoCut(RAW_PAREN_BLOCK) |
      NoCut(RAW_SQUARE_BLOCK) |
      NoCut(RAW_BRACKET_BLOCK)
  }

  inline def Word0[$: P]: P[String] = P { ID.repX(min = 0).! }

  inline def Word[$: P]: P[String] = P { ID.repX(min = 1).! }

  inline def Digits[$: P]: P[String] =
    P { CharIn("0-9").repX(min = 1).!.repX(min = 1, sep = "_") }
      .map(_.mkString)

  // --------------------------------------------------------------------------

  def RAW_BLOCK[A: P](
      OPEN: P[?] ?=> P[Unit],
      CLOSE: P[?] ?=> P[Unit],
  ): P[String] =
    P { OPEN ~~/ (!CLOSE ~~ AnyChar).repX(min = 0).! ~~ CLOSE }

  inline def RAW_PAREN_BLOCK[$: P]   = RAW_BLOCK("(", ")")
  inline def RAW_SQUARE_BLOCK[$: P]  = RAW_BLOCK("[", "]")
  inline def RAW_BRACKET_BLOCK[$: P] = RAW_BLOCK("{", "}")

  inline def TRUE[$: P]  = P { "true" }.map(_ => Ast.True)
  inline def FALSE[$: P] = P { "false" }.map(_ => Ast.False)
  inline def UNIT[$: P]  = P { "unit" }.map(_ => Ast.Unit)

  // --------------------------------------------------------------------------

  inline def ID[$: P]: P[Unit] =
    P { !NOT_ID ~~ AnyChar }

  def NOT_ID[$: P]: P[Unit] =
    inline val bracketing   = "()[]{}"
    inline val whitespace   = " \t\r\n"
    inline val separator    = ".,;"
    inline val interpolator = "`#\""
    P { CharIn(bracketing + whitespace + separator + interpolator) }
  end NOT_ID

  inline def DIGIT[$: P]: P[String] =
    P { CharIn("0-9").! }

  inline def WS[$: P]: P[Unit] =
    P { SL | NL }

  inline def SL[$: P]: P[Unit] =
    P { CharIn(" ", "\t") }

  inline def NL[$: P]: P[Unit] =
    P { CharIn("\r", "\n") }

end Parser
