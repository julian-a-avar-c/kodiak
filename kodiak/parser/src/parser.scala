package kodiak.parser

import fastparse.*

import kodiak.parser.KodiakWhitespace.*
import kodiak.ast.{Ast, Document, Stmts, Expr, Literal, Integer, Boolean}

def parse[T >: Document](
    input: String,
): Parsed[T] = parse(input, document)

def parse[T](
    input: String,
    parser: ParsingRun[Any] ?=> ParsingRun[T],
): Parsed[T] =
  fastparse.parse(input, parser(using _))

// ----------------------------------------------------------------------------

def document[$: P]: P[Document] = P {
  (Start ~ stmts ~ End).map(stmts => Document(stmts))
}

def stmts[$: P]: P[Stmts] = P {
  expr.rep(min = 1)
}

// ----------------------------------------------------------------------------

def expr[$: P]: P[Expr] = P {
  literal
}

def literal[$: P]: P[Literal] = P {
  integer | boolean
}

def integer[$: P]: P[Integer] = P {
  CharIn("0-9").rep(min = 1).!.map(n => Integer(n.toInt))
}

def boolean[$: P]: P[Boolean] = P {
  ("true" | "false").!.map(b => Boolean(b == "true"))
}
