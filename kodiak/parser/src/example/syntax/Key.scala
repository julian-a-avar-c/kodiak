package kodiak.parser.example.syntax

import fastparse.*
import fastparse.NoWhitespace.*

import kodiak.parser.ast.*
import kodiak.parser.ast.Literal.*
import kodiak.parser.example.syntax.Basic

/**
 * Most keywords don't just require the correct characters to match,
 * they have to ensure that subsequent characters *don't* match in
 * order for it to be a keyword. This enforces that rule for key-words
 * (W) and key-operators (O) which have different non-match criteria.
 */
object Key {
  def W[$: P](s: String) = P( s ~ !CharPred(Basic.LetterDigitDollarUnderscore) )(s"`$s`", summon)
  // If the operator is followed by a comment, stop early so we can parse the comment
  def O[$: P](s: String) = P( s ~ (!Basic.OpChar | &(NoTrace(StringIn("/*", "//")))) )(s"`$s`", summon)
}