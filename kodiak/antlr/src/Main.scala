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
    val input = "2 + 3 / 7"

    println(MyParser.parse(input).nn.program())
  end main
end Main
