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
    boundary:
      if ctx == null then break(Ast.Program.empty)
      val stmts = visitStmts(ctx.nn.stmts())
      if stmts == null then break(Ast.Program.empty)
      Ast.Program(stmts)

  override def visitStmts(ctx: StmtsContext | Null): Ast.Stmts =
    boundary:
      if ctx == null then break(Ast.Stmts.empty)
      val stmtSeq =
        ctx.nn
          .stmt()
          .asScala
          .toSeq
          .map(visitStmt)
          .collect { case stmt: Ast.Stmt => stmt }
      Ast.Stmts(stmtSeq*)

  override def visitStmt(ctx: StmtContext | Null): Ast.Stmt | Null =
    boundary:
      if ctx == null then break(null)

      var result: Ast.Stmt | Null = null
      lazy val expr               = ctx.nn.expr()
      if expr != null then result = visitExpr(expr)

      result

  override def visitExpr(ctx: ExprContext | Null): Ast.Expr | Null =
    boundary:
      if ctx == null then break(null)

      var result: Ast.Expr | Null = null
      lazy val exprHead           = ctx.nn.exprHead()
      if exprHead != null then result = visitExprHead(exprHead)

      result

  override def visitExprHead(ctx: ExprHeadContext | Null): Ast.Expr | Null =
    boundary:
      if ctx == null then break(null)

      var result: Ast.Expr | Null = null

      lazy val `true`  = ctx.nn.TRUE()
      lazy val `false` = ctx.nn.FALSE()
      lazy val unit    = ctx.nn.UNIT()
      lazy val integer = ctx.nn.integer()

      if `true` != null then result = Ast.True
      if `false` != null then result = Ast.False
      if unit != null then result = Ast.Unit
      if integer != null then result = visitInteger(integer)

      result

  override def visitInteger(ctx: IntegerContext): Ast.Integer =
    Ast.Integer(ctx.getText().toInt)

  // override def visitProgram(ctx: ProgramContext): Ast.Program =
  //   val stmts: Ast.Stmts = visitStmts(ctx.stmts())
  //   Ast.Program(stmts)
  // end visitProgram

  // override def visitStmts(ctx: StmtsContext): Ast.Stmts = boundary:
  //   if ctx == null then break(Ast.Stmts(Seq.empty*))

  //   val stmtsSeq = ctx.stmt().asScala.toSeq.map(visitStmt)
  //   Ast.Stmts(stmtsSeq*)
  // end visitStmts

  // override def visitStmtSep(ctx: StmtSepContext): Null =
  //   null

  // override def visitStmt(ctx: StmtContext): Ast.Stmt =
  //   // lazy val decl                   = Option(ctx.decl()).map(visitDecl)
  //   lazy val ifStmt: Option[Ast.If] =
  //     ??? // Option(ctx.ifStmt()).map(visitIfStmt)
  //   lazy val whileStmt: Option[Ast.While] =
  //     ??? // Option(ctx.whileStmt()).map(visitWhileStmt)
  //   lazy val forStmt: Option[Ast.For] =
  //     ??? // Option(ctx.forStmt()).map(visitForStmt)
  //   lazy val expr = Option(ctx.expr()).map(visitExpr)
  //   Seq(
  //     // decl,
  //     // ifStmt, whileStmt, forStmt,
  //     expr,
  //   )
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitStmt

  // override def visitDecl(ctx: DeclContext): Ast.Decl =
  //   lazy val valDecl = Option(ctx.valDecl()).map(visitValDecl)
  //   Seq(
  //     valDecl,
  //   )
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitDecl

  // override def visitValDecl(ctx: ValDeclContext): Ast.ValDecl =
  //   val id    = visitId(ctx.id())
  //   val op    = Ast.Id("=")
  //   val value = visitExpr(ctx.expr())
  //   Ast.ValDecl(id, op, value)
  // end visitValDecl

  // override def visitVarDecl(ctx: VarDeclContext) =
  //   visitChildren(ctx)

  // override def visitSetDecl(ctx: SetDeclContext) =
  //   visitChildren(ctx)

  // override def visitEqDeclOp(ctx: EqDeclOpContext) =
  //   visitChildren(ctx)

  // override def visitPlainEqDeclOp(ctx: PlainEqDeclOpContext) =
  //   visitChildren(ctx)

  // override def visitRawEqDeclOp(ctx: RawEqDeclOpContext) =
  //   visitChildren(ctx)

  // // TODO
  // override def visitExpr(ctx: ExprContext): Ast.Expr =
  //   lazy val `if`: Option[Ast.If]       = ??? // Option(ctx.if_()).map(visitIf)
  //   lazy val `match`: Option[Ast.Match] =
  //     ??? // Option(ctx.`match`()).map(visitMatch)
  //   lazy val `for`: Option[Ast.For]     =
  //     ??? // Option(ctx.for_()).map(visitFor)
  //   // lazy val fnApp: Option[Ast.FnApp]   =
  //   //   Option(ctx.fnApp()).map(visitFnApp)
  //   // lazy val opApp: Option[Ast.FnApp] =
  //   //   Option(ctx.opApp()).map(visitOpApp)
  //   lazy val pathApp: Option[Ast.PathApp] =
  //     ??? // Option(ctx.pathApp()).map(visitPathApp)
  //   lazy val exprHead: Option[Ast.Expr] =
  //     Option(ctx.exprHead()).map(visitExprHead)
  //   Seq(
  //     // `if`, `match`, `for`, fnApp, opApp, pathApp,
  //     exprHead,
  //   )
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitExpr

  // override def visitIfStmt(ctx: IfStmtContext) =
  //   visitChildren(ctx)

  // override def visitIf(ctx: IfContext) =
  //   visitChildren(ctx)

  // override def visitMatch(ctx: MatchContext) =
  //   visitChildren(ctx)

  // override def visitMatchBranch(ctx: MatchBranchContext) =
  //   visitChildren(ctx)

  // override def visitForStmt(ctx: ForStmtContext) =
  //   visitChildren(ctx)

  // override def visitFor(ctx: ForContext) =
  //   visitChildren(ctx)

  // override def visitForEnumerator(ctx: ForEnumeratorContext) =
  //   visitChildren(ctx)

  // override def visitWhileStmt(ctx: WhileStmtContext) =
  //   visitChildren(ctx)

  // override def visitFnApp(ctx: FnAppContext): Ast.FnApp =
  //   val fn   = visitExprHead(ctx.exprHead())
  //   val args = visitCollection(ctx.collection())
  //   Ast.FnApp(fn, args)
  // end visitFnApp

  // override def visitOpApp(ctx: OpAppContext): Ast.FnApp =
  //   val fn   = visitId(ctx.id())
  //   val args = Ast.Tuple(
  //     Ast.Collection.Items(
  //       ctx.exprHead().asScala.toSeq.map(visitExprHead),
  //     ),
  //   )
  //   Ast.FnApp(fn, args)
  // end visitOpApp

  // override def visitPathApp(ctx: PathAppContext) =
  //   visitChildren(ctx)

  // override def visitStaticPathApp(ctx: StaticPathAppContext) =
  //   visitChildren(ctx)

  // override def visitIndexPathApp(ctx: IndexPathAppContext) =
  //   visitChildren(ctx)

  // override def visitExprHead(ctx: ExprHeadContext): Ast.Expr =
  //   println(Console.RED)
  //   println(">")
  //   println(s"> ${ctx.getText()}")
  //   println(">")
  //   println(Console.RESET)

  //   lazy val `true`  = Option.fromNullable(ctx.TRUE()).map(_ => Ast.True)
  //   lazy val `false` = Option.fromNullable(ctx.FALSE()).map(_ => Ast.False)
  //   lazy val unit    = Option.fromNullable(ctx.UNIT()).map(_ => Ast.Unit)
  //   // lazy val plainText = Option(ctx.plainText()).map(visitPlainText)
  //   // lazy val decimal   = Option(ctx.decimal()).map(visitDecimal)
  //   lazy val integer = Option.fromNullable(ctx.integer()).map(visitInteger)
  //   // lazy val plainId   = Option(ctx.plainId()).map(visitPlainId)
  //   Seq(
  //     `true`,
  //     `false`,
  //     unit,
  //     // plainText,
  //     // decimal,
  //     integer,
  //     // plainId
  //   )
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitExprHead

  // override def visitBlock(ctx: BlockContext) =
  //   visitChildren(ctx)

  // // --------------------------------------------------------------------------

  // override def visitArgs(ctx: ArgsContext) =
  //   visitChildren(ctx)

  // override def visitGroup(ctx: GroupContext) =
  //   visitChildren(ctx)

  // override def visitCollection(ctx: CollectionContext): Ast.Collection =
  //   lazy val tuple = Option(ctx.tuple()).map(visitTuple)
  //   lazy val array = Option(ctx.array()).map(visitArray)
  //   lazy val set   = Option(ctx.set()).map(visitSet)
  //   Seq(tuple, array, set)
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitCollection

  // override def visitTupleGroup(ctx: TupleGroupContext): Ast.Expr =
  //   visitExpr(ctx.expr())

  // override def visitArrayGroup(ctx: ArrayGroupContext): Ast.Expr =
  //   visitExpr(ctx.expr())

  // override def visitSetGroup(ctx: SetGroupContext): Ast.Expr =
  //   visitExpr(ctx.expr())

  // override def visitTuple(ctx: TupleContext): Ast.Tuple =
  //   val collectionItems = visitCollectionItems(ctx.collectionItems())
  //   Ast.Tuple(collectionItems)

  // override def visitArray(ctx: ArrayContext): Ast.Array =
  //   val collectionItems = visitCollectionItems(ctx.collectionItems())
  //   Ast.Array(collectionItems)

  // override def visitSet(ctx: SetContext): Ast.Set =
  //   val collectionItems = visitCollectionItems(ctx.collectionItems())
  //   Ast.Set(collectionItems)

  // override def visitCollectionItems(
  //     ctx: CollectionItemsContext,
  // ): Ast.Collection.Items =
  //   Ast.Collection.Items(ctx.expr().asScala.toSeq.map(visitExpr))

  // override def visitCollectionSep(ctx: CollectionSepContext) =
  //   visitChildren(ctx)

  // // TODO: fix later.
  // override def visitInteger(ctx: IntegerContext): Ast.Integer =
  //   Ast.Integer(ctx.getText().toInt)
  // end visitInteger

  // // TODO: fix later.
  // override def visitDecimal(ctx: DecimalContext): Ast.Decimal =
  //   Ast.Decimal(ctx.getText().toDouble)

  // override def visitRawNumber(ctx: RawNumberContext) =
  //   visitChildren(ctx)

  // override def visitRawNumberBlock(ctx: RawNumberBlockContext) =
  //   visitChildren(ctx)

  // override def visitRawNumberWord(ctx: RawNumberWordContext) =
  //   visitChildren(ctx)

  // override def visitPlainText(ctx: PlainTextContext): Ast.Text =
  //   lazy val plainTextBlock =
  //     ??? // Option(ctx.plainTextBlock()).map(visitPlainTextBlock)
  //   lazy val plainTextWord =
  //     Option(ctx.plainTextWord()).map(visitPlainTextWord)
  //   Seq(
  //     // plainTextBlock,
  //     plainTextWord,
  //   )
  //     .find(_.isDefined)
  //     .flatten
  //     .get
  // end visitPlainText

  // override def visitPlainTextBlock(ctx: PlainTextBlockContext) =
  //   visitChildren(ctx)

  // override def visitPlainTextWord(ctx: PlainTextWordContext): Ast.Text =
  //   Ast.Text(ctx.WORD().asScala.mkString(""))

  // // TODO: Add additional cases
  // override def visitId(ctx: IdContext): Ast.Id =
  //   visitPlainId(ctx.plainId())

  // override def visitPlainId(ctx: PlainIdContext): Ast.Id =
  //   Ast.Id(ctx.getText())

  // override def visitRawId(ctx: RawIdContext) =
  //   visitChildren(ctx)

  // override def visitRawIdWord(ctx: RawIdWordContext) =
  //   visitChildren(ctx)

  // override def visitRawIdBlock(ctx: RawIdBlockContext) =
  //   visitChildren(ctx)

  // // --------------------------------------------------------------------------

  // override def visitChildren(node: RuleNode) =
  //   var result = defaultResult()
  //   val n      = node.getChildCount()
  //   for i <- 0 until n do
  //     boundary {
  //       if !shouldVisitNextChild(node, result)
  //       then break()
  //       val c           = node.getChild(i)
  //       val childResult = c.accept(this)
  //       result = aggregateResult(result, childResult)
  //     }
  //   end for

  //   result
  // end visitChildren

  // override def defaultResult() = null

  // override def shouldVisitNextChild(node: RuleNode, currentResult: Ast | Null) =
  //   true

  // override def aggregateResult(aggregate: Ast | Null, nextResult: Ast | Null) =
  //   nextResult

end ParserVisitor
