package kodiak.parser

import kodiak.core.utils.valueCanEqualValueOfSameType

import fastparse.*
import scala.annotation.unchecked.uncheckedVariance
import fastparse.Parsed.{Failure, Success}

case class ParserException(failure: Failure) extends Exception(failure.toString)

object Parser:
  def parse(input: String): Ast.Document throws ParserException =
    parse(input, Document) match
      case failure: Failure =>
        throw ParserException(failure)
      case Success(value: Ast.Document, index) =>
        value

  def parse[A](input: String, parser: P[?] ?=> P[A]): Parsed[A] =
    fastparse.parse(input, parser(using _))

  // --------------------------------------------------------------------------

  def Document[$: P]: P[Ast.Document] =
    P {
      (Start ~~
        Stmt.repX(min = 0)) ~~
        End
    }
      .map(stmts => Ast.Document(stmts*))
  end Document

  def LineSep[$: P]: P[Unit] =
    P { NL | CharIn(";") }

  def Stmt[$: P]: P[Ast.Stmt] = P {
    ValDefinition |
      VarDefinition |
      SetDefinition |
      LetDefinition |
      While |
      Expr
  }

  def ValDefinition[$: P]: P[Ast.ValDefinition] =
    import kodiak.parser.Whitespace.multiline
    P { "val" ~ (RawId | PlainId) ~ "=" ~ Expr }
      .map((predicate, body) => Ast.ValDefinition(predicate, body))
  end ValDefinition

  def VarDefinition[$: P]: P[Ast.VarDefinition] =
    import kodiak.parser.Whitespace.multiline
    P { "var" ~ (RawId | PlainId) ~ "=" ~ Expr }
      .map((predicate, body) => Ast.VarDefinition(predicate, body))
  end VarDefinition

  def SetDefinition[$: P]: P[Ast.SetDefinition] =
    import kodiak.parser.Whitespace.multiline
    P { "set" ~ (RawId | PlainId) ~ "=" ~ Expr }
      .map((predicate, body) => Ast.SetDefinition(predicate, body))
  end SetDefinition

  def LetDefinition[$: P]: P[Ast.LetDefinition] =
    import kodiak.parser.Whitespace.multiline
    P { "let" ~ (RawId | PlainId) ~ "=" ~ Expr }
      .map((predicate, body) => Ast.LetDefinition(predicate, body))
  end LetDefinition

  def While[$: P]: P[Ast.While] =
    import kodiak.parser.Whitespace.multiline
    P { "while" ~ Expr ~ "do" ~ Expr }
      .map((predicate, body) => Ast.While(predicate, body))
  end While

  def Expr[$: P]: P[Ast.Expr] =
    P {
      If |
        Match |
        For |
        (ExprHead ~~
          (Args |
            ("." ~~
              (Digits |
                RawId |
                PlainId))).?)
    }.map {
      case (expr: Ast.Expr) =>
        expr
      case (expr, None) =>
        expr
      case (expr, Some(args: Ast.Collection)) =>
        Ast.FunctionApplication(expr, args)
      case (expr, Some(path: Ast.Id)) =>
        Ast.PathApplication(expr, path)
      case (expr, Some(digit: String)) =>
        ???
    }
  end Expr

  def If[$: P]: P[Ast.If] =
    import kodiak.parser.Whitespace.multiline
    P { "if" ~ Expr ~ "then" ~ Expr ~ ("else" ~ Expr).? }
      .map((predicate, thenBranch, elseBranch) =>
        Ast.If(predicate, thenBranch, elseBranch),
      )
  end If

  def Match[$: P]: P[Ast.Match] =
    import kodiak.parser.Whitespace.multiline
    P { "match" ~ Expr ~ "with" ~ ExprHead ~ "then" ~ Expr }
      .map((expr, pattern, branch) =>
        Ast.Match(
          expr,
          Ast.Match.Branch(
            {
              pattern match
                case literal: Ast.Literal => Ast.Match.LiteralPattern(literal)
                case _                    => ???
            },
            branch,
          ),
        ),
      )
  end Match

  def For[$: P]: P[Ast.For] =
    import kodiak.parser.Whitespace.multiline
    P { "for" ~ "let" ~ (RawId | PlainId) ~ "=" ~ Expr ~ "then" ~ Expr }
      .map((id, expr, branch) =>
        Ast.For(
          scala.Seq(Ast.For.Enumerator(id, expr)),
          branch,
        ),
      )
  end For

  def ExprHead[$: P]: P[Ast.Expr] = P:
    Group |
      Literal
  end ExprHead

  def Literal[$: P]: P[Ast.Literal] = P:
    Collection |
      RawId |
      PlainText |
      Decimal |
      Integer |
      TRUE |
      FALSE |
      UNIT |
      RawNumber |
      RawText |
      PlainId
  end Literal

  def Group[$: P]: P[Ast.Expr] =
    P { TupleGroup | SeqGroup | SetGroup }

  def Collection[$: P]: P[Ast.Collection] =
    P { Tuple | Seq | Set }

  def Args[$: P]: P[Ast.Collection] = P {
    TupleGroup.map(Ast.Tuple(_)) |
      SeqGroup.map(Ast.Seq(_)) |
      SetGroup.map(Ast.Set(_)) |
      Collection
  }

  def RawId[$: P]: P[Ast.Id] =
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
    P { PlainId ~~ "#" ~~ (RawBlock | Word) }
      .map((interpolator, value) => Ast.RawNumber(interpolator, value))

  def RawText[$: P]: P[Ast.RawText] =
    P { PlainId ~~ "\"" ~~ (RawBlock | Word) }
      .map((interpolator, value) => Ast.RawText(interpolator, value))

  def PlainId[$: P]: P[Ast.Id] =
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
  ): P[scala.Seq[Ast.Expr]] = P {
    NoCut(
      OPEN ~~/ (Expr.repX(min = 2, sep = ",") ~~ ",".?) ~~ CLOSE,
    ) |
      NoCut(
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

  inline def RAW_BLOCK[A: P](
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

  inline def NOT_ID[$: P]: P[Unit] =
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
