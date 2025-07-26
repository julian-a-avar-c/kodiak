package kodiak.parser

import scala.annotation.{tailrec, switch}

import fastparse.*
import fastparse.internal.{Msgs, Util}

import KodiakWhitespace.*

def apply(content: String): Parsed[Unit] =
  fastparse.parse(content, file(using _))

case class File(content: String)

def file[$: P]: P[Unit] = P {
  Start ~ End
}

sealed trait Expr

def expr[$: P]: P[Expr] = P { call | literal | expr }

case class Call(name: Id, args: Id) extends Expr

def call[$: P]: P[Call] = P {
  (id ~ "(" ~ id ~ ")").map(Call(_, _))
}

sealed trait Literal extends Expr

def literal[$: P]: P[Literal] = P {
  integer
}

case class IntegerLiteral(value: Int) extends Literal

def integer[$: P]: P[IntegerLiteral] = P {
  CharIn("0-9").rep(1).!.map(i => IntegerLiteral(i.toInt))
}

case class Id(name: String) extends Expr

def id[$: P]: P[Id] = P {
  CharIn("[a-z0-9_-]").rep(1).!.map(Id(_))
}
