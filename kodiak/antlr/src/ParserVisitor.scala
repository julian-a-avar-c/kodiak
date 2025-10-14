package kodiak.antlr

import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.ParseTree

import kodiak.antlr.KodiakParser.*
import scala.util.boundary, boundary.break

given [T] => CanEqual[T | Null, Null] = CanEqual.derived
given [T] => CanEqual[Null, T | Null] = CanEqual.derived

import scala.jdk.CollectionConverters.given

class ParserVisitor extends KodiakParserBaseVisitor[Ast | Null]:
  def parse(input: String): Ast throws ParserException = ???

  // --------------------------------------------------------------------------

  override def visitProgram(ctx: ProgramContext | Null): Ast.Program =
    Ast.Program.empty

end ParserVisitor
