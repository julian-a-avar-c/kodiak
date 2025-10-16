package kodiak.parser

import kodiak.antlr.KodiakParserBaseVisitor
import kodiak.antlr.KodiakParser.*
import scala.util.boundary, boundary.break

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
        for expr <- visitExpr(ctx.expr())
        yield Ast.Stmts(Seq(expr))
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
      case null                 => None
      case ctx: ExprHeadContext =>
        Seq(
          visitRawNumberBlock(ctx.rawNumberBlock()),
          visitRawNumberWord(ctx.rawNumberWord()),
          visitTextBlock(ctx.textBlock()),
          visitTextWord(ctx.textWord()),
          visitRawIdBlock(ctx.rawIdBlock()),
          visitRawIdWord(ctx.rawIdWord()),
          visitDecimal(ctx.decimal()),
          visitInteger(ctx.integer()),
          visitPlainId(ctx.plainId()),
        )
          .reduce { _ orElse _ }
  end visitExprHead

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
