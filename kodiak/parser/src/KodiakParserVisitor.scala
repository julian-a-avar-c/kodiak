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
        val exprs: Seq[Ast.Expr] =
          ctx.expr().asScala.toSeq.collect(visitExpr(_).get)
        Some(Ast.Stmts(exprs))
  end visitStmts

  override def visitExpr(ctx: ExprContext | Null): Option[Ast.Expr] =
    ctx match
      case null             => None
      case ctx: ExprContext =>
        for expr <- visitExprHead(ctx.exprHead())
        yield expr
  end visitExpr

  override def visitExprHead(ctx: ExprHeadContext | Null): Option[Ast.Expr] =
    ctx match
      case ctx: ExprHeadContext =>
        val rawNumberBlock =
          Option.fromNullable(ctx.rawNumberBlock()).flatMap(visitRawNumberBlock)
        val rawNumberWord =
          Option.fromNullable(ctx.rawNumberWord()).flatMap(visitRawNumberWord)
        val textBlock =
          Option.fromNullable(ctx.textBlock()).flatMap(visitTextBlock)
        val textWord =
          Option.fromNullable(ctx.textWord()).flatMap(visitTextWord)
        val rawIdBlock =
          Option.fromNullable(ctx.rawIdBlock()).flatMap(visitRawIdBlock)
        val rawIdWord =
          Option.fromNullable(ctx.rawIdWord()).flatMap(visitRawIdWord)
        val rawIdTail =
          Option.fromNullable(ctx.rawIdTail()).flatMap(visitRawIdTail)
        val decimal =
          Option.fromNullable(ctx.decimal()).flatMap(visitDecimal)
        val integer =
          Option.fromNullable(ctx.integer()).flatMap(visitInteger)
        val plainId =
          Option.fromNullable(ctx.plainId()).flatMap(visitPlainId)

        Seq(
          rawNumberBlock,
          rawNumberWord,
          textBlock,
          textWord,
          if rawIdTail.isDefined
          then
            val rawIdHead = rawIdBlock orElse rawIdWord
            rawIdTail.map {
              _ match
                case RawNumber(_, value) => RawNumber(rawIdHead, value)
                case Text(value)         => ComplexText(rawIdHead, value)
            }
          else None,
          rawIdBlock,
          rawIdWord,
          decimal,
          integer,
          plainId,
        )
          .reduce { _ orElse _ }
      case null => None
    end match
  end visitExprHead

  override def visitRawIdTail(
      ctx: RawIdTailContext | Null,
  ): Option[Ast.RawNumber | Ast.Text] =
    ctx match
      case null                  => None
      case ctx: RawIdTailContext =>
        val rawNumberBlock =
          Option.fromNullable(ctx.rawNumberBlock()).flatMap(visitRawNumberBlock)
        val rawNumberWord =
          Option.fromNullable(ctx.rawNumberWord()).flatMap(visitRawNumberWord)
        val textBlock =
          Option.fromNullable(ctx.textBlock()).flatMap(visitTextBlock)
        val textWord =
          Option.fromNullable(ctx.textWord()).flatMap(visitTextWord)

        Seq(
          rawNumberBlock,
          rawNumberWord,
          textBlock,
          textWord,
        )
          .reduce { _ orElse _ }
  end visitRawIdTail

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
