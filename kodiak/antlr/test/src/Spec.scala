package kodiak.antlr

import kodiak.antlr.ParserSpec
import kodiak.antlr.Ast
import kodiak.antlr.KodiakParser.ProgramContext
import kodiak.antlr.KodiakParser.IdContext
import org.antlr.v4.runtime.CommonTokenStream
// import kodiak.antlr.Parser

class Spec extends ParserSpec:
  test("Test 0") {
    val input = ""
    assert(true)
  }

  // --------------------------------------------------------------------------

  test("Test 1") {
    val input  = "a"
    val parser = MyParser.parse(input).nn
    val parsed = parser.program().nn
    val tree   = parser.word().nn
    assert(true)
  }
end Spec
