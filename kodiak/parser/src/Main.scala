package kodiak.parser

import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.IterativeParseTreeWalker

object Main:
  def main(args: Array[String]): Unit =
    val input = "abc"
    println(Parser.parse(input))
  end main
end Main
