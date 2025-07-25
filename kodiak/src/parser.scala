package kodiak.parser

import fastparse.*
import fastparse.NoWhitespace.*

def apply(content: String): Parsed[String] =
  fastparse.parse(content, file(using _))

def file[$: P]: P[String] = P {
  """{?} This is a one-line comment.

{?
  This is a multi-line comment.
?}

printline("[Hello, World!])
""".!
}
