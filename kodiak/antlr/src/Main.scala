package kodiak.antlr

import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.IterativeParseTreeWalker

object Main:
  def main(args: Array[String]): Unit =
    val inputStream       = CharStreams.fromString("2 + 3 / 7")
    val kodiakLexer       = new KodiakLexer(inputStream)
    val commonTokenStream = new CommonTokenStream(kodiakLexer)
    val kodiakParser      = new KodiakParser(commonTokenStream)
    val programContext    = kodiakParser.program()
    val listener          = new ParserListener
    val visitor           = new ParserVisitor
    println(visitor.visitProgram(programContext))
  end main
end Main
