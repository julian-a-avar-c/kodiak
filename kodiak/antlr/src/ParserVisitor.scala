package kodiak.antlr

import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import org.antlr.v4.runtime.tree.RuleNode
import org.antlr.v4.runtime.tree.ParseTree

import kodiak.antlr.KodiakParser.*
import scala.util.boundary, boundary.break

given [T] => CanEqual[T | Null, Null] = CanEqual.derived
given [T] => CanEqual[Null, T | Null] = CanEqual.derived

import scala.collection.JavaConverters.given

class ParserVisitor extends KodiakParserBaseVisitor[Ast | Null]:
  def parse(input: String): Ast throws ParserException = ???

  // --------------------------------------------------------------------------

  override def visitProgram(ctx: ProgramContext): Ast.Program =
    val stmts: Ast.Stmts = visitStmts(ctx.stmts())
    Ast.Program(stmts)
  end visitProgram

  override def visitStmts(ctx: StmtsContext): Ast.Stmts =
    val stmtsSeq: Seq[Ast.Stmt] = ctx.stmt().asScala.toSeq.map(visitStmt)
    Ast.Stmts(stmtsSeq*)
  end visitStmts

  override def visitStmtSep(ctx: StmtSepContext): Null =
    null

  override def visitStmt(ctx: StmtContext) =
    // stmt: decl | ifStmt | whileStmt | forStmt | expr;
    lazy val decl      = Option.fromNullable(ctx.decl()).map(visitDecl)
    lazy val ifStmt    = Option.fromNullable(ctx.ifStmt()).map(visitIfStmt)
    lazy val whileStmt =
      Option.fromNullable(ctx.whileStmt()).map(visitWhileStmt)
    lazy val forStmt = Option.fromNullable(ctx.forStmt()).map(visitForStmt)
    lazy val expr    = Option.fromNullable(ctx.expr()).map(visitExpr)

    val x = Seq(decl, ifStmt, whileStmt, forStmt, expr).flatten
    ???
  end visitStmt

  override def visitDecl(ctx: DeclContext) =
    visitChildren(ctx)

  override def visitValDecl(ctx: ValDeclContext): Ast.ValDecl =
    val id    = visitId(ctx.id())
    val op    = Ast.Id("=")
    val value = visitExpr(ctx.expr())
    Ast.ValDecl(id, op, value)
  end visitValDecl

  override def visitVarDecl(ctx: VarDeclContext) =
    visitChildren(ctx)

  override def visitSetDecl(ctx: SetDeclContext) =
    visitChildren(ctx)

  override def visitEqDeclOp(ctx: EqDeclOpContext) =
    visitChildren(ctx)

  override def visitPlainEqDeclOp(ctx: PlainEqDeclOpContext) =
    visitChildren(ctx)

  override def visitRawEqDeclOp(ctx: RawEqDeclOpContext) =
    visitChildren(ctx)

  override def visitExpr(ctx: ExprContext): Ast.Expr =
    visitChildren(ctx)
    ???

  override def visitIfStmt(ctx: IfStmtContext) =
    visitChildren(ctx)

  override def visitIf(ctx: IfContext) =
    visitChildren(ctx)

  override def visitMatch(ctx: MatchContext) =
    visitChildren(ctx)

  override def visitMatchBranch(ctx: MatchBranchContext) =
    visitChildren(ctx)

  override def visitForStmt(ctx: ForStmtContext) =
    visitChildren(ctx)

  override def visitFor(ctx: ForContext) =
    visitChildren(ctx)

  override def visitForEnumerator(ctx: ForEnumeratorContext) =
    visitChildren(ctx)

  override def visitWhileStmt(ctx: WhileStmtContext) =
    visitChildren(ctx)

  override def visitFnApp(ctx: FnAppContext) =
    visitChildren(ctx)

  override def visitOpApp(ctx: OpAppContext) =
    visitChildren(ctx)

  override def visitPathApp(ctx: PathAppContext) =
    visitChildren(ctx)

  override def visitStaticPathApp(ctx: StaticPathAppContext) =
    visitChildren(ctx)

  override def visitIndexPathApp(ctx: IndexPathAppContext) =
    visitChildren(ctx)

  override def visitExprHead(ctx: ExprHeadContext) =
    visitChildren(ctx)

  override def visitGroup(ctx: GroupContext) =
    visitChildren(ctx)

  override def visitBlock(ctx: BlockContext) =
    visitChildren(ctx)

  override def visitCollection(ctx: CollectionContext) =
    visitChildren(ctx)

  override def visitTuple(ctx: TupleContext) =
    visitChildren(ctx)

  override def visitArray(ctx: ArrayContext) =
    visitChildren(ctx)

  override def visitSet(ctx: SetContext) =
    visitChildren(ctx)

  override def visitCollectionContents(ctx: CollectionContentsContext) =
    visitChildren(ctx)

  override def visitCollectionSep(ctx: CollectionSepContext) =
    visitChildren(ctx)

  override def visitInteger(ctx: IntegerContext) =
    visitChildren(ctx)

  override def visitDecimal(ctx: DecimalContext) =
    visitChildren(ctx)

  override def visitRawNumber(ctx: RawNumberContext) =
    visitChildren(ctx)

  override def visitRawNumberBlock(ctx: RawNumberBlockContext) =
    visitChildren(ctx)

  override def visitRawNumberWord(ctx: RawNumberWordContext) =
    visitChildren(ctx)

  override def visitPlainText(ctx: PlainTextContext) =
    visitChildren(ctx)

  override def visitPlainTextBlock(ctx: PlainTextBlockContext) =
    visitChildren(ctx)

  override def visitPlainTextWord(ctx: PlainTextWordContext) =
    visitChildren(ctx)

  override def visitId(ctx: IdContext): Ast.Id =
    // TODO: Add additional cases
    visitPlainId(ctx.plainId())

  override def visitPlainId(ctx: PlainIdContext): Ast.Id =
    Ast.Id(ctx.getText())

  override def visitRawId(ctx: RawIdContext) =
    visitChildren(ctx)

  override def visitRawIdWord(ctx: RawIdWordContext) =
    visitChildren(ctx)

  override def visitRawIdBlock(ctx: RawIdBlockContext) =
    visitChildren(ctx)

  // --------------------------------------------------------------------------

  override def visitChildren(node: RuleNode) =
    var result = defaultResult()
    val n      = node.getChildCount()
    for i <- 0 until n do
      boundary {
        if !shouldVisitNextChild(node, result) then break()

        val c           = node.getChild(i)
        val childResult = c.accept(this)
        result = aggregateResult(result, childResult)
      }
    end for

    result
  end visitChildren

  override def defaultResult() = null

  override def shouldVisitNextChild(node: RuleNode, currentResult: Ast | Null) =
    true

  override def aggregateResult(aggregate: Ast | Null, nextResult: Ast | Null) =
    nextResult

end ParserVisitor
