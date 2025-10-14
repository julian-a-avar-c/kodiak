package kodiak.antlr

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import kodiak.antlr.KodiakParser.ProgramContext
import kodiak.antlr.KodiakParser.IdContext
import kodiak.antlr.KodiakParser.SswsContext
import kodiak.antlr.KodiakParser.RawBlockContext
import kodiak.antlr.KodiakParser.TupleGroupContext
import kodiak.antlr.KodiakParser.AnyCollectionContext
import kodiak.antlr.KodiakParser.ForExprContext
import kodiak.antlr.KodiakParser.TextWordContext
import kodiak.antlr.KodiakParser.SomeNamedTupleExprContext
import kodiak.antlr.KodiakParser.TypeContext
import kodiak.antlr.KodiakParser.AnyExprContext
import kodiak.antlr.KodiakParser.IdBlockContext
import kodiak.antlr.KodiakParser.ArrayGroupContext
import kodiak.antlr.KodiakParser.GroupContext
import kodiak.antlr.KodiakParser.GeneratorStmtsContext
import kodiak.antlr.KodiakParser.DecimalContext
import kodiak.antlr.KodiakParser.NamedSetExprContext
import kodiak.antlr.KodiakParser.StmtSepContext
import kodiak.antlr.KodiakParser.StmtContext
import kodiak.antlr.KodiakParser.SlContext
import kodiak.antlr.KodiakParser.WordContext
import kodiak.antlr.KodiakParser.TupleArgsContext
import kodiak.antlr.KodiakParser.SomeNamedCollectionContext
import kodiak.antlr.KodiakParser.MatchBranchContext
import kodiak.antlr.KodiakParser.NamedCollectionItemsContext
import kodiak.antlr.KodiakParser.CollectionItemsContext
import kodiak.antlr.KodiakParser.MatchExprContext
import kodiak.antlr.KodiakParser.LetDeclContext
import kodiak.antlr.KodiakParser.ArrayExprContext
import kodiak.antlr.KodiakParser.FnExprContext
import kodiak.antlr.KodiakParser.WhileExprContext
import kodiak.antlr.KodiakParser.NumberWordContext
import kodiak.antlr.KodiakParser.SetExprContext
import kodiak.antlr.KodiakParser.SetDeclContext
import kodiak.antlr.KodiakParser.DeclContext
import kodiak.antlr.KodiakParser.WsContext
import kodiak.antlr.KodiakParser.StmtBlockContext
import kodiak.antlr.KodiakParser.SetArgsContext
import kodiak.antlr.KodiakParser.CollectionContext
import kodiak.antlr.KodiakParser.MatchBranchPatternElseContext
import kodiak.antlr.KodiakParser.TextBlockContext
import kodiak.antlr.KodiakParser.SomeNamedArrayExprContext
import kodiak.antlr.KodiakParser.CtlExprContext
import kodiak.antlr.KodiakParser.CollectionAssignmentContext
import kodiak.antlr.KodiakParser.IdWordContext
import kodiak.antlr.KodiakParser.SetGroupContext
import kodiak.antlr.KodiakParser.ArgsContext
import kodiak.antlr.KodiakParser.GeneratorStmtContext
import kodiak.antlr.KodiakParser.IntegerContext
import kodiak.antlr.KodiakParser.NamedArrayExprContext
import kodiak.antlr.KodiakParser.StmtsContext
import kodiak.antlr.KodiakParser.NlContext
import kodiak.antlr.KodiakParser.IdHeadContext
import kodiak.antlr.KodiakParser.ArrayArgsContext
import kodiak.antlr.KodiakParser.NamedCollectionContext
import kodiak.antlr.KodiakParser.MatchBranchPatternWithContext
import kodiak.antlr.KodiakParser.SomeNamedCollectionItemsContext
import kodiak.antlr.KodiakParser.SomeNamedSetExprContext
import kodiak.antlr.KodiakParser.IfExprContext
import kodiak.antlr.KodiakParser.AssignmentContext
import kodiak.antlr.KodiakParser.PlainIdContext
import kodiak.antlr.KodiakParser.TupleExprContext
import kodiak.antlr.KodiakParser.SimpleExprContext
import kodiak.antlr.KodiakParser.GeneratorConditionalContext
import kodiak.antlr.KodiakParser.NumberBlockContext
import kodiak.antlr.KodiakParser.NamedTupleExprContext
import kodiak.antlr.KodiakParser.VarDeclContext
import kodiak.antlr.KodiakParser.ValDeclContext

object MyParser:
  def parse(
      input: String,
  ): KodiakParser | Null =
    val inputStream       = CharStreams.fromString(input)
    val kodiakLexer       = new KodiakLexer(inputStream)
    val commonTokenStream = new CommonTokenStream(kodiakLexer)
    new KodiakParser(commonTokenStream)
  end parse

  def toAst(
      ctx: KodiakParserContext | Null,
  ): Ast | Null =
    val visitor = new ParserVisitor
    ctx match
      // Else
      case null => ???
      //
      case ctx: ProgramContext => visitor.visitProgram(ctx)
      case ctx: StmtsContext   => visitor.visitStmts(ctx)
      case ctx: StmtContext    => visitor.visitStmt(ctx)
      case ctx: StmtSepContext => visitor.visitStmtSep(ctx)
      //
      case ctx: DeclContext                 => visitor.visitDecl(ctx)
      case ctx: ValDeclContext              => visitor.visitValDecl(ctx)
      case ctx: VarDeclContext              => visitor.visitVarDecl(ctx)
      case ctx: SetDeclContext              => visitor.visitSetDecl(ctx)
      case ctx: LetDeclContext              => visitor.visitLetDecl(ctx)
      case ctx: AssignmentContext           => visitor.visitAssignment(ctx)
      case ctx: CollectionAssignmentContext =>
        visitor.visitCollectionAssignment(ctx)
      //
      case ctx: AnyExprContext => visitor.visitAnyExpr(ctx)
      case ctx: TypeContext    => visitor.visitType(ctx)
      //
      case ctx: CtlExprContext                => visitor.visitCtlExpr(ctx)
      case ctx: IfExprContext                 => visitor.visitIfExpr(ctx)
      case ctx: MatchExprContext              => visitor.visitMatchExpr(ctx)
      case ctx: MatchBranchContext            => visitor.visitMatchBranch(ctx)
      case ctx: MatchBranchPatternWithContext =>
        visitor.visitMatchBranchPatternWith(ctx)
      case ctx: MatchBranchPatternElseContext =>
        visitor.visitMatchBranchPatternElse(ctx)
      case ctx: ForExprContext              => visitor.visitForExpr(ctx)
      case ctx: GeneratorStmtsContext       => visitor.visitGeneratorStmts(ctx)
      case ctx: GeneratorStmtContext        => visitor.visitGeneratorStmt(ctx)
      case ctx: GeneratorConditionalContext =>
        visitor.visitGeneratorConditional(ctx)
      case ctx: WhileExprContext => visitor.visitWhileExpr(ctx)
      //
      case ctx: FnExprContext => visitor.visitFnExpr(ctx)
      //
      case ctx: SimpleExprContext => visitor.visitSimpleExpr(ctx)
      //
      case ctx: ArgsContext                => visitor.visitArgs(ctx)
      case ctx: GroupContext               => visitor.visitGroup(ctx)
      case ctx: AnyCollectionContext       => visitor.visitAnyCollection(ctx)
      case ctx: CollectionContext          => visitor.visitCollection(ctx)
      case ctx: NamedCollectionContext     => visitor.visitNamedCollection(ctx)
      case ctx: SomeNamedCollectionContext =>
        visitor.visitSomeNamedCollection(ctx)
      //
      case ctx: TupleArgsContext => visitor.visitTupleArgs(ctx)
      case ctx: ArrayArgsContext => visitor.visitArrayArgs(ctx)
      case ctx: SetArgsContext   => visitor.visitSetArgs(ctx)
      //
      case ctx: TupleGroupContext => visitor.visitTupleGroup(ctx)
      case ctx: ArrayGroupContext => visitor.visitArrayGroup(ctx)
      case ctx: SetGroupContext   => visitor.visitSetGroup(ctx)
      //
      case ctx: TupleExprContext          => visitor.visitTupleExpr(ctx)
      case ctx: ArrayExprContext          => visitor.visitArrayExpr(ctx)
      case ctx: SetExprContext            => visitor.visitSetExpr(ctx)
      case ctx: NamedTupleExprContext     => visitor.visitNamedTupleExpr(ctx)
      case ctx: NamedArrayExprContext     => visitor.visitNamedArrayExpr(ctx)
      case ctx: NamedSetExprContext       => visitor.visitNamedSetExpr(ctx)
      case ctx: SomeNamedTupleExprContext =>
        visitor.visitSomeNamedTupleExpr(ctx)
      case ctx: SomeNamedArrayExprContext =>
        visitor.visitSomeNamedArrayExpr(ctx)
      case ctx: SomeNamedSetExprContext => visitor.visitSomeNamedSetExpr(ctx)
      //
      case ctx: CollectionItemsContext      => visitor.visitCollectionItems(ctx)
      case ctx: NamedCollectionItemsContext =>
        visitor.visitNamedCollectionItems(ctx)
      case ctx: SomeNamedCollectionItemsContext =>
        visitor.visitSomeNamedCollectionItems(ctx)
      //
      case ctx: TextBlockContext => visitor.visitTextBlock(ctx)
      case ctx: TextWordContext  => visitor.visitTextWord(ctx)
      //
      case ctx: DecimalContext     => visitor.visitDecimal(ctx)
      case ctx: IntegerContext     => visitor.visitInteger(ctx)
      case ctx: NumberBlockContext => visitor.visitNumberBlock(ctx)
      case ctx: NumberWordContext  => visitor.visitNumberWord(ctx)
      //
      case ctx: IdContext      => visitor.visitId(ctx)
      case ctx: PlainIdContext => visitor.visitPlainId(ctx)
      case ctx: IdWordContext  => visitor.visitIdWord(ctx)
      case ctx: IdBlockContext => visitor.visitIdBlock(ctx)
      //
      case ctx: RawBlockContext  => visitor.visitRawBlock(ctx)
      case ctx: StmtBlockContext => visitor.visitStmtBlock(ctx)
      case ctx: IdHeadContext    => visitor.visitIdHead(ctx)
      case ctx: WordContext      => visitor.visitWord(ctx)
      case ctx: SlContext        => visitor.visitSl(ctx)
      case ctx: NlContext        => visitor.visitNl(ctx)
      case ctx: WsContext        => visitor.visitWs(ctx)
      case ctx: SswsContext      => visitor.visitSsws(ctx)
    end match
  end toAst

end MyParser
