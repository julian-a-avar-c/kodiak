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
    val stmts = visitStmts(ctx.nn.stmts())
    Ast.Program(stmts.nn)

  override def visitStmts(ctx: StmtsContext | Null): Ast.Stmts | Null =
    val stmts = ctx.nn
      .stmt()
      .asScala
      .toSeq
      .map(visitStmt)
      .collect { case stmt: Ast.Stmt => stmt }
    Ast.Stmts(stmts*)
  end visitStmts

  override def visitStmt(ctx: StmtContext | Null): Ast.Stmt =
    visitExpr(ctx.nn.expr())

  override def visitExpr(ctx: ExprContext): Ast.Expr =
    lazy val group      = Option(ctx.group()).map(visitGroup)
    lazy val collection = Option(ctx.collection()).map(visitCollection)
    lazy val app        = Option(ctx.app()).map(visitApp)

    Seq(
      group,
      collection,
      app,
    ).find(_.isDefined).flatten.get
  end visitExpr

  def visitApp(ctx: AppContext): Ast.Expr =
    ctx match
      case fnApp: FnAppContext       => visitFnApp(fnApp)
      case pathApp: PathAppContext   => visitPathApp(pathApp)
      case opApp: OpAppContext       => visitOpApp(opApp)
      case exprHead: ExprHeadContext => visitExprHead(exprHead)
      case _ => throw new RuntimeException("Unknown app type")

  override def visitFnApp(ctx: FnAppContext): Ast.FnApp =
    val fn   = visitApp(ctx.app())
    val args =
      ctx.args().asScala.map(visitArgs).head.asInstanceOf[Ast.Collection]
    Ast.FnApp(fn, args)
  end visitFnApp

  override def visitPathApp(ctx: PathAppContext): Ast.PathApp =
    val receiver = visitApp(ctx.receiver)
    val member   = visitSimpleExpr(ctx.member)
    Ast.PathApp(receiver, member)
  end visitPathApp

  override def visitOpApp(ctx: OpAppContext): Ast.OpApp =
    val left  = visitApp(ctx.left)
    val op    = visitId(ctx.op).asInstanceOf[Ast.Id] // Fix
    val right = visitSimpleExpr(ctx.right)           // Fix
    Ast.OpApp(left, op, right)
  end visitOpApp

  override def visitExprHead(ctx: ExprHeadContext | Null): Ast.Expr =
    visitComplexExpr(ctx.nn.complexExpr())

  override def visitComplexExpr(ctx: ComplexExprContext | Null): Ast.Expr =
    visitSimpleExpr(ctx.nn.simpleExpr())

  override def visitSimpleExpr(ctx: SimpleExprContext): Ast.Expr =
    lazy val `true`    = Option(ctx.TRUE()).map(_ => Ast.True)
    lazy val `false`   = Option(ctx.FALSE()).map(_ => Ast.False)
    lazy val unit      = Option(ctx.UNIT()).map(_ => Ast.Unit)
    lazy val decimal   = Option(ctx.decimal()).map(visitDecimal)
    lazy val integer   = Option(ctx.integer()).map(visitInteger)
    lazy val textBlock = Option(ctx.textBlock()).map(visitTextBlock)
    lazy val textWord  = Option(ctx.textWord()).map(visitTextWord)
    lazy val plainId   = Option(ctx.plainId()).map(visitPlainId)

    Seq[Option[Ast.Expr]](
      `true`,
      `false`,
      unit,
      decimal,
      integer,
      textBlock,
      textWord,
      plainId,
    ).find(_.isDefined).flatten.get
  end visitSimpleExpr

  // --------------------------------------------------------------------------

  override def visitGroup(ctx: GroupContext): Ast.Expr =
    lazy val tupleGroup = Option(ctx.tupleGroup()).map(visitTupleGroup)
    lazy val arrayGroup = Option(ctx.arrayGroup()).map(visitArrayGroup)
    lazy val setGroup   = Option(ctx.setGroup()).map(visitSetGroup)

    Seq(
      tupleGroup,
      arrayGroup,
      setGroup,
    ).find(_.isDefined).flatten.get
  end visitGroup

  override def visitTupleGroup(ctx: TupleGroupContext): Ast.Expr =
    visitExpr(ctx.expr())

  override def visitArrayGroup(ctx: ArrayGroupContext): Ast.Expr =
    visitExpr(ctx.expr())

  override def visitSetGroup(ctx: SetGroupContext): Ast.Expr =
    visitExpr(ctx.expr())

  override def visitCollection(ctx: CollectionContext): Ast.Expr =
    lazy val tuple = Option(ctx.tupleExpr()).map(visitTupleExpr)
    lazy val array = Option(ctx.arrayExpr()).map(visitArrayExpr)
    lazy val set   = Option(ctx.setExpr()).map(visitSetExpr)

    Seq(
      tuple,
      array,
      set,
    ).find(_.isDefined).flatten.get
  end visitCollection

  override def visitTupleExpr(ctx: TupleExprContext): Ast.Tuple =
    Ast.Tuple(visitCollectionItems(ctx.collectionItems()))

  override def visitArrayExpr(ctx: ArrayExprContext): Ast.Array =
    Ast.Array(visitCollectionItems(ctx.collectionItems()))

  override def visitSetExpr(ctx: SetExprContext): Ast.Set =
    Ast.Set(visitCollectionItems(ctx.collectionItems()))

  override def visitCollectionItems(
      ctx: CollectionItemsContext,
  ): Ast.Collection.Items =
    Ast.Collection.Items(ctx.expr().asScala.toSeq.map(visitExpr)*)

  // --------------------------------------------------------------------------

  override def visitDecimal(ctx: DecimalContext): Ast.Decimal =
    Ast.Decimal(ctx.getText().toDouble)

  override def visitInteger(ctx: IntegerContext): Ast.Integer =
    Ast.Integer(ctx.getText().toInt)

  override def visitTextBlock(ctx: TextBlockContext): Ast.PlainText =
    Ast.PlainText(ctx.getText().drop(2).dropRight(1))

  override def visitTextWord(ctx: TextWordContext): Ast.PlainText =
    Ast.PlainText(ctx.getText().drop(1))

  override def visitPlainId(ctx: PlainIdContext): Ast.Id =
    Ast.Id(ctx.getText())

end ParserVisitor
