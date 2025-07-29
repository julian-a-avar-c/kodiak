package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

package ast {
  sealed trait Ast
  object Ast:
    sealed trait Expr              extends Ast
    case class Integer(value: Int) extends Expr
}

import ast.*

def parse[T <: Ast](
    input: String,
    parser: ParsingRun[Any] ?=> ParsingRun[T],
): Parsed[T] =
  fastparse.parse(input, parser(using _))

def Parser[$: P] = P:
  Expr

def Expr[$: P] = P:
  Group | Integer

def Group[$: P]: P[Ast.Expr] = P:
  "(" ~/ Expr ~ ")"

def Integer[$: P]: P[Ast.Integer] = P:
  CharsWhileIn("0-9").repX(min = 0, sep = "_".?).!
    .map((chars) => Ast.Integer(chars.toInt))
