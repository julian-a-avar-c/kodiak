// Generated from ../../../../kodiak/antlr/grammars/Kodiak.g4 by ANTLR 4.13.2
package kodiak.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Kodiak}.
 */
public interface KodiakListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Kodiak#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Kodiak.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Kodiak.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Kodiak.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Kodiak.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(Kodiak.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(Kodiak.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Kodiak.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Kodiak.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#valDecl}.
	 * @param ctx the parse tree
	 */
	void enterValDecl(Kodiak.ValDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#valDecl}.
	 * @param ctx the parse tree
	 */
	void exitValDecl(Kodiak.ValDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(Kodiak.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(Kodiak.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmt(Kodiak.SetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmt(Kodiak.SetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#letDecl}.
	 * @param ctx the parse tree
	 */
	void enterLetDecl(Kodiak.LetDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#letDecl}.
	 * @param ctx the parse tree
	 */
	void exitLetDecl(Kodiak.LetDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(Kodiak.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(Kodiak.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(Kodiak.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(Kodiak.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(Kodiak.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(Kodiak.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(Kodiak.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(Kodiak.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Kodiak.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Kodiak.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#matchStmt}.
	 * @param ctx the parse tree
	 */
	void enterMatchStmt(Kodiak.MatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#matchStmt}.
	 * @param ctx the parse tree
	 */
	void exitMatchStmt(Kodiak.MatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#matchCase}.
	 * @param ctx the parse tree
	 */
	void enterMatchCase(Kodiak.MatchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#matchCase}.
	 * @param ctx the parse tree
	 */
	void exitMatchCase(Kodiak.MatchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(Kodiak.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(Kodiak.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#forYield}.
	 * @param ctx the parse tree
	 */
	void enterForYield(Kodiak.ForYieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#forYield}.
	 * @param ctx the parse tree
	 */
	void exitForYield(Kodiak.ForYieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#tryStmt}.
	 * @param ctx the parse tree
	 */
	void enterTryStmt(Kodiak.TryStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#tryStmt}.
	 * @param ctx the parse tree
	 */
	void exitTryStmt(Kodiak.TryStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(Kodiak.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(Kodiak.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(Kodiak.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(Kodiak.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#literalPattern}.
	 * @param ctx the parse tree
	 */
	void enterLiteralPattern(Kodiak.LiteralPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#literalPattern}.
	 * @param ctx the parse tree
	 */
	void exitLiteralPattern(Kodiak.LiteralPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#typePattern}.
	 * @param ctx the parse tree
	 */
	void enterTypePattern(Kodiak.TypePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#typePattern}.
	 * @param ctx the parse tree
	 */
	void exitTypePattern(Kodiak.TypePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#destructurePattern}.
	 * @param ctx the parse tree
	 */
	void enterDestructurePattern(Kodiak.DestructurePatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#destructurePattern}.
	 * @param ctx the parse tree
	 */
	void exitDestructurePattern(Kodiak.DestructurePatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#plexPattern}.
	 * @param ctx the parse tree
	 */
	void enterPlexPattern(Kodiak.PlexPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#plexPattern}.
	 * @param ctx the parse tree
	 */
	void exitPlexPattern(Kodiak.PlexPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#guardPattern}.
	 * @param ctx the parse tree
	 */
	void enterGuardPattern(Kodiak.GuardPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#guardPattern}.
	 * @param ctx the parse tree
	 */
	void exitGuardPattern(Kodiak.GuardPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#wildcardPattern}.
	 * @param ctx the parse tree
	 */
	void enterWildcardPattern(Kodiak.WildcardPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#wildcardPattern}.
	 * @param ctx the parse tree
	 */
	void exitWildcardPattern(Kodiak.WildcardPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Kodiak.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Kodiak.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(Kodiak.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(Kodiak.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#matchExpr}.
	 * @param ctx the parse tree
	 */
	void enterMatchExpr(Kodiak.MatchExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#matchExpr}.
	 * @param ctx the parse tree
	 */
	void exitMatchExpr(Kodiak.MatchExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#forExpr}.
	 * @param ctx the parse tree
	 */
	void enterForExpr(Kodiak.ForExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#forExpr}.
	 * @param ctx the parse tree
	 */
	void exitForExpr(Kodiak.ForExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#forYieldExpr}.
	 * @param ctx the parse tree
	 */
	void enterForYieldExpr(Kodiak.ForYieldExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#forYieldExpr}.
	 * @param ctx the parse tree
	 */
	void exitForYieldExpr(Kodiak.ForYieldExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(Kodiak.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(Kodiak.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(Kodiak.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(Kodiak.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(Kodiak.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(Kodiak.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Kodiak.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Kodiak.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(Kodiak.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(Kodiak.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(Kodiak.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(Kodiak.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Kodiak.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Kodiak.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(Kodiak.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(Kodiak.BasicTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#collectionType}.
	 * @param ctx the parse tree
	 */
	void enterCollectionType(Kodiak.CollectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#collectionType}.
	 * @param ctx the parse tree
	 */
	void exitCollectionType(Kodiak.CollectionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#tupleType}.
	 * @param ctx the parse tree
	 */
	void enterTupleType(Kodiak.TupleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#tupleType}.
	 * @param ctx the parse tree
	 */
	void exitTupleType(Kodiak.TupleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(Kodiak.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(Kodiak.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#plexType}.
	 * @param ctx the parse tree
	 */
	void enterPlexType(Kodiak.PlexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#plexType}.
	 * @param ctx the parse tree
	 */
	void exitPlexType(Kodiak.PlexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#plexDecl}.
	 * @param ctx the parse tree
	 */
	void enterPlexDecl(Kodiak.PlexDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#plexDecl}.
	 * @param ctx the parse tree
	 */
	void exitPlexDecl(Kodiak.PlexDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#plexBody}.
	 * @param ctx the parse tree
	 */
	void enterPlexBody(Kodiak.PlexBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#plexBody}.
	 * @param ctx the parse tree
	 */
	void exitPlexBody(Kodiak.PlexBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#field}.
	 * @param ctx the parse tree
	 */
	void enterField(Kodiak.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#field}.
	 * @param ctx the parse tree
	 */
	void exitField(Kodiak.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(Kodiak.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(Kodiak.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#extensionDecl}.
	 * @param ctx the parse tree
	 */
	void enterExtensionDecl(Kodiak.ExtensionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#extensionDecl}.
	 * @param ctx the parse tree
	 */
	void exitExtensionDecl(Kodiak.ExtensionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Kodiak.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Kodiak.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#collection}.
	 * @param ctx the parse tree
	 */
	void enterCollection(Kodiak.CollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#collection}.
	 * @param ctx the parse tree
	 */
	void exitCollection(Kodiak.CollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(Kodiak.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(Kodiak.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(Kodiak.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(Kodiak.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(Kodiak.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(Kodiak.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(Kodiak.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(Kodiak.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#mapEntry}.
	 * @param ctx the parse tree
	 */
	void enterMapEntry(Kodiak.MapEntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#mapEntry}.
	 * @param ctx the parse tree
	 */
	void exitMapEntry(Kodiak.MapEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Kodiak#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Kodiak.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Kodiak#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Kodiak.IdentifierContext ctx);
}