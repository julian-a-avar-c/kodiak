package kodiak.parser

import kodiak.antlr.KodiakParserBaseVisitor
import kodiak.antlr.KodiakParser.*
import scala.util.boundary, boundary.break
import kodiak.parser.Ast.RawNumber
import kodiak.parser.Ast.Text
import kodiak.parser.Ast.ComplexText

class KodiakParserVisitor
    extends kodiak.antlr.KodiakParserBaseVisitor[Option[Ast | Null]]:

  override def visitProgram(ctx: ProgramContext | Null): Option[Ast.Program] =
    ctx match
      case null                => None
      case ctx: ProgramContext =>
        for stmts <- visitStmts(ctx.stmts())
        yield Ast.Program(stmts)
  end visitProgram

  override def visitStmts(ctx: StmtsContext | Null): Option[Ast.Stmts] =
    ctx match
      case null              => None
      case ctx: StmtsContext =>
        import scala.jdk.CollectionConverters.*
        val exprs = ctx.expr().asScala.toSeq.collect(visitExpr(_).get)
        Some(Ast.Stmts(exprs))
  end visitStmts

  def visitExpr(ctx: ExprContext | Null): Option[Ast.Expr] =
    ctx match
      case null => None
      case ctx  =>
        Option.fromNullable(ctx).flatMap {
          case ctx: GroupExprContext => visitGroupExpr(ctx)
          case ctx: OpAppContext     => visitOpApp(ctx)
          case ctx: ExprHeadContext  => visitExprHead(ctx)
        }

  end visitExpr

  override def visitGroupExpr(
      ctx: GroupExprContext | Null,
  ): Option[Ast.Expr] =
    import scala.jdk.CollectionConverters.given
    ctx match
      case null => None
      case ctx  =>
        for expr <- Option.fromNullable(ctx.group()).flatMap(visitGroup)
        yield expr
    end match
  end visitGroupExpr

  override def visitOpApp(ctx: OpAppContext | Null): Option[Ast.OpApp] =
    import scala.jdk.CollectionConverters.given
    ctx match
      case null => None
      case ctx  =>
        for
          left  <- Option.fromNullable(ctx.expr(0)).flatMap(visitExpr)
          op    <- Option.fromNullable(ctx.anyId()).flatMap(visitAnyId)
          right <- Option.fromNullable(ctx.expr(1)).flatMap(visitExpr)
        yield Ast.OpApp(left, op, right)
    end match
  end visitOpApp

  override def visitExprHead(ctx: ExprHeadContext | Null): Option[Ast.Expr] =
    ctx match
      case null => None
      case ctx  =>
        Option.fromNullable(ctx.simpleExpr()).flatMap(visitSimpleExpr)
  end visitExprHead

  override def visitSimpleExpr(
      ctx: SimpleExprContext | Null,
  ): Option[Ast.Expr] =
    ctx match
      case ctx: SimpleExprContext =>
        val `true`         =
          Option.fromNullable(ctx.TRUE()).map(_ => Ast.True)
        val `false`        =
          Option.fromNullable(ctx.FALSE()).map(_ => Ast.False)
        val textBlock      =
          Option.fromNullable(ctx.textBlock()).flatMap(visitTextBlock)
        val textWord       =
          Option.fromNullable(ctx.textWord()).flatMap(visitTextWord)
        val rawNumberBlock =
          Option.fromNullable(ctx.rawNumberBlock()).flatMap(visitRawNumberBlock)
        val rawNumberWord  =
          Option.fromNullable(ctx.rawNumberWord()).flatMap(visitRawNumberWord)
        val rawIdBlock     =
          Option.fromNullable(ctx.rawIdBlock()).flatMap(visitRawIdBlock)
        val rawIdWord      =
          Option.fromNullable(ctx.rawIdWord()).flatMap(visitRawIdWord)
        val decimal        =
          Option.fromNullable(ctx.decimal()).flatMap(visitDecimal)
        val integer        =
          Option.fromNullable(ctx.integer()).flatMap(visitInteger)
        val plainId        =
          Option.fromNullable(ctx.plainId()).flatMap(visitPlainId)

        val startsWithId =
          Option
            .fromNullable(ctx.idTail())
            .flatMap(visitIdTail)
            .map {
              val idHead = rawIdBlock orElse rawIdWord orElse plainId
              _ match
                case RawNumber(_, value) => RawNumber(idHead, value)
                case Text(value)         => ComplexText(idHead, value)
            }

        Seq(
          `true`,
          `false`,
          textBlock,
          textWord,
          rawNumberBlock,
          rawNumberWord,
          startsWithId,
          rawIdBlock,
          rawIdWord,
          decimal,
          integer,
          plainId,
        )
          .find(_.isDefined)
          .flatten
      case null                   => None
    end match
  end visitSimpleExpr

  override def visitIdTail(
      ctx: IdTailContext | Null,
  ): Option[Ast.RawNumber | Ast.Text] =
    ctx match
      case null               => None
      case ctx: IdTailContext =>
        val textBlock      =
          Option.fromNullable(ctx.textBlock()).flatMap(visitTextBlock)
        val textWord       =
          Option.fromNullable(ctx.textWord()).flatMap(visitTextWord)
        val rawNumberBlock =
          Option.fromNullable(ctx.rawNumberBlock()).flatMap(visitRawNumberBlock)
        val rawNumberWord  =
          Option.fromNullable(ctx.rawNumberWord()).flatMap(visitRawNumberWord)

        Seq(
          textBlock,
          textWord,
          rawNumberBlock,
          rawNumberWord,
        )
          .find(_.isDefined)
          .flatten
  end visitIdTail

  // --------------------------------------------------------------------------

  override def visitCtl(ctx: (CtlContext) | Null): (Option[Ast.If]) =
    ctx match
      case null => None
      case ctx  =>
        val `if` = Option.fromNullable(ctx.if_()).flatMap(visitIf_)
        Seq(
          `if`,
        ).find(_.isDefined).flatten
  end visitCtl

  override def visitIf_(ctx: (If_Context) | Null): (Option[Ast.If]) =
    ctx match
      case null => None
      case ctx  =>
        for
          condition   <- Option.fromNullable(ctx.expr(0)).flatMap(visitExpr)
          consequent  <- Option.fromNullable(ctx.expr(1)).flatMap(visitExpr)
          alternative <- Option.fromNullable(ctx.expr(2)).flatMap(visitExpr)
        yield Ast.If(condition, consequent, alternative)
  end visitIf_

  // --------------------------------------------------------------------------

  override def visitGroup(
      ctx: GroupContext | Null,
  ): Option[Ast.Expr] =
    ctx match
      case null => None
      case ctx  =>
        val tupleGroup =
          Option.fromNullable(ctx.tupleGroup()).flatMap(visitTupleGroup)
        Seq(
          tupleGroup,
        )
          .find(_.isDefined)
          .flatten
    end match
  end visitGroup

  override def visitTupleGroup(
      ctx: TupleGroupContext | Null,
  ): Option[Ast.Expr] =
    ctx match
      case null => None
      case ctx  =>
        val expr =
          Option.fromNullable(ctx.expr()).flatMap(visitExpr)
        val ctl  =
          Option.fromNullable(ctx.ctl()).flatMap(visitCtl)
        Seq(
          expr,
          ctl,
        )
          .find(_.isDefined)
          .flatten
    end match
  end visitTupleGroup

  // --------------------------------------------------------------------------

  override def visitRawNumberBlock(
      ctx: RawNumberBlockContext | Null,
  ): Option[Ast.RawNumber] =
    ctx match
      case null                       => None
      case ctx: RawNumberBlockContext =>
        Some(Ast.RawNumber(ctx.getText().drop(2).dropRight(1)))
  end visitRawNumberBlock

  override def visitRawNumberWord(
      ctx: RawNumberWordContext | Null,
  ): Option[Ast.RawNumber] =
    ctx match
      case null                      => None
      case ctx: RawNumberWordContext =>
        Some(Ast.RawNumber(ctx.getText().tail))
  end visitRawNumberWord

  override def visitDecimal(ctx: DecimalContext | Null): Option[Ast.Decimal] =
    ctx match
      case null                => None
      case ctx: DecimalContext =>
        Some(Ast.Decimal(ctx.getText().toDouble))
  end visitDecimal

  override def visitInteger(ctx: IntegerContext | Null): Option[Ast.Integer] =
    ctx match
      case null                => None
      case ctx: IntegerContext =>
        Some(Ast.Integer(ctx.getText().toInt))
  end visitInteger

  override def visitTextBlock(
      ctx: TextBlockContext | Null,
  ): Option[Ast.Text] =
    ctx match
      case null                  => None
      case ctx: TextBlockContext =>
        Some(Ast.Text(ctx.getText().drop(2).dropRight(1)))
  end visitTextBlock

  override def visitTextWord(
      ctx: TextWordContext | Null,
  ): Option[Ast.Text] =
    ctx match
      case null                 => None
      case ctx: TextWordContext =>
        Some(Ast.Text(ctx.getText().tail))
  end visitTextWord

  override def visitAnyId(ctx: AnyIdContext | Null): Option[Ast.Id] =
    ctx match
      case null              => None
      case ctx: AnyIdContext =>
        val rawIdBlock =
          Option.fromNullable(ctx.rawIdBlock()).flatMap(visitRawIdBlock)
        val rawIdWord  =
          Option.fromNullable(ctx.rawIdWord()).flatMap(visitRawIdWord)
        val plainId    =
          Option.fromNullable(ctx.plainId()).flatMap(visitPlainId)

        Seq(
          rawIdBlock,
          rawIdWord,
          plainId,
        )
          .find(_.isDefined)
          .flatten
  end visitAnyId

  override def visitPlainId(ctx: PlainIdContext | Null): Option[Ast.Id] =
    ctx match
      case null                => None
      case ctx: PlainIdContext =>
        Some(Ast.Id(ctx.getText()))
  end visitPlainId

  override def visitRawIdWord(ctx: RawIdWordContext | Null): Option[Ast.Id] =
    ctx match
      case null                  => None
      case ctx: RawIdWordContext =>
        Some(Ast.Id(ctx.getText().tail))
  end visitRawIdWord

  override def visitRawIdBlock(ctx: RawIdBlockContext | Null): Option[Ast.Id] =
    ctx match
      case null                   => None
      case ctx: RawIdBlockContext =>
        Some(Ast.Id(ctx.getText().drop(2).dropRight(1)))
  end visitRawIdBlock

end KodiakParserVisitor
