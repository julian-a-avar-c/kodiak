package kodiak.parser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import kodiak.antlr.KodiakLexer
import kodiak.antlr.KodiakParser
import kodiak.antlr.KodiakParser.ProgramContext

object Parser:
  def parse(input: String): Option[Ast.Program] =
    if input.trim().isBlank()
    then Some(Ast.Program(Ast.Stmts(Seq.empty)))
    else
      val inputStream       = CharStreams.fromString(input)
      val kodiakLexer       = new KodiakLexer(inputStream)
      val commonTokenStream = new CommonTokenStream(kodiakLexer)
      val parser            = new KodiakParser(commonTokenStream)
      KodiakParserVisitor().visitProgram(parser.program())
  end parse
end Parser
