package kodiak.antlr

import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.ParserRuleContext

import kodiak.antlr.KodiakParser.*

class ParserListener extends KodiakParserBaseListener:
  def parse(input: String): Ast throws ParserException = ???

  // --------------------------------------------------------------------------

end ParserListener
