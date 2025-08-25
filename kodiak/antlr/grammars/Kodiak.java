// Generated from ../../../../kodiak/antlr/grammars/Kodiak.g4 by ANTLR 4.13.2
package kodiak.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Kodiak extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAL_DEF=1, VAR_DEF=2, SET=3, LET=4, FN=5, IF=6, THEN=7, ELSE=8, WHILE=9, 
		DO=10, FOR=11, TO=12, DOWNTO=13, STEP=14, YIELD=15, MATCH=16, WITH=17, 
		PLEX=18, END=19, EXTENSION=20, PRIVATE=21, PUBLIC=22, TRY=23, CATCH=24, 
		THROWS=25, THIS=26, TRUE=27, FALSE=28, UNIT=29, INT=30, INT8=31, INT16=32, 
		INT64=33, DEC=34, DEC32=35, DEC64=36, BOOL=37, TEXT=38, SEQ=39, TUPLE=40, 
		MAP=41, PLUS=42, MINUS=43, MULTIPLY=44, DIVIDE=45, MODULO=46, ASSIGN=47, 
		EQUALS=48, NOT_EQUALS=49, LESS_THAN=50, LESS_EQUAL=51, GREATER_THAN=52, 
		GREATER_EQUAL=53, REFERENCE_EQUALS=54, AND=55, OR=56, NOT=57, BITWISE_AND=58, 
		BITWISE_OR=59, BITWISE_XOR=60, BITWISE_NOT=61, LEFT_SHIFT=62, RIGHT_SHIFT=63, 
		ARROW=64, TYPE_ARROW=65, QUESTION=66, PLUS_ASSIGN=67, MINUS_ASSIGN=68, 
		MULTIPLY_ASSIGN=69, DIVIDE_ASSIGN=70, LPAREN=71, RPAREN=72, LBRACKET=73, 
		RBRACKET=74, LBRACE=75, RBRACE=76, COMMA=77, SEMICOLON=78, COLON=79, DOT=80, 
		HASH=81, BACKTICK=82, DOUBLE_QUOTE=83, UNDERSCORE=84, ELLIPSIS=85, INTERPOLATION_START=86, 
		INTEGER=87, DECIMAL=88, SCIENTIFIC=89, HEX_LITERAL=90, BIN_LITERAL=91, 
		OCT_LITERAL=92, STRING=93, RAW_STRING=94, INTERPOLATED_STRING=95, PLAIN_ID=96, 
		RAW_ID=97, RAW_NUMBER=98, RAW_TEXT=99, SINGLE_LINE_COMMENT=100, MULTI_LINE_COMMENT=101, 
		WS=102, NL=103;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_exprStmt = 2, RULE_block = 3, 
		RULE_valDecl = 4, RULE_varDecl = 5, RULE_setStmt = 6, RULE_letDecl = 7, 
		RULE_functionDecl = 8, RULE_parameters = 9, RULE_parameter = 10, RULE_whileLoop = 11, 
		RULE_ifStmt = 12, RULE_matchStmt = 13, RULE_matchCase = 14, RULE_forLoop = 15, 
		RULE_forYield = 16, RULE_tryStmt = 17, RULE_catchClause = 18, RULE_pattern = 19, 
		RULE_literalPattern = 20, RULE_typePattern = 21, RULE_destructurePattern = 22, 
		RULE_plexPattern = 23, RULE_guardPattern = 24, RULE_wildcardPattern = 25, 
		RULE_expr = 26, RULE_ifExpr = 27, RULE_matchExpr = 28, RULE_forExpr = 29, 
		RULE_forYieldExpr = 30, RULE_binaryExpr = 31, RULE_unaryExpr = 32, RULE_postfixExpr = 33, 
		RULE_primary = 34, RULE_arguments = 35, RULE_operator = 36, RULE_type = 37, 
		RULE_basicType = 38, RULE_collectionType = 39, RULE_tupleType = 40, RULE_functionType = 41, 
		RULE_plexType = 42, RULE_plexDecl = 43, RULE_plexBody = 44, RULE_field = 45, 
		RULE_method = 46, RULE_extensionDecl = 47, RULE_literal = 48, RULE_collection = 49, 
		RULE_tuple = 50, RULE_sequence = 51, RULE_set = 52, RULE_map = 53, RULE_mapEntry = 54, 
		RULE_identifier = 55;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "exprStmt", "block", "valDecl", "varDecl", "setStmt", 
			"letDecl", "functionDecl", "parameters", "parameter", "whileLoop", "ifStmt", 
			"matchStmt", "matchCase", "forLoop", "forYield", "tryStmt", "catchClause", 
			"pattern", "literalPattern", "typePattern", "destructurePattern", "plexPattern", 
			"guardPattern", "wildcardPattern", "expr", "ifExpr", "matchExpr", "forExpr", 
			"forYieldExpr", "binaryExpr", "unaryExpr", "postfixExpr", "primary", 
			"arguments", "operator", "type", "basicType", "collectionType", "tupleType", 
			"functionType", "plexType", "plexDecl", "plexBody", "field", "method", 
			"extensionDecl", "literal", "collection", "tuple", "sequence", "set", 
			"map", "mapEntry", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'val'", "'var'", "'set'", "'let'", "'fn'", "'if'", "'then'", "'else'", 
			"'while'", "'do'", "'for'", "'to'", "'downto'", "'step'", "'yield'", 
			"'match'", "'with'", "'plex'", "'end'", "'extension'", "'private'", "'public'", 
			"'try'", "'catch'", "'throws'", "'this'", "'true'", "'false'", "'unit'", 
			"'int'", "'int8'", "'int16'", "'int64'", "'dec'", "'dec32'", "'dec64'", 
			"'bool'", "'text'", "'seq'", "'tuple'", "'map'", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'==='", 
			"'&&'", "'||'", "'!'", "'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'=>'", 
			"'->'", "'?'", "'+='", "'-='", "'*='", "'/='", "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "','", "';'", "':'", "'.'", "'#'", "'`'", "'\"'", "'_'", 
			"'..'", "'${'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAL_DEF", "VAR_DEF", "SET", "LET", "FN", "IF", "THEN", "ELSE", 
			"WHILE", "DO", "FOR", "TO", "DOWNTO", "STEP", "YIELD", "MATCH", "WITH", 
			"PLEX", "END", "EXTENSION", "PRIVATE", "PUBLIC", "TRY", "CATCH", "THROWS", 
			"THIS", "TRUE", "FALSE", "UNIT", "INT", "INT8", "INT16", "INT64", "DEC", 
			"DEC32", "DEC64", "BOOL", "TEXT", "SEQ", "TUPLE", "MAP", "PLUS", "MINUS", 
			"MULTIPLY", "DIVIDE", "MODULO", "ASSIGN", "EQUALS", "NOT_EQUALS", "LESS_THAN", 
			"LESS_EQUAL", "GREATER_THAN", "GREATER_EQUAL", "REFERENCE_EQUALS", "AND", 
			"OR", "NOT", "BITWISE_AND", "BITWISE_OR", "BITWISE_XOR", "BITWISE_NOT", 
			"LEFT_SHIFT", "RIGHT_SHIFT", "ARROW", "TYPE_ARROW", "QUESTION", "PLUS_ASSIGN", 
			"MINUS_ASSIGN", "MULTIPLY_ASSIGN", "DIVIDE_ASSIGN", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "COMMA", "SEMICOLON", "COLON", 
			"DOT", "HASH", "BACKTICK", "DOUBLE_QUOTE", "UNDERSCORE", "ELLIPSIS", 
			"INTERPOLATION_START", "INTEGER", "DECIMAL", "SCIENTIFIC", "HEX_LITERAL", 
			"BIN_LITERAL", "OCT_LITERAL", "STRING", "RAW_STRING", "INTERPOLATED_STRING", 
			"PLAIN_ID", "RAW_ID", "RAW_NUMBER", "RAW_TEXT", "SINGLE_LINE_COMMENT", 
			"MULTI_LINE_COMMENT", "WS", "NL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Kodiak.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Kodiak(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Kodiak.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392445483646L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
				{
				{
				setState(112);
				statement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ValDeclContext valDecl() {
			return getRuleContext(ValDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public SetStmtContext setStmt() {
			return getRuleContext(SetStmtContext.class,0);
		}
		public LetDeclContext letDecl() {
			return getRuleContext(LetDeclContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public MatchStmtContext matchStmt() {
			return getRuleContext(MatchStmtContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public ForYieldContext forYield() {
			return getRuleContext(ForYieldContext.class,0);
		}
		public PlexDeclContext plexDecl() {
			return getRuleContext(PlexDeclContext.class,0);
		}
		public ExtensionDeclContext extensionDecl() {
			return getRuleContext(ExtensionDeclContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public TryStmtContext tryStmt() {
			return getRuleContext(TryStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				valDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				varDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				setStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				letDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				whileLoop();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				ifStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(126);
				matchStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				forLoop();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(128);
				forYield();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(129);
				plexDecl();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(130);
				extensionDecl();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(131);
				functionDecl();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(132);
				tryStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(133);
				exprStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitExprStmt(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Kodiak.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Kodiak.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LBRACE);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392445483646L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
				{
				{
				setState(139);
				statement();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValDeclContext extends ParserRuleContext {
		public TerminalNode VAL_DEF() { return getToken(Kodiak.VAL_DEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ValDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterValDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitValDecl(this);
		}
	}

	public final ValDeclContext valDecl() throws RecognitionException {
		ValDeclContext _localctx = new ValDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(VAL_DEF);
			setState(148);
			identifier();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(149);
				match(COLON);
				setState(150);
				type();
				}
			}

			setState(153);
			match(ASSIGN);
			setState(154);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR_DEF() { return getToken(Kodiak.VAR_DEF, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitVarDecl(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(VAR_DEF);
			setState(157);
			identifier();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(158);
				match(COLON);
				setState(159);
				type();
				}
			}

			setState(162);
			match(ASSIGN);
			setState(163);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetStmtContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(Kodiak.SET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public TerminalNode PLUS_ASSIGN() { return getToken(Kodiak.PLUS_ASSIGN, 0); }
		public TerminalNode MINUS_ASSIGN() { return getToken(Kodiak.MINUS_ASSIGN, 0); }
		public TerminalNode MULTIPLY_ASSIGN() { return getToken(Kodiak.MULTIPLY_ASSIGN, 0); }
		public TerminalNode DIVIDE_ASSIGN() { return getToken(Kodiak.DIVIDE_ASSIGN, 0); }
		public SetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterSetStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitSetStmt(this);
		}
	}

	public final SetStmtContext setStmt() throws RecognitionException {
		SetStmtContext _localctx = new SetStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_setStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(SET);
			setState(166);
			identifier();
			setState(167);
			_la = _input.LA(1);
			if ( !(((((_la - 47)) & ~0x3f) == 0 && ((1L << (_la - 47)) & 15728641L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(168);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetDeclContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(Kodiak.LET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterLetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitLetDecl(this);
		}
	}

	public final LetDeclContext letDecl() throws RecognitionException {
		LetDeclContext _localctx = new LetDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_letDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(LET);
			setState(171);
			identifier();
			setState(172);
			match(ASSIGN);
			setState(173);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(Kodiak.FN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public TerminalNode ARROW() { return getToken(Kodiak.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(FN);
			setState(176);
			identifier();
			setState(177);
			match(LPAREN);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLAIN_ID || _la==RAW_ID) {
				{
				setState(178);
				parameters();
				}
			}

			setState(181);
			match(RPAREN);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(182);
				match(COLON);
				setState(183);
				type();
				}
			}

			setState(186);
			match(ARROW);
			setState(187);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			parameter();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(190);
				match(COMMA);
				setState(191);
				parameter();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			identifier();
			setState(198);
			match(COLON);
			setState(199);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Kodiak.WHILE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DO() { return getToken(Kodiak.DO, 0); }
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitWhileLoop(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(WHILE);
			setState(202);
			expr();
			setState(203);
			match(DO);
			setState(204);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Kodiak.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(Kodiak.THEN, 0); }
		public TerminalNode ELSE() { return getToken(Kodiak.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(IF);
			setState(207);
			expr();
			setState(208);
			match(THEN);
			setState(209);
			expr();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(210);
				match(ELSE);
				setState(211);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchStmtContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(Kodiak.MATCH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Kodiak.ELSE, 0); }
		public MatchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMatchStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMatchStmt(this);
		}
	}

	public final MatchStmtContext matchStmt() throws RecognitionException {
		MatchStmtContext _localctx = new MatchStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_matchStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(MATCH);
			setState(215);
			expr();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(216);
				matchCase();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(222);
				match(ELSE);
				setState(223);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchCaseContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(Kodiak.WITH, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode THEN() { return getToken(Kodiak.THEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public MatchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMatchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMatchCase(this);
		}
	}

	public final MatchCaseContext matchCase() throws RecognitionException {
		MatchCaseContext _localctx = new MatchCaseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_matchCase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(WITH);
			setState(227);
			pattern();
			setState(228);
			match(THEN);
			setState(229);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Kodiak.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DO() { return getToken(Kodiak.DO, 0); }
		public TerminalNode TO() { return getToken(Kodiak.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(Kodiak.DOWNTO, 0); }
		public TerminalNode LET() { return getToken(Kodiak.LET, 0); }
		public TerminalNode STEP() { return getToken(Kodiak.STEP, 0); }
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitForLoop(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(FOR);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(232);
				match(LET);
				}
			}

			setState(235);
			identifier();
			setState(236);
			match(ASSIGN);
			setState(237);
			expr();
			setState(238);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(239);
			expr();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(240);
				match(STEP);
				setState(241);
				expr();
				}
			}

			setState(244);
			match(DO);
			setState(245);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForYieldContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Kodiak.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode YIELD() { return getToken(Kodiak.YIELD, 0); }
		public TerminalNode TO() { return getToken(Kodiak.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(Kodiak.DOWNTO, 0); }
		public TerminalNode LET() { return getToken(Kodiak.LET, 0); }
		public TerminalNode STEP() { return getToken(Kodiak.STEP, 0); }
		public ForYieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forYield; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterForYield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitForYield(this);
		}
	}

	public final ForYieldContext forYield() throws RecognitionException {
		ForYieldContext _localctx = new ForYieldContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_forYield);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(FOR);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(248);
				match(LET);
				}
			}

			setState(251);
			identifier();
			setState(252);
			match(ASSIGN);
			setState(253);
			expr();
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
			expr();
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(256);
				match(STEP);
				setState(257);
				expr();
				}
			}

			setState(260);
			match(YIELD);
			setState(261);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryStmtContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Kodiak.TRY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TerminalNode THROWS() { return getToken(Kodiak.THROWS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TryStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterTryStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitTryStmt(this);
		}
	}

	public final TryStmtContext tryStmt() throws RecognitionException {
		TryStmtContext _localctx = new TryStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tryStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(TRY);
			setState(264);
			expr();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(265);
				catchClause();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(271);
				match(THROWS);
				setState(272);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(Kodiak.CATCH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode THEN() { return getToken(Kodiak.THEN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_catchClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(CATCH);
			setState(276);
			identifier();
			setState(277);
			match(COLON);
			setState(278);
			type();
			setState(279);
			match(THEN);
			setState(280);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public LiteralPatternContext literalPattern() {
			return getRuleContext(LiteralPatternContext.class,0);
		}
		public TypePatternContext typePattern() {
			return getRuleContext(TypePatternContext.class,0);
		}
		public DestructurePatternContext destructurePattern() {
			return getRuleContext(DestructurePatternContext.class,0);
		}
		public GuardPatternContext guardPattern() {
			return getRuleContext(GuardPatternContext.class,0);
		}
		public WildcardPatternContext wildcardPattern() {
			return getRuleContext(WildcardPatternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pattern);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				literalPattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				typePattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				destructurePattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(285);
				guardPattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(286);
				wildcardPattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralPatternContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterLiteralPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitLiteralPattern(this);
		}
	}

	public final LiteralPatternContext literalPattern() throws RecognitionException {
		LiteralPatternContext _localctx = new LiteralPatternContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_literalPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypePatternContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterTypePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitTypePattern(this);
		}
	}

	public final TypePatternContext typePattern() throws RecognitionException {
		TypePatternContext _localctx = new TypePatternContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_typePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			identifier();
			setState(292);
			match(COLON);
			setState(293);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DestructurePatternContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Kodiak.LBRACKET, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(Kodiak.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public TerminalNode ELLIPSIS() { return getToken(Kodiak.ELLIPSIS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public PlexPatternContext plexPattern() {
			return getRuleContext(PlexPatternContext.class,0);
		}
		public DestructurePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_destructurePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterDestructurePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitDestructurePattern(this);
		}
	}

	public final DestructurePatternContext destructurePattern() throws RecognitionException {
		DestructurePatternContext _localctx = new DestructurePatternContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_destructurePattern);
		int _la;
		try {
			int _alt;
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				match(LBRACKET);
				setState(296);
				pattern();
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(297);
						match(COMMA);
						setState(298);
						pattern();
						}
						} 
					}
					setState(303);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(304);
					match(COMMA);
					setState(305);
					match(ELLIPSIS);
					setState(306);
					identifier();
					}
				}

				setState(309);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(LBRACKET);
				setState(312);
				identifier();
				setState(313);
				match(COMMA);
				setState(314);
				match(ELLIPSIS);
				setState(315);
				identifier();
				setState(316);
				match(RBRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
				plexPattern();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlexPatternContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(Kodiak.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Kodiak.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public PlexPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plexPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPlexPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPlexPattern(this);
		}
	}

	public final PlexPatternContext plexPattern() throws RecognitionException {
		PlexPatternContext _localctx = new PlexPatternContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_plexPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			identifier();
			setState(322);
			match(LBRACE);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PLAIN_ID || _la==RAW_ID) {
				{
				setState(323);
				identifier();
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(324);
					match(COMMA);
					setState(325);
					identifier();
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(333);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardPatternContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode GREATER_EQUAL() { return getToken(Kodiak.GREATER_EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode UNDERSCORE() { return getToken(Kodiak.UNDERSCORE, 0); }
		public GuardPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterGuardPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitGuardPattern(this);
		}
	}

	public final GuardPatternContext guardPattern() throws RecognitionException {
		GuardPatternContext _localctx = new GuardPatternContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_guardPattern);
		try {
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAIN_ID:
			case RAW_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				identifier();
				setState(336);
				match(GREATER_EQUAL);
				setState(337);
				expr();
				}
				break;
			case UNDERSCORE:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(UNDERSCORE);
				setState(340);
				match(GREATER_EQUAL);
				setState(341);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WildcardPatternContext extends ParserRuleContext {
		public TerminalNode UNDERSCORE() { return getToken(Kodiak.UNDERSCORE, 0); }
		public WildcardPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterWildcardPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitWildcardPattern(this);
		}
	}

	public final WildcardPatternContext wildcardPattern() throws RecognitionException {
		WildcardPatternContext _localctx = new WildcardPatternContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_wildcardPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(UNDERSCORE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public MatchExprContext matchExpr() {
			return getRuleContext(MatchExprContext.class,0);
		}
		public ForExprContext forExpr() {
			return getRuleContext(ForExprContext.class,0);
		}
		public ForYieldExprContext forYieldExpr() {
			return getRuleContext(ForYieldExprContext.class,0);
		}
		public BinaryExprContext binaryExpr() {
			return getRuleContext(BinaryExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				ifExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				matchExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				forExpr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(349);
				forYieldExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(350);
				binaryExpr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Kodiak.IF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode THEN() { return getToken(Kodiak.THEN, 0); }
		public TerminalNode ELSE() { return getToken(Kodiak.ELSE, 0); }
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitIfExpr(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(IF);
			setState(354);
			expr();
			setState(355);
			match(THEN);
			setState(356);
			expr();
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(357);
				match(ELSE);
				setState(358);
				expr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchExprContext extends ParserRuleContext {
		public TerminalNode MATCH() { return getToken(Kodiak.MATCH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<MatchCaseContext> matchCase() {
			return getRuleContexts(MatchCaseContext.class);
		}
		public MatchCaseContext matchCase(int i) {
			return getRuleContext(MatchCaseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Kodiak.ELSE, 0); }
		public MatchExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMatchExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMatchExpr(this);
		}
	}

	public final MatchExprContext matchExpr() throws RecognitionException {
		MatchExprContext _localctx = new MatchExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_matchExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(MATCH);
			setState(362);
			expr();
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(363);
					matchCase();
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(369);
				match(ELSE);
				setState(370);
				expr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForExprContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Kodiak.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DO() { return getToken(Kodiak.DO, 0); }
		public TerminalNode TO() { return getToken(Kodiak.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(Kodiak.DOWNTO, 0); }
		public TerminalNode LET() { return getToken(Kodiak.LET, 0); }
		public TerminalNode STEP() { return getToken(Kodiak.STEP, 0); }
		public ForExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterForExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitForExpr(this);
		}
	}

	public final ForExprContext forExpr() throws RecognitionException {
		ForExprContext _localctx = new ForExprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_forExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(FOR);
			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(374);
				match(LET);
				}
			}

			setState(377);
			identifier();
			setState(378);
			match(ASSIGN);
			setState(379);
			expr();
			setState(380);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(381);
			expr();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(382);
				match(STEP);
				setState(383);
				expr();
				}
			}

			setState(386);
			match(DO);
			setState(387);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForYieldExprContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Kodiak.FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode YIELD() { return getToken(Kodiak.YIELD, 0); }
		public TerminalNode TO() { return getToken(Kodiak.TO, 0); }
		public TerminalNode DOWNTO() { return getToken(Kodiak.DOWNTO, 0); }
		public TerminalNode LET() { return getToken(Kodiak.LET, 0); }
		public TerminalNode STEP() { return getToken(Kodiak.STEP, 0); }
		public ForYieldExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forYieldExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterForYieldExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitForYieldExpr(this);
		}
	}

	public final ForYieldExprContext forYieldExpr() throws RecognitionException {
		ForYieldExprContext _localctx = new ForYieldExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_forYieldExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(FOR);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(390);
				match(LET);
				}
			}

			setState(393);
			identifier();
			setState(394);
			match(ASSIGN);
			setState(395);
			expr();
			setState(396);
			_la = _input.LA(1);
			if ( !(_la==TO || _la==DOWNTO) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(397);
			expr();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(398);
				match(STEP);
				setState(399);
				expr();
				}
			}

			setState(402);
			match(YIELD);
			setState(403);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public List<BinaryExprContext> binaryExpr() {
			return getRuleContexts(BinaryExprContext.class);
		}
		public BinaryExprContext binaryExpr(int i) {
			return getRuleContext(BinaryExprContext.class,i);
		}
		public TerminalNode MULTIPLY() { return getToken(Kodiak.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(Kodiak.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(Kodiak.MODULO, 0); }
		public TerminalNode PLUS() { return getToken(Kodiak.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Kodiak.MINUS, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(Kodiak.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(Kodiak.RIGHT_SHIFT, 0); }
		public TerminalNode LESS_THAN() { return getToken(Kodiak.LESS_THAN, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(Kodiak.LESS_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(Kodiak.GREATER_THAN, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(Kodiak.GREATER_EQUAL, 0); }
		public TerminalNode EQUALS() { return getToken(Kodiak.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(Kodiak.NOT_EQUALS, 0); }
		public TerminalNode REFERENCE_EQUALS() { return getToken(Kodiak.REFERENCE_EQUALS, 0); }
		public TerminalNode BITWISE_AND() { return getToken(Kodiak.BITWISE_AND, 0); }
		public TerminalNode BITWISE_XOR() { return getToken(Kodiak.BITWISE_XOR, 0); }
		public TerminalNode BITWISE_OR() { return getToken(Kodiak.BITWISE_OR, 0); }
		public TerminalNode AND() { return getToken(Kodiak.AND, 0); }
		public TerminalNode OR() { return getToken(Kodiak.OR, 0); }
		public BinaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitBinaryExpr(this);
		}
	}

	public final BinaryExprContext binaryExpr() throws RecognitionException {
		return binaryExpr(0);
	}

	private BinaryExprContext binaryExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BinaryExprContext _localctx = new BinaryExprContext(_ctx, _parentState);
		BinaryExprContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_binaryExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(406);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(465);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(408);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(409);
						match(MULTIPLY);
						setState(410);
						binaryExpr(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(411);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(412);
						match(DIVIDE);
						setState(413);
						binaryExpr(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(414);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(415);
						match(MODULO);
						setState(416);
						binaryExpr(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(417);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(418);
						match(PLUS);
						setState(419);
						binaryExpr(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(420);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(421);
						match(MINUS);
						setState(422);
						binaryExpr(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(423);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(424);
						match(LEFT_SHIFT);
						setState(425);
						binaryExpr(15);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(426);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(427);
						match(RIGHT_SHIFT);
						setState(428);
						binaryExpr(14);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(429);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(430);
						match(LESS_THAN);
						setState(431);
						binaryExpr(13);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(432);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(433);
						match(LESS_EQUAL);
						setState(434);
						binaryExpr(12);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(435);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(436);
						match(GREATER_THAN);
						setState(437);
						binaryExpr(11);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(438);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(439);
						match(GREATER_EQUAL);
						setState(440);
						binaryExpr(10);
						}
						break;
					case 12:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(441);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(442);
						match(EQUALS);
						setState(443);
						binaryExpr(9);
						}
						break;
					case 13:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(444);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(445);
						match(NOT_EQUALS);
						setState(446);
						binaryExpr(8);
						}
						break;
					case 14:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(447);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(448);
						match(REFERENCE_EQUALS);
						setState(449);
						binaryExpr(7);
						}
						break;
					case 15:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(450);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(451);
						match(BITWISE_AND);
						setState(452);
						binaryExpr(6);
						}
						break;
					case 16:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(453);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(454);
						match(BITWISE_XOR);
						setState(455);
						binaryExpr(5);
						}
						break;
					case 17:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(456);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(457);
						match(BITWISE_OR);
						setState(458);
						binaryExpr(4);
						}
						break;
					case 18:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(459);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(460);
						match(AND);
						setState(461);
						binaryExpr(3);
						}
						break;
					case 19:
						{
						_localctx = new BinaryExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binaryExpr);
						setState(462);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(463);
						match(OR);
						setState(464);
						binaryExpr(2);
						}
						break;
					}
					} 
				}
				setState(469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExprContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(Kodiak.NOT, 0); }
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(Kodiak.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(Kodiak.PLUS, 0); }
		public TerminalNode BITWISE_NOT() { return getToken(Kodiak.BITWISE_NOT, 0); }
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_unaryExpr);
		try {
			setState(479);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(NOT);
				setState(471);
				unaryExpr();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(472);
				match(MINUS);
				setState(473);
				unaryExpr();
				}
				break;
			case PLUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(474);
				match(PLUS);
				setState(475);
				unaryExpr();
				}
				break;
			case BITWISE_NOT:
				enterOuterAlt(_localctx, 4);
				{
				setState(476);
				match(BITWISE_NOT);
				setState(477);
				unaryExpr();
				}
				break;
			case THIS:
			case TRUE:
			case FALSE:
			case UNIT:
			case LPAREN:
			case LBRACKET:
			case LBRACE:
			case INTEGER:
			case DECIMAL:
			case SCIENTIFIC:
			case HEX_LITERAL:
			case BIN_LITERAL:
			case OCT_LITERAL:
			case STRING:
			case RAW_STRING:
			case INTERPOLATED_STRING:
			case PLAIN_ID:
			case RAW_ID:
			case RAW_NUMBER:
			case RAW_TEXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(478);
				postfixExpr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixExprContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Kodiak.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(Kodiak.INTEGER, 0); }
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPostfixExpr(this);
		}
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		return postfixExpr(0);
	}

	private PostfixExprContext postfixExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, _parentState);
		PostfixExprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_postfixExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(482);
			primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(498);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(496);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpr);
						setState(484);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(485);
						match(DOT);
						setState(486);
						identifier();
						}
						break;
					case 2:
						{
						_localctx = new PostfixExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpr);
						setState(487);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(488);
						match(DOT);
						setState(489);
						match(INTEGER);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpr);
						setState(490);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(491);
						match(LPAREN);
						setState(493);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392435783744L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
							{
							setState(492);
							arguments();
							}
						}

						setState(495);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(500);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode THIS() { return getToken(Kodiak.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_primary);
		try {
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(502);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(503);
				match(THIS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(504);
				match(LPAREN);
				setState(505);
				expr();
				setState(506);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(508);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			expr();
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(512);
				match(COMMA);
				setState(513);
				expr();
				}
				}
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode MULTIPLY() { return getToken(Kodiak.MULTIPLY, 0); }
		public TerminalNode DIVIDE() { return getToken(Kodiak.DIVIDE, 0); }
		public TerminalNode MODULO() { return getToken(Kodiak.MODULO, 0); }
		public TerminalNode PLUS() { return getToken(Kodiak.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Kodiak.MINUS, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(Kodiak.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(Kodiak.RIGHT_SHIFT, 0); }
		public TerminalNode LESS_THAN() { return getToken(Kodiak.LESS_THAN, 0); }
		public TerminalNode LESS_EQUAL() { return getToken(Kodiak.LESS_EQUAL, 0); }
		public TerminalNode GREATER_THAN() { return getToken(Kodiak.GREATER_THAN, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(Kodiak.GREATER_EQUAL, 0); }
		public TerminalNode EQUALS() { return getToken(Kodiak.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(Kodiak.NOT_EQUALS, 0); }
		public TerminalNode REFERENCE_EQUALS() { return getToken(Kodiak.REFERENCE_EQUALS, 0); }
		public TerminalNode BITWISE_AND() { return getToken(Kodiak.BITWISE_AND, 0); }
		public TerminalNode BITWISE_XOR() { return getToken(Kodiak.BITWISE_XOR, 0); }
		public TerminalNode BITWISE_OR() { return getToken(Kodiak.BITWISE_OR, 0); }
		public TerminalNode AND() { return getToken(Kodiak.AND, 0); }
		public TerminalNode OR() { return getToken(Kodiak.OR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -2450103332824416256L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public CollectionTypeContext collectionType() {
			return getRuleContext(CollectionTypeContext.class,0);
		}
		public TupleTypeContext tupleType() {
			return getRuleContext(TupleTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public PlexTypeContext plexType() {
			return getRuleContext(PlexTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_type);
		try {
			setState(526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(521);
				basicType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
				collectionType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				tupleType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(524);
				functionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(525);
				plexType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(Kodiak.INT, 0); }
		public TerminalNode INT8() { return getToken(Kodiak.INT8, 0); }
		public TerminalNode INT16() { return getToken(Kodiak.INT16, 0); }
		public TerminalNode INT64() { return getToken(Kodiak.INT64, 0); }
		public TerminalNode DEC() { return getToken(Kodiak.DEC, 0); }
		public TerminalNode DEC32() { return getToken(Kodiak.DEC32, 0); }
		public TerminalNode DEC64() { return getToken(Kodiak.DEC64, 0); }
		public TerminalNode BOOL() { return getToken(Kodiak.BOOL, 0); }
		public TerminalNode TEXT() { return getToken(Kodiak.TEXT, 0); }
		public TerminalNode UNIT() { return getToken(Kodiak.UNIT, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitBasicType(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 549218942976L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollectionTypeContext extends ParserRuleContext {
		public TerminalNode SEQ() { return getToken(Kodiak.SEQ, 0); }
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public TerminalNode SET() { return getToken(Kodiak.SET, 0); }
		public TerminalNode MAP() { return getToken(Kodiak.MAP, 0); }
		public TerminalNode COMMA() { return getToken(Kodiak.COMMA, 0); }
		public TerminalNode LBRACKET() { return getToken(Kodiak.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(Kodiak.RBRACKET, 0); }
		public TerminalNode LBRACE() { return getToken(Kodiak.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Kodiak.RBRACE, 0); }
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public CollectionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterCollectionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitCollectionType(this);
		}
	}

	public final CollectionTypeContext collectionType() throws RecognitionException {
		CollectionTypeContext _localctx = new CollectionTypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_collectionType);
		try {
			setState(585);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(530);
				match(SEQ);
				setState(531);
				match(LPAREN);
				setState(532);
				type();
				setState(533);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				match(SET);
				setState(536);
				match(LPAREN);
				setState(537);
				type();
				setState(538);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(540);
				match(MAP);
				setState(541);
				match(LPAREN);
				setState(542);
				type();
				setState(543);
				match(COMMA);
				setState(544);
				type();
				setState(545);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(547);
				match(LBRACKET);
				setState(548);
				type();
				setState(549);
				match(RBRACKET);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(551);
				match(LBRACE);
				setState(552);
				type();
				setState(553);
				match(RBRACE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(555);
				match(COLON);
				setState(556);
				match(LBRACKET);
				setState(557);
				type();
				setState(558);
				match(RBRACKET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(560);
				match(COLON);
				setState(561);
				match(LBRACE);
				setState(562);
				type();
				setState(563);
				match(RBRACE);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(565);
				match(COLON);
				setState(566);
				match(SEQ);
				setState(567);
				match(LPAREN);
				setState(568);
				type();
				setState(569);
				match(RPAREN);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(571);
				match(COLON);
				setState(572);
				match(SET);
				setState(573);
				match(LPAREN);
				setState(574);
				type();
				setState(575);
				match(RPAREN);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(577);
				match(COLON);
				setState(578);
				match(MAP);
				setState(579);
				match(LPAREN);
				setState(580);
				type();
				setState(581);
				match(COMMA);
				setState(582);
				type();
				setState(583);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TerminalNode TUPLE() { return getToken(Kodiak.TUPLE, 0); }
		public TupleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterTupleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitTupleType(this);
		}
	}

	public final TupleTypeContext tupleType() throws RecognitionException {
		TupleTypeContext _localctx = new TupleTypeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tupleType);
		int _la;
		try {
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(587);
				match(LPAREN);
				setState(588);
				type();
				setState(593);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(589);
					match(COMMA);
					setState(590);
					type();
					}
					}
					setState(595);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(596);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(598);
				match(COLON);
				setState(599);
				match(LPAREN);
				setState(600);
				type();
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(601);
					match(COMMA);
					setState(602);
					type();
					}
					}
					setState(607);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(608);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				match(COLON);
				setState(611);
				match(TUPLE);
				setState(612);
				match(LPAREN);
				setState(613);
				type();
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(614);
					match(COMMA);
					setState(615);
					type();
					}
					}
					setState(620);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(621);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(Kodiak.FN, 0); }
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public TerminalNode TYPE_ARROW() { return getToken(Kodiak.TYPE_ARROW, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterFunctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitFunctionType(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(FN);
			setState(626);
			match(LPAREN);
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3297998012456L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 100663573L) != 0)) {
				{
				setState(627);
				type();
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(628);
					match(COMMA);
					setState(629);
					type();
					}
					}
					setState(634);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(637);
			match(RPAREN);
			setState(638);
			match(TYPE_ARROW);
			setState(639);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlexTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public PlexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPlexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPlexType(this);
		}
	}

	public final PlexTypeContext plexType() throws RecognitionException {
		PlexTypeContext _localctx = new PlexTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_plexType);
		try {
			setState(644);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAIN_ID:
			case RAW_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(641);
				identifier();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(642);
				match(COLON);
				setState(643);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlexDeclContext extends ParserRuleContext {
		public TerminalNode PLEX() { return getToken(Kodiak.PLEX, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(Kodiak.ARROW, 0); }
		public TerminalNode END() { return getToken(Kodiak.END, 0); }
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public List<PlexBodyContext> plexBody() {
			return getRuleContexts(PlexBodyContext.class);
		}
		public PlexBodyContext plexBody(int i) {
			return getRuleContext(PlexBodyContext.class,i);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public PlexDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plexDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPlexDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPlexDecl(this);
		}
	}

	public final PlexDeclContext plexDecl() throws RecognitionException {
		PlexDeclContext _localctx = new PlexDeclContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_plexDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			match(PLEX);
			setState(647);
			identifier();
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(648);
				match(LPAREN);
				setState(650);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLAIN_ID || _la==RAW_ID) {
					{
					setState(649);
					parameters();
					}
				}

				setState(652);
				match(RPAREN);
				}
			}

			setState(655);
			match(ARROW);
			setState(659);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6291494L) != 0)) {
				{
				{
				setState(656);
				plexBody();
				}
				}
				setState(661);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(662);
			match(END);
			setState(663);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlexBodyContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public PlexBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plexBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterPlexBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitPlexBody(this);
		}
	}

	public final PlexBodyContext plexBody() throws RecognitionException {
		PlexBodyContext _localctx = new PlexBodyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_plexBody);
		try {
			setState(667);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAL_DEF:
			case VAR_DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				field();
				}
				break;
			case FN:
			case PRIVATE:
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(666);
				method();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Kodiak.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode VAL_DEF() { return getToken(Kodiak.VAL_DEF, 0); }
		public TerminalNode VAR_DEF() { return getToken(Kodiak.VAR_DEF, 0); }
		public TerminalNode PRIVATE() { return getToken(Kodiak.PRIVATE, 0); }
		public TerminalNode PUBLIC() { return getToken(Kodiak.PUBLIC, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			_la = _input.LA(1);
			if ( !(_la==VAL_DEF || _la==VAR_DEF) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIVATE || _la==PUBLIC) {
				{
				setState(670);
				_la = _input.LA(1);
				if ( !(_la==PRIVATE || _la==PUBLIC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(673);
			identifier();
			setState(674);
			match(COLON);
			setState(675);
			type();
			setState(676);
			match(ASSIGN);
			setState(677);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public TerminalNode PRIVATE() { return getToken(Kodiak.PRIVATE, 0); }
		public TerminalNode PUBLIC() { return getToken(Kodiak.PUBLIC, 0); }
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIVATE || _la==PUBLIC) {
				{
				setState(679);
				_la = _input.LA(1);
				if ( !(_la==PRIVATE || _la==PUBLIC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(682);
			functionDecl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExtensionDeclContext extends ParserRuleContext {
		public List<TerminalNode> EXTENSION() { return getTokens(Kodiak.EXTENSION); }
		public TerminalNode EXTENSION(int i) {
			return getToken(Kodiak.EXTENSION, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(Kodiak.ARROW, 0); }
		public TerminalNode END() { return getToken(Kodiak.END, 0); }
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ExtensionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extensionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterExtensionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitExtensionDecl(this);
		}
	}

	public final ExtensionDeclContext extensionDecl() throws RecognitionException {
		ExtensionDeclContext _localctx = new ExtensionDeclContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_extensionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			match(EXTENSION);
			setState(685);
			type();
			setState(686);
			match(ARROW);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6291488L) != 0)) {
				{
				{
				setState(687);
				method();
				}
				}
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(693);
			match(END);
			setState(694);
			match(EXTENSION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(Kodiak.INTEGER, 0); }
		public TerminalNode DECIMAL() { return getToken(Kodiak.DECIMAL, 0); }
		public TerminalNode SCIENTIFIC() { return getToken(Kodiak.SCIENTIFIC, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(Kodiak.HEX_LITERAL, 0); }
		public TerminalNode BIN_LITERAL() { return getToken(Kodiak.BIN_LITERAL, 0); }
		public TerminalNode OCT_LITERAL() { return getToken(Kodiak.OCT_LITERAL, 0); }
		public TerminalNode STRING() { return getToken(Kodiak.STRING, 0); }
		public TerminalNode RAW_STRING() { return getToken(Kodiak.RAW_STRING, 0); }
		public TerminalNode INTERPOLATED_STRING() { return getToken(Kodiak.INTERPOLATED_STRING, 0); }
		public TerminalNode RAW_NUMBER() { return getToken(Kodiak.RAW_NUMBER, 0); }
		public TerminalNode RAW_TEXT() { return getToken(Kodiak.RAW_TEXT, 0); }
		public TerminalNode TRUE() { return getToken(Kodiak.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(Kodiak.FALSE, 0); }
		public TerminalNode UNIT() { return getToken(Kodiak.UNIT, 0); }
		public CollectionContext collection() {
			return getRuleContext(CollectionContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_literal);
		try {
			setState(711);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(696);
				match(INTEGER);
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(697);
				match(DECIMAL);
				}
				break;
			case SCIENTIFIC:
				enterOuterAlt(_localctx, 3);
				{
				setState(698);
				match(SCIENTIFIC);
				}
				break;
			case HEX_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(699);
				match(HEX_LITERAL);
				}
				break;
			case BIN_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(700);
				match(BIN_LITERAL);
				}
				break;
			case OCT_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(701);
				match(OCT_LITERAL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 7);
				{
				setState(702);
				match(STRING);
				}
				break;
			case RAW_STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(703);
				match(RAW_STRING);
				}
				break;
			case INTERPOLATED_STRING:
				enterOuterAlt(_localctx, 9);
				{
				setState(704);
				match(INTERPOLATED_STRING);
				}
				break;
			case RAW_NUMBER:
				enterOuterAlt(_localctx, 10);
				{
				setState(705);
				match(RAW_NUMBER);
				}
				break;
			case RAW_TEXT:
				enterOuterAlt(_localctx, 11);
				{
				setState(706);
				match(RAW_TEXT);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 12);
				{
				setState(707);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 13);
				{
				setState(708);
				match(FALSE);
				}
				break;
			case UNIT:
				enterOuterAlt(_localctx, 14);
				{
				setState(709);
				match(UNIT);
				}
				break;
			case LPAREN:
			case LBRACKET:
			case LBRACE:
				enterOuterAlt(_localctx, 15);
				{
				setState(710);
				collection();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollectionContext extends ParserRuleContext {
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public MapContext map() {
			return getRuleContext(MapContext.class,0);
		}
		public CollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitCollection(this);
		}
	}

	public final CollectionContext collection() throws RecognitionException {
		CollectionContext _localctx = new CollectionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_collection);
		try {
			setState(717);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(713);
				tuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(714);
				sequence();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(715);
				set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(716);
				map();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Kodiak.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Kodiak.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitTuple(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_tuple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
			match(LPAREN);
			setState(731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392435783744L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
				{
				setState(720);
				expr();
				setState(725);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(721);
						match(COMMA);
						setState(722);
						expr();
						}
						} 
					}
					setState(727);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				}
				setState(729);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(728);
					match(COMMA);
					}
				}

				}
			}

			setState(733);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SequenceContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(Kodiak.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(Kodiak.RBRACKET, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitSequence(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_sequence);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(LBRACKET);
			setState(747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392435783744L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
				{
				setState(736);
				expr();
				setState(741);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(737);
						match(COMMA);
						setState(738);
						expr();
						}
						} 
					}
					setState(743);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				}
				setState(745);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(744);
					match(COMMA);
					}
				}

				}
			}

			setState(749);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Kodiak.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Kodiak.RBRACE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitSet(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_set);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			match(LBRACE);
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2449971392435783744L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 536805397L) != 0)) {
				{
				setState(752);
				expr();
				setState(757);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(753);
						match(COMMA);
						setState(754);
						expr();
						}
						} 
					}
					setState(759);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(760);
					match(COMMA);
					}
				}

				}
			}

			setState(765);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Kodiak.LBRACE, 0); }
		public List<MapEntryContext> mapEntry() {
			return getRuleContexts(MapEntryContext.class);
		}
		public MapEntryContext mapEntry(int i) {
			return getRuleContext(MapEntryContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(Kodiak.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Kodiak.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Kodiak.COMMA, i);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMap(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_map);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(LBRACE);
			setState(768);
			mapEntry();
			setState(773);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(769);
					match(COMMA);
					setState(770);
					mapEntry();
					}
					} 
				}
				setState(775);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			setState(777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(776);
				match(COMMA);
				}
			}

			setState(779);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MapEntryContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(Kodiak.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(Kodiak.STRING, 0); }
		public MapEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterMapEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitMapEntry(this);
		}
	}

	public final MapEntryContext mapEntry() throws RecognitionException {
		MapEntryContext _localctx = new MapEntryContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_mapEntry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAIN_ID:
			case RAW_ID:
				{
				setState(781);
				identifier();
				}
				break;
			case STRING:
				{
				setState(782);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(785);
			match(ASSIGN);
			setState(786);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode PLAIN_ID() { return getToken(Kodiak.PLAIN_ID, 0); }
		public TerminalNode RAW_ID() { return getToken(Kodiak.RAW_ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KodiakListener ) ((KodiakListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			_la = _input.LA(1);
			if ( !(_la==PLAIN_ID || _la==RAW_ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 31:
			return binaryExpr_sempred((BinaryExprContext)_localctx, predIndex);
		case 33:
			return postfixExpr_sempred((PostfixExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean binaryExpr_sempred(BinaryExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 9);
		case 11:
			return precpred(_ctx, 8);
		case 12:
			return precpred(_ctx, 7);
		case 13:
			return precpred(_ctx, 6);
		case 14:
			return precpred(_ctx, 5);
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		case 17:
			return precpred(_ctx, 2);
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpr_sempred(PostfixExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 3);
		case 20:
			return precpred(_ctx, 2);
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001g\u0317\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u0001\u0000\u0005\u0000r\b\u0000\n\u0000\f\u0000u\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0087\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005\u0003\u008d\b\u0003\n"+
		"\u0003\f\u0003\u0090\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0098\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00a1\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b"+
		"\u00b4\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b9\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0005\t\u00c1\b\t\n\t\f\t\u00c4\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d5"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00da\b\r\n\r\f\r\u00dd\t\r\u0001"+
		"\r\u0001\r\u0003\r\u00e1\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00ea\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00f3\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00fa\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0103"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u010b\b\u0011\n\u0011\f\u0011\u010e\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0112\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0120\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u012c\b\u0016\n\u0016"+
		"\f\u0016\u012f\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0134\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0140\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u0147\b\u0017\n\u0017\f\u0017\u014a\t\u0017\u0003\u0017\u014c"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0157\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0160\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0168\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0005\u001c\u016d\b\u001c\n\u001c\f\u001c\u0170\t\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0174\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u0178\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0181\b\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u0188\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u0191\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0005\u001f\u01d2\b\u001f\n\u001f\f\u001f\u01d5\t\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01e0\b \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0003!\u01ee\b!\u0001!\u0005!\u01f1\b!\n!\f!\u01f4\t!\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01fe"+
		"\b\"\u0001#\u0001#\u0001#\u0005#\u0203\b#\n#\f#\u0206\t#\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u020f\b%\u0001&\u0001&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0003\'\u024a\b\'\u0001(\u0001(\u0001(\u0001(\u0005(\u0250\b(\n(\f"+
		"(\u0253\t(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0005(\u025c"+
		"\b(\n(\f(\u025f\t(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0005(\u0269\b(\n(\f(\u026c\t(\u0001(\u0001(\u0003(\u0270\b(\u0001)"+
		"\u0001)\u0001)\u0001)\u0001)\u0005)\u0277\b)\n)\f)\u027a\t)\u0003)\u027c"+
		"\b)\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0003*\u0285\b*\u0001"+
		"+\u0001+\u0001+\u0001+\u0003+\u028b\b+\u0001+\u0003+\u028e\b+\u0001+\u0001"+
		"+\u0005+\u0292\b+\n+\f+\u0295\t+\u0001+\u0001+\u0001+\u0001,\u0001,\u0003"+
		",\u029c\b,\u0001-\u0001-\u0003-\u02a0\b-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001.\u0003.\u02a9\b.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"/\u0005/\u02b1\b/\n/\f/\u02b4\t/\u0001/\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0001"+
		"0\u00010\u00010\u00030\u02c8\b0\u00011\u00011\u00011\u00011\u00031\u02ce"+
		"\b1\u00012\u00012\u00012\u00012\u00052\u02d4\b2\n2\f2\u02d7\t2\u00012"+
		"\u00032\u02da\b2\u00032\u02dc\b2\u00012\u00012\u00013\u00013\u00013\u0001"+
		"3\u00053\u02e4\b3\n3\f3\u02e7\t3\u00013\u00033\u02ea\b3\u00033\u02ec\b"+
		"3\u00013\u00013\u00014\u00014\u00014\u00014\u00054\u02f4\b4\n4\f4\u02f7"+
		"\t4\u00014\u00034\u02fa\b4\u00034\u02fc\b4\u00014\u00014\u00015\u0001"+
		"5\u00015\u00015\u00055\u0304\b5\n5\f5\u0307\t5\u00015\u00035\u030a\b5"+
		"\u00015\u00015\u00016\u00016\u00036\u0310\b6\u00016\u00016\u00016\u0001"+
		"7\u00017\u00017\u0000\u0002>B8\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjln\u0000\u0007\u0002\u0000//CF\u0001\u0000\f\r\u0004\u0000"+
		"*.08:<>?\u0001\u0000\u001d&\u0001\u0000\u0001\u0002\u0001\u0000\u0015"+
		"\u0016\u0001\u0000`a\u036a\u0000s\u0001\u0000\u0000\u0000\u0002\u0086"+
		"\u0001\u0000\u0000\u0000\u0004\u0088\u0001\u0000\u0000\u0000\u0006\u008a"+
		"\u0001\u0000\u0000\u0000\b\u0093\u0001\u0000\u0000\u0000\n\u009c\u0001"+
		"\u0000\u0000\u0000\f\u00a5\u0001\u0000\u0000\u0000\u000e\u00aa\u0001\u0000"+
		"\u0000\u0000\u0010\u00af\u0001\u0000\u0000\u0000\u0012\u00bd\u0001\u0000"+
		"\u0000\u0000\u0014\u00c5\u0001\u0000\u0000\u0000\u0016\u00c9\u0001\u0000"+
		"\u0000\u0000\u0018\u00ce\u0001\u0000\u0000\u0000\u001a\u00d6\u0001\u0000"+
		"\u0000\u0000\u001c\u00e2\u0001\u0000\u0000\u0000\u001e\u00e7\u0001\u0000"+
		"\u0000\u0000 \u00f7\u0001\u0000\u0000\u0000\"\u0107\u0001\u0000\u0000"+
		"\u0000$\u0113\u0001\u0000\u0000\u0000&\u011f\u0001\u0000\u0000\u0000("+
		"\u0121\u0001\u0000\u0000\u0000*\u0123\u0001\u0000\u0000\u0000,\u013f\u0001"+
		"\u0000\u0000\u0000.\u0141\u0001\u0000\u0000\u00000\u0156\u0001\u0000\u0000"+
		"\u00002\u0158\u0001\u0000\u0000\u00004\u015f\u0001\u0000\u0000\u00006"+
		"\u0161\u0001\u0000\u0000\u00008\u0169\u0001\u0000\u0000\u0000:\u0175\u0001"+
		"\u0000\u0000\u0000<\u0185\u0001\u0000\u0000\u0000>\u0195\u0001\u0000\u0000"+
		"\u0000@\u01df\u0001\u0000\u0000\u0000B\u01e1\u0001\u0000\u0000\u0000D"+
		"\u01fd\u0001\u0000\u0000\u0000F\u01ff\u0001\u0000\u0000\u0000H\u0207\u0001"+
		"\u0000\u0000\u0000J\u020e\u0001\u0000\u0000\u0000L\u0210\u0001\u0000\u0000"+
		"\u0000N\u0249\u0001\u0000\u0000\u0000P\u026f\u0001\u0000\u0000\u0000R"+
		"\u0271\u0001\u0000\u0000\u0000T\u0284\u0001\u0000\u0000\u0000V\u0286\u0001"+
		"\u0000\u0000\u0000X\u029b\u0001\u0000\u0000\u0000Z\u029d\u0001\u0000\u0000"+
		"\u0000\\\u02a8\u0001\u0000\u0000\u0000^\u02ac\u0001\u0000\u0000\u0000"+
		"`\u02c7\u0001\u0000\u0000\u0000b\u02cd\u0001\u0000\u0000\u0000d\u02cf"+
		"\u0001\u0000\u0000\u0000f\u02df\u0001\u0000\u0000\u0000h\u02ef\u0001\u0000"+
		"\u0000\u0000j\u02ff\u0001\u0000\u0000\u0000l\u030f\u0001\u0000\u0000\u0000"+
		"n\u0314\u0001\u0000\u0000\u0000pr\u0003\u0002\u0001\u0000qp\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"vw\u0005\u0000\u0000\u0001w\u0001\u0001\u0000\u0000\u0000x\u0087\u0003"+
		"\b\u0004\u0000y\u0087\u0003\n\u0005\u0000z\u0087\u0003\f\u0006\u0000{"+
		"\u0087\u0003\u000e\u0007\u0000|\u0087\u0003\u0016\u000b\u0000}\u0087\u0003"+
		"\u0018\f\u0000~\u0087\u0003\u001a\r\u0000\u007f\u0087\u0003\u001e\u000f"+
		"\u0000\u0080\u0087\u0003 \u0010\u0000\u0081\u0087\u0003V+\u0000\u0082"+
		"\u0087\u0003^/\u0000\u0083\u0087\u0003\u0010\b\u0000\u0084\u0087\u0003"+
		"\"\u0011\u0000\u0085\u0087\u0003\u0004\u0002\u0000\u0086x\u0001\u0000"+
		"\u0000\u0000\u0086y\u0001\u0000\u0000\u0000\u0086z\u0001\u0000\u0000\u0000"+
		"\u0086{\u0001\u0000\u0000\u0000\u0086|\u0001\u0000\u0000\u0000\u0086}"+
		"\u0001\u0000\u0000\u0000\u0086~\u0001\u0000\u0000\u0000\u0086\u007f\u0001"+
		"\u0000\u0000\u0000\u0086\u0080\u0001\u0000\u0000\u0000\u0086\u0081\u0001"+
		"\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000\u0086\u0083\u0001"+
		"\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0085\u0001"+
		"\u0000\u0000\u0000\u0087\u0003\u0001\u0000\u0000\u0000\u0088\u0089\u0003"+
		"4\u001a\u0000\u0089\u0005\u0001\u0000\u0000\u0000\u008a\u008e\u0005K\u0000"+
		"\u0000\u008b\u008d\u0003\u0002\u0001\u0000\u008c\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000"+
		"\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0005L\u0000\u0000"+
		"\u0092\u0007\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u0001\u0000\u0000"+
		"\u0094\u0097\u0003n7\u0000\u0095\u0096\u0005O\u0000\u0000\u0096\u0098"+
		"\u0003J%\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005/\u0000"+
		"\u0000\u009a\u009b\u00034\u001a\u0000\u009b\t\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0005\u0002\u0000\u0000\u009d\u00a0\u0003n7\u0000\u009e\u009f"+
		"\u0005O\u0000\u0000\u009f\u00a1\u0003J%\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005/\u0000\u0000\u00a3\u00a4\u00034\u001a\u0000"+
		"\u00a4\u000b\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0003\u0000\u0000"+
		"\u00a6\u00a7\u0003n7\u0000\u00a7\u00a8\u0007\u0000\u0000\u0000\u00a8\u00a9"+
		"\u00034\u001a\u0000\u00a9\r\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005"+
		"\u0004\u0000\u0000\u00ab\u00ac\u0003n7\u0000\u00ac\u00ad\u0005/\u0000"+
		"\u0000\u00ad\u00ae\u00034\u001a\u0000\u00ae\u000f\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0\u00b1\u0003n7\u0000\u00b1\u00b3"+
		"\u0005G\u0000\u0000\u00b2\u00b4\u0003\u0012\t\u0000\u00b3\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b8\u0005H\u0000\u0000\u00b6\u00b7\u0005O\u0000"+
		"\u0000\u00b7\u00b9\u0003J%\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0005@\u0000\u0000\u00bb\u00bc\u00034\u001a\u0000\u00bc\u0011\u0001"+
		"\u0000\u0000\u0000\u00bd\u00c2\u0003\u0014\n\u0000\u00be\u00bf\u0005M"+
		"\u0000\u0000\u00bf\u00c1\u0003\u0014\n\u0000\u00c0\u00be\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u0013\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003n7\u0000\u00c6"+
		"\u00c7\u0005O\u0000\u0000\u00c7\u00c8\u0003J%\u0000\u00c8\u0015\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005\t\u0000\u0000\u00ca\u00cb\u00034"+
		"\u001a\u0000\u00cb\u00cc\u0005\n\u0000\u0000\u00cc\u00cd\u00034\u001a"+
		"\u0000\u00cd\u0017\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005\u0006\u0000"+
		"\u0000\u00cf\u00d0\u00034\u001a\u0000\u00d0\u00d1\u0005\u0007\u0000\u0000"+
		"\u00d1\u00d4\u00034\u001a\u0000\u00d2\u00d3\u0005\b\u0000\u0000\u00d3"+
		"\u00d5\u00034\u001a\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d5\u0019\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0005\u0010\u0000\u0000\u00d7\u00db\u00034\u001a\u0000\u00d8\u00da\u0003"+
		"\u001c\u000e\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00e0\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005\b\u0000\u0000\u00df\u00e1\u00034"+
		"\u001a\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e1\u001b\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0011"+
		"\u0000\u0000\u00e3\u00e4\u0003&\u0013\u0000\u00e4\u00e5\u0005\u0007\u0000"+
		"\u0000\u00e5\u00e6\u00034\u001a\u0000\u00e6\u001d\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e9\u0005\u000b\u0000\u0000\u00e8\u00ea\u0005\u0004\u0000\u0000"+
		"\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003n7\u0000\u00ec\u00ed"+
		"\u0005/\u0000\u0000\u00ed\u00ee\u00034\u001a\u0000\u00ee\u00ef\u0007\u0001"+
		"\u0000\u0000\u00ef\u00f2\u00034\u001a\u0000\u00f0\u00f1\u0005\u000e\u0000"+
		"\u0000\u00f1\u00f3\u00034\u001a\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000"+
		"\u00f4\u00f5\u0005\n\u0000\u0000\u00f5\u00f6\u00034\u001a\u0000\u00f6"+
		"\u001f\u0001\u0000\u0000\u0000\u00f7\u00f9\u0005\u000b\u0000\u0000\u00f8"+
		"\u00fa\u0005\u0004\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0003n7\u0000\u00fc\u00fd\u0005/\u0000\u0000\u00fd\u00fe\u0003"+
		"4\u001a\u0000\u00fe\u00ff\u0007\u0001\u0000\u0000\u00ff\u0102\u00034\u001a"+
		"\u0000\u0100\u0101\u0005\u000e\u0000\u0000\u0101\u0103\u00034\u001a\u0000"+
		"\u0102\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0105\u0005\u000f\u0000\u0000"+
		"\u0105\u0106\u00034\u001a\u0000\u0106!\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0005\u0017\u0000\u0000\u0108\u010c\u00034\u001a\u0000\u0109\u010b\u0003"+
		"$\u0012\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u0111\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000"+
		"\u0000\u0000\u010f\u0110\u0005\u0019\u0000\u0000\u0110\u0112\u0003n7\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112#\u0001\u0000\u0000\u0000\u0113\u0114\u0005\u0018\u0000\u0000\u0114"+
		"\u0115\u0003n7\u0000\u0115\u0116\u0005O\u0000\u0000\u0116\u0117\u0003"+
		"J%\u0000\u0117\u0118\u0005\u0007\u0000\u0000\u0118\u0119\u00034\u001a"+
		"\u0000\u0119%\u0001\u0000\u0000\u0000\u011a\u0120\u0003(\u0014\u0000\u011b"+
		"\u0120\u0003*\u0015\u0000\u011c\u0120\u0003,\u0016\u0000\u011d\u0120\u0003"+
		"0\u0018\u0000\u011e\u0120\u00032\u0019\u0000\u011f\u011a\u0001\u0000\u0000"+
		"\u0000\u011f\u011b\u0001\u0000\u0000\u0000\u011f\u011c\u0001\u0000\u0000"+
		"\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u011e\u0001\u0000\u0000"+
		"\u0000\u0120\'\u0001\u0000\u0000\u0000\u0121\u0122\u0003`0\u0000\u0122"+
		")\u0001\u0000\u0000\u0000\u0123\u0124\u0003n7\u0000\u0124\u0125\u0005"+
		"O\u0000\u0000\u0125\u0126\u0003J%\u0000\u0126+\u0001\u0000\u0000\u0000"+
		"\u0127\u0128\u0005I\u0000\u0000\u0128\u012d\u0003&\u0013\u0000\u0129\u012a"+
		"\u0005M\u0000\u0000\u012a\u012c\u0003&\u0013\u0000\u012b\u0129\u0001\u0000"+
		"\u0000\u0000\u012c\u012f\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e\u0133\u0001\u0000"+
		"\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0131\u0005M\u0000"+
		"\u0000\u0131\u0132\u0005U\u0000\u0000\u0132\u0134\u0003n7\u0000\u0133"+
		"\u0130\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0005J\u0000\u0000\u0136\u0140"+
		"\u0001\u0000\u0000\u0000\u0137\u0138\u0005I\u0000\u0000\u0138\u0139\u0003"+
		"n7\u0000\u0139\u013a\u0005M\u0000\u0000\u013a\u013b\u0005U\u0000\u0000"+
		"\u013b\u013c\u0003n7\u0000\u013c\u013d\u0005J\u0000\u0000\u013d\u0140"+
		"\u0001\u0000\u0000\u0000\u013e\u0140\u0003.\u0017\u0000\u013f\u0127\u0001"+
		"\u0000\u0000\u0000\u013f\u0137\u0001\u0000\u0000\u0000\u013f\u013e\u0001"+
		"\u0000\u0000\u0000\u0140-\u0001\u0000\u0000\u0000\u0141\u0142\u0003n7"+
		"\u0000\u0142\u014b\u0005K\u0000\u0000\u0143\u0148\u0003n7\u0000\u0144"+
		"\u0145\u0005M\u0000\u0000\u0145\u0147\u0003n7\u0000\u0146\u0144\u0001"+
		"\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001"+
		"\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014c\u0001"+
		"\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u0143\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014d\u014e\u0005L\u0000\u0000\u014e/\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0003n7\u0000\u0150\u0151\u00055\u0000\u0000\u0151"+
		"\u0152\u00034\u001a\u0000\u0152\u0157\u0001\u0000\u0000\u0000\u0153\u0154"+
		"\u0005T\u0000\u0000\u0154\u0155\u00055\u0000\u0000\u0155\u0157\u00034"+
		"\u001a\u0000\u0156\u014f\u0001\u0000\u0000\u0000\u0156\u0153\u0001\u0000"+
		"\u0000\u0000\u01571\u0001\u0000\u0000\u0000\u0158\u0159\u0005T\u0000\u0000"+
		"\u01593\u0001\u0000\u0000\u0000\u015a\u0160\u00036\u001b\u0000\u015b\u0160"+
		"\u00038\u001c\u0000\u015c\u0160\u0003:\u001d\u0000\u015d\u0160\u0003<"+
		"\u001e\u0000\u015e\u0160\u0003>\u001f\u0000\u015f\u015a\u0001\u0000\u0000"+
		"\u0000\u015f\u015b\u0001\u0000\u0000\u0000\u015f\u015c\u0001\u0000\u0000"+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u015e\u0001\u0000\u0000"+
		"\u0000\u01605\u0001\u0000\u0000\u0000\u0161\u0162\u0005\u0006\u0000\u0000"+
		"\u0162\u0163\u00034\u001a\u0000\u0163\u0164\u0005\u0007\u0000\u0000\u0164"+
		"\u0167\u00034\u001a\u0000\u0165\u0166\u0005\b\u0000\u0000\u0166\u0168"+
		"\u00034\u001a\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001"+
		"\u0000\u0000\u0000\u01687\u0001\u0000\u0000\u0000\u0169\u016a\u0005\u0010"+
		"\u0000\u0000\u016a\u016e\u00034\u001a\u0000\u016b\u016d\u0003\u001c\u000e"+
		"\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000\u0000"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016f\u0173\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000"+
		"\u0000\u0171\u0172\u0005\b\u0000\u0000\u0172\u0174\u00034\u001a\u0000"+
		"\u0173\u0171\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000"+
		"\u01749\u0001\u0000\u0000\u0000\u0175\u0177\u0005\u000b\u0000\u0000\u0176"+
		"\u0178\u0005\u0004\u0000\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0177"+
		"\u0178\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179"+
		"\u017a\u0003n7\u0000\u017a\u017b\u0005/\u0000\u0000\u017b\u017c\u0003"+
		"4\u001a\u0000\u017c\u017d\u0007\u0001\u0000\u0000\u017d\u0180\u00034\u001a"+
		"\u0000\u017e\u017f\u0005\u000e\u0000\u0000\u017f\u0181\u00034\u001a\u0000"+
		"\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000\u0000\u0000"+
		"\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0183\u0005\n\u0000\u0000\u0183"+
		"\u0184\u00034\u001a\u0000\u0184;\u0001\u0000\u0000\u0000\u0185\u0187\u0005"+
		"\u000b\u0000\u0000\u0186\u0188\u0005\u0004\u0000\u0000\u0187\u0186\u0001"+
		"\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0003n7\u0000\u018a\u018b\u0005/\u0000"+
		"\u0000\u018b\u018c\u00034\u001a\u0000\u018c\u018d\u0007\u0001\u0000\u0000"+
		"\u018d\u0190\u00034\u001a\u0000\u018e\u018f\u0005\u000e\u0000\u0000\u018f"+
		"\u0191\u00034\u001a\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0193"+
		"\u0005\u000f\u0000\u0000\u0193\u0194\u00034\u001a\u0000\u0194=\u0001\u0000"+
		"\u0000\u0000\u0195\u0196\u0006\u001f\uffff\uffff\u0000\u0196\u0197\u0003"+
		"@ \u0000\u0197\u01d3\u0001\u0000\u0000\u0000\u0198\u0199\n\u0013\u0000"+
		"\u0000\u0199\u019a\u0005,\u0000\u0000\u019a\u01d2\u0003>\u001f\u0014\u019b"+
		"\u019c\n\u0012\u0000\u0000\u019c\u019d\u0005-\u0000\u0000\u019d\u01d2"+
		"\u0003>\u001f\u0013\u019e\u019f\n\u0011\u0000\u0000\u019f\u01a0\u0005"+
		".\u0000\u0000\u01a0\u01d2\u0003>\u001f\u0012\u01a1\u01a2\n\u0010\u0000"+
		"\u0000\u01a2\u01a3\u0005*\u0000\u0000\u01a3\u01d2\u0003>\u001f\u0011\u01a4"+
		"\u01a5\n\u000f\u0000\u0000\u01a5\u01a6\u0005+\u0000\u0000\u01a6\u01d2"+
		"\u0003>\u001f\u0010\u01a7\u01a8\n\u000e\u0000\u0000\u01a8\u01a9\u0005"+
		">\u0000\u0000\u01a9\u01d2\u0003>\u001f\u000f\u01aa\u01ab\n\r\u0000\u0000"+
		"\u01ab\u01ac\u0005?\u0000\u0000\u01ac\u01d2\u0003>\u001f\u000e\u01ad\u01ae"+
		"\n\f\u0000\u0000\u01ae\u01af\u00052\u0000\u0000\u01af\u01d2\u0003>\u001f"+
		"\r\u01b0\u01b1\n\u000b\u0000\u0000\u01b1\u01b2\u00053\u0000\u0000\u01b2"+
		"\u01d2\u0003>\u001f\f\u01b3\u01b4\n\n\u0000\u0000\u01b4\u01b5\u00054\u0000"+
		"\u0000\u01b5\u01d2\u0003>\u001f\u000b\u01b6\u01b7\n\t\u0000\u0000\u01b7"+
		"\u01b8\u00055\u0000\u0000\u01b8\u01d2\u0003>\u001f\n\u01b9\u01ba\n\b\u0000"+
		"\u0000\u01ba\u01bb\u00050\u0000\u0000\u01bb\u01d2\u0003>\u001f\t\u01bc"+
		"\u01bd\n\u0007\u0000\u0000\u01bd\u01be\u00051\u0000\u0000\u01be\u01d2"+
		"\u0003>\u001f\b\u01bf\u01c0\n\u0006\u0000\u0000\u01c0\u01c1\u00056\u0000"+
		"\u0000\u01c1\u01d2\u0003>\u001f\u0007\u01c2\u01c3\n\u0005\u0000\u0000"+
		"\u01c3\u01c4\u0005:\u0000\u0000\u01c4\u01d2\u0003>\u001f\u0006\u01c5\u01c6"+
		"\n\u0004\u0000\u0000\u01c6\u01c7\u0005<\u0000\u0000\u01c7\u01d2\u0003"+
		">\u001f\u0005\u01c8\u01c9\n\u0003\u0000\u0000\u01c9\u01ca\u0005;\u0000"+
		"\u0000\u01ca\u01d2\u0003>\u001f\u0004\u01cb\u01cc\n\u0002\u0000\u0000"+
		"\u01cc\u01cd\u00057\u0000\u0000\u01cd\u01d2\u0003>\u001f\u0003\u01ce\u01cf"+
		"\n\u0001\u0000\u0000\u01cf\u01d0\u00058\u0000\u0000\u01d0\u01d2\u0003"+
		">\u001f\u0002\u01d1\u0198\u0001\u0000\u0000\u0000\u01d1\u019b\u0001\u0000"+
		"\u0000\u0000\u01d1\u019e\u0001\u0000\u0000\u0000\u01d1\u01a1\u0001\u0000"+
		"\u0000\u0000\u01d1\u01a4\u0001\u0000\u0000\u0000\u01d1\u01a7\u0001\u0000"+
		"\u0000\u0000\u01d1\u01aa\u0001\u0000\u0000\u0000\u01d1\u01ad\u0001\u0000"+
		"\u0000\u0000\u01d1\u01b0\u0001\u0000\u0000\u0000\u01d1\u01b3\u0001\u0000"+
		"\u0000\u0000\u01d1\u01b6\u0001\u0000\u0000\u0000\u01d1\u01b9\u0001\u0000"+
		"\u0000\u0000\u01d1\u01bc\u0001\u0000\u0000\u0000\u01d1\u01bf\u0001\u0000"+
		"\u0000\u0000\u01d1\u01c2\u0001\u0000\u0000\u0000\u01d1\u01c5\u0001\u0000"+
		"\u0000\u0000\u01d1\u01c8\u0001\u0000\u0000\u0000\u01d1\u01cb\u0001\u0000"+
		"\u0000\u0000\u01d1\u01ce\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d4?\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d7\u00059\u0000\u0000\u01d7\u01e0\u0003@ \u0000\u01d8"+
		"\u01d9\u0005+\u0000\u0000\u01d9\u01e0\u0003@ \u0000\u01da\u01db\u0005"+
		"*\u0000\u0000\u01db\u01e0\u0003@ \u0000\u01dc\u01dd\u0005=\u0000\u0000"+
		"\u01dd\u01e0\u0003@ \u0000\u01de\u01e0\u0003B!\u0000\u01df\u01d6\u0001"+
		"\u0000\u0000\u0000\u01df\u01d8\u0001\u0000\u0000\u0000\u01df\u01da\u0001"+
		"\u0000\u0000\u0000\u01df\u01dc\u0001\u0000\u0000\u0000\u01df\u01de\u0001"+
		"\u0000\u0000\u0000\u01e0A\u0001\u0000\u0000\u0000\u01e1\u01e2\u0006!\uffff"+
		"\uffff\u0000\u01e2\u01e3\u0003D\"\u0000\u01e3\u01f2\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e5\n\u0003\u0000\u0000\u01e5\u01e6\u0005P\u0000\u0000"+
		"\u01e6\u01f1\u0003n7\u0000\u01e7\u01e8\n\u0002\u0000\u0000\u01e8\u01e9"+
		"\u0005P\u0000\u0000\u01e9\u01f1\u0005W\u0000\u0000\u01ea\u01eb\n\u0001"+
		"\u0000\u0000\u01eb\u01ed\u0005G\u0000\u0000\u01ec\u01ee\u0003F#\u0000"+
		"\u01ed\u01ec\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000"+
		"\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef\u01f1\u0005H\u0000\u0000\u01f0"+
		"\u01e4\u0001\u0000\u0000\u0000\u01f0\u01e7\u0001\u0000\u0000\u0000\u01f0"+
		"\u01ea\u0001\u0000\u0000\u0000\u01f1\u01f4\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f0\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3"+
		"C\u0001\u0000\u0000\u0000\u01f4\u01f2\u0001\u0000\u0000\u0000\u01f5\u01fe"+
		"\u0003`0\u0000\u01f6\u01fe\u0003n7\u0000\u01f7\u01fe\u0005\u001a\u0000"+
		"\u0000\u01f8\u01f9\u0005G\u0000\u0000\u01f9\u01fa\u00034\u001a\u0000\u01fa"+
		"\u01fb\u0005H\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fe"+
		"\u0003\u0006\u0003\u0000\u01fd\u01f5\u0001\u0000\u0000\u0000\u01fd\u01f6"+
		"\u0001\u0000\u0000\u0000\u01fd\u01f7\u0001\u0000\u0000\u0000\u01fd\u01f8"+
		"\u0001\u0000\u0000\u0000\u01fd\u01fc\u0001\u0000\u0000\u0000\u01feE\u0001"+
		"\u0000\u0000\u0000\u01ff\u0204\u00034\u001a\u0000\u0200\u0201\u0005M\u0000"+
		"\u0000\u0201\u0203\u00034\u001a\u0000\u0202\u0200\u0001\u0000\u0000\u0000"+
		"\u0203\u0206\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000"+
		"\u0204\u0205\u0001\u0000\u0000\u0000\u0205G\u0001\u0000\u0000\u0000\u0206"+
		"\u0204\u0001\u0000\u0000\u0000\u0207\u0208\u0007\u0002\u0000\u0000\u0208"+
		"I\u0001\u0000\u0000\u0000\u0209\u020f\u0003L&\u0000\u020a\u020f\u0003"+
		"N\'\u0000\u020b\u020f\u0003P(\u0000\u020c\u020f\u0003R)\u0000\u020d\u020f"+
		"\u0003T*\u0000\u020e\u0209\u0001\u0000\u0000\u0000\u020e\u020a\u0001\u0000"+
		"\u0000\u0000\u020e\u020b\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000"+
		"\u0000\u0000\u020e\u020d\u0001\u0000\u0000\u0000\u020fK\u0001\u0000\u0000"+
		"\u0000\u0210\u0211\u0007\u0003\u0000\u0000\u0211M\u0001\u0000\u0000\u0000"+
		"\u0212\u0213\u0005\'\u0000\u0000\u0213\u0214\u0005G\u0000\u0000\u0214"+
		"\u0215\u0003J%\u0000\u0215\u0216\u0005H\u0000\u0000\u0216\u024a\u0001"+
		"\u0000\u0000\u0000\u0217\u0218\u0005\u0003\u0000\u0000\u0218\u0219\u0005"+
		"G\u0000\u0000\u0219\u021a\u0003J%\u0000\u021a\u021b\u0005H\u0000\u0000"+
		"\u021b\u024a\u0001\u0000\u0000\u0000\u021c\u021d\u0005)\u0000\u0000\u021d"+
		"\u021e\u0005G\u0000\u0000\u021e\u021f\u0003J%\u0000\u021f\u0220\u0005"+
		"M\u0000\u0000\u0220\u0221\u0003J%\u0000\u0221\u0222\u0005H\u0000\u0000"+
		"\u0222\u024a\u0001\u0000\u0000\u0000\u0223\u0224\u0005I\u0000\u0000\u0224"+
		"\u0225\u0003J%\u0000\u0225\u0226\u0005J\u0000\u0000\u0226\u024a\u0001"+
		"\u0000\u0000\u0000\u0227\u0228\u0005K\u0000\u0000\u0228\u0229\u0003J%"+
		"\u0000\u0229\u022a\u0005L\u0000\u0000\u022a\u024a\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0005O\u0000\u0000\u022c\u022d\u0005I\u0000\u0000\u022d\u022e"+
		"\u0003J%\u0000\u022e\u022f\u0005J\u0000\u0000\u022f\u024a\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0005O\u0000\u0000\u0231\u0232\u0005K\u0000\u0000"+
		"\u0232\u0233\u0003J%\u0000\u0233\u0234\u0005L\u0000\u0000\u0234\u024a"+
		"\u0001\u0000\u0000\u0000\u0235\u0236\u0005O\u0000\u0000\u0236\u0237\u0005"+
		"\'\u0000\u0000\u0237\u0238\u0005G\u0000\u0000\u0238\u0239\u0003J%\u0000"+
		"\u0239\u023a\u0005H\u0000\u0000\u023a\u024a\u0001\u0000\u0000\u0000\u023b"+
		"\u023c\u0005O\u0000\u0000\u023c\u023d\u0005\u0003\u0000\u0000\u023d\u023e"+
		"\u0005G\u0000\u0000\u023e\u023f\u0003J%\u0000\u023f\u0240\u0005H\u0000"+
		"\u0000\u0240\u024a\u0001\u0000\u0000\u0000\u0241\u0242\u0005O\u0000\u0000"+
		"\u0242\u0243\u0005)\u0000\u0000\u0243\u0244\u0005G\u0000\u0000\u0244\u0245"+
		"\u0003J%\u0000\u0245\u0246\u0005M\u0000\u0000\u0246\u0247\u0003J%\u0000"+
		"\u0247\u0248\u0005H\u0000\u0000\u0248\u024a\u0001\u0000\u0000\u0000\u0249"+
		"\u0212\u0001\u0000\u0000\u0000\u0249\u0217\u0001\u0000\u0000\u0000\u0249"+
		"\u021c\u0001\u0000\u0000\u0000\u0249\u0223\u0001\u0000\u0000\u0000\u0249"+
		"\u0227\u0001\u0000\u0000\u0000\u0249\u022b\u0001\u0000\u0000\u0000\u0249"+
		"\u0230\u0001\u0000\u0000\u0000\u0249\u0235\u0001\u0000\u0000\u0000\u0249"+
		"\u023b\u0001\u0000\u0000\u0000\u0249\u0241\u0001\u0000\u0000\u0000\u024a"+
		"O\u0001\u0000\u0000\u0000\u024b\u024c\u0005G\u0000\u0000\u024c\u0251\u0003"+
		"J%\u0000\u024d\u024e\u0005M\u0000\u0000\u024e\u0250\u0003J%\u0000\u024f"+
		"\u024d\u0001\u0000\u0000\u0000\u0250\u0253\u0001\u0000\u0000\u0000\u0251"+
		"\u024f\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252"+
		"\u0254\u0001\u0000\u0000\u0000\u0253\u0251\u0001\u0000\u0000\u0000\u0254"+
		"\u0255\u0005H\u0000\u0000\u0255\u0270\u0001\u0000\u0000\u0000\u0256\u0257"+
		"\u0005O\u0000\u0000\u0257\u0258\u0005G\u0000\u0000\u0258\u025d\u0003J"+
		"%\u0000\u0259\u025a\u0005M\u0000\u0000\u025a\u025c\u0003J%\u0000\u025b"+
		"\u0259\u0001\u0000\u0000\u0000\u025c\u025f\u0001\u0000\u0000\u0000\u025d"+
		"\u025b\u0001\u0000\u0000\u0000\u025d\u025e\u0001\u0000\u0000\u0000\u025e"+
		"\u0260\u0001\u0000\u0000\u0000\u025f\u025d\u0001\u0000\u0000\u0000\u0260"+
		"\u0261\u0005H\u0000\u0000\u0261\u0270\u0001\u0000\u0000\u0000\u0262\u0263"+
		"\u0005O\u0000\u0000\u0263\u0264\u0005(\u0000\u0000\u0264\u0265\u0005G"+
		"\u0000\u0000\u0265\u026a\u0003J%\u0000\u0266\u0267\u0005M\u0000\u0000"+
		"\u0267\u0269\u0003J%\u0000\u0268\u0266\u0001\u0000\u0000\u0000\u0269\u026c"+
		"\u0001\u0000\u0000\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026a\u026b"+
		"\u0001\u0000\u0000\u0000\u026b\u026d\u0001\u0000\u0000\u0000\u026c\u026a"+
		"\u0001\u0000\u0000\u0000\u026d\u026e\u0005H\u0000\u0000\u026e\u0270\u0001"+
		"\u0000\u0000\u0000\u026f\u024b\u0001\u0000\u0000\u0000\u026f\u0256\u0001"+
		"\u0000\u0000\u0000\u026f\u0262\u0001\u0000\u0000\u0000\u0270Q\u0001\u0000"+
		"\u0000\u0000\u0271\u0272\u0005\u0005\u0000\u0000\u0272\u027b\u0005G\u0000"+
		"\u0000\u0273\u0278\u0003J%\u0000\u0274\u0275\u0005M\u0000\u0000\u0275"+
		"\u0277\u0003J%\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0277\u027a\u0001"+
		"\u0000\u0000\u0000\u0278\u0276\u0001\u0000\u0000\u0000\u0278\u0279\u0001"+
		"\u0000\u0000\u0000\u0279\u027c\u0001\u0000\u0000\u0000\u027a\u0278\u0001"+
		"\u0000\u0000\u0000\u027b\u0273\u0001\u0000\u0000\u0000\u027b\u027c\u0001"+
		"\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d\u027e\u0005"+
		"H\u0000\u0000\u027e\u027f\u0005A\u0000\u0000\u027f\u0280\u0003J%\u0000"+
		"\u0280S\u0001\u0000\u0000\u0000\u0281\u0285\u0003n7\u0000\u0282\u0283"+
		"\u0005O\u0000\u0000\u0283\u0285\u0003n7\u0000\u0284\u0281\u0001\u0000"+
		"\u0000\u0000\u0284\u0282\u0001\u0000\u0000\u0000\u0285U\u0001\u0000\u0000"+
		"\u0000\u0286\u0287\u0005\u0012\u0000\u0000\u0287\u028d\u0003n7\u0000\u0288"+
		"\u028a\u0005G\u0000\u0000\u0289\u028b\u0003\u0012\t\u0000\u028a\u0289"+
		"\u0001\u0000\u0000\u0000\u028a\u028b\u0001\u0000\u0000\u0000\u028b\u028c"+
		"\u0001\u0000\u0000\u0000\u028c\u028e\u0005H\u0000\u0000\u028d\u0288\u0001"+
		"\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e\u028f\u0001"+
		"\u0000\u0000\u0000\u028f\u0293\u0005@\u0000\u0000\u0290\u0292\u0003X,"+
		"\u0000\u0291\u0290\u0001\u0000\u0000\u0000\u0292\u0295\u0001\u0000\u0000"+
		"\u0000\u0293\u0291\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000\u0000"+
		"\u0000\u0294\u0296\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000\u0000"+
		"\u0000\u0296\u0297\u0005\u0013\u0000\u0000\u0297\u0298\u0003n7\u0000\u0298"+
		"W\u0001\u0000\u0000\u0000\u0299\u029c\u0003Z-\u0000\u029a\u029c\u0003"+
		"\\.\u0000\u029b\u0299\u0001\u0000\u0000\u0000\u029b\u029a\u0001\u0000"+
		"\u0000\u0000\u029cY\u0001\u0000\u0000\u0000\u029d\u029f\u0007\u0004\u0000"+
		"\u0000\u029e\u02a0\u0007\u0005\u0000\u0000\u029f\u029e\u0001\u0000\u0000"+
		"\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000"+
		"\u0000\u02a1\u02a2\u0003n7\u0000\u02a2\u02a3\u0005O\u0000\u0000\u02a3"+
		"\u02a4\u0003J%\u0000\u02a4\u02a5\u0005/\u0000\u0000\u02a5\u02a6\u0003"+
		"4\u001a\u0000\u02a6[\u0001\u0000\u0000\u0000\u02a7\u02a9\u0007\u0005\u0000"+
		"\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ab\u0003\u0010\b\u0000"+
		"\u02ab]\u0001\u0000\u0000\u0000\u02ac\u02ad\u0005\u0014\u0000\u0000\u02ad"+
		"\u02ae\u0003J%\u0000\u02ae\u02b2\u0005@\u0000\u0000\u02af\u02b1\u0003"+
		"\\.\u0000\u02b0\u02af\u0001\u0000\u0000\u0000\u02b1\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000"+
		"\u0000\u0000\u02b3\u02b5\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000"+
		"\u0000\u0000\u02b5\u02b6\u0005\u0013\u0000\u0000\u02b6\u02b7\u0005\u0014"+
		"\u0000\u0000\u02b7_\u0001\u0000\u0000\u0000\u02b8\u02c8\u0005W\u0000\u0000"+
		"\u02b9\u02c8\u0005X\u0000\u0000\u02ba\u02c8\u0005Y\u0000\u0000\u02bb\u02c8"+
		"\u0005Z\u0000\u0000\u02bc\u02c8\u0005[\u0000\u0000\u02bd\u02c8\u0005\\"+
		"\u0000\u0000\u02be\u02c8\u0005]\u0000\u0000\u02bf\u02c8\u0005^\u0000\u0000"+
		"\u02c0\u02c8\u0005_\u0000\u0000\u02c1\u02c8\u0005b\u0000\u0000\u02c2\u02c8"+
		"\u0005c\u0000\u0000\u02c3\u02c8\u0005\u001b\u0000\u0000\u02c4\u02c8\u0005"+
		"\u001c\u0000\u0000\u02c5\u02c8\u0005\u001d\u0000\u0000\u02c6\u02c8\u0003"+
		"b1\u0000\u02c7\u02b8\u0001\u0000\u0000\u0000\u02c7\u02b9\u0001\u0000\u0000"+
		"\u0000\u02c7\u02ba\u0001\u0000\u0000\u0000\u02c7\u02bb\u0001\u0000\u0000"+
		"\u0000\u02c7\u02bc\u0001\u0000\u0000\u0000\u02c7\u02bd\u0001\u0000\u0000"+
		"\u0000\u02c7\u02be\u0001\u0000\u0000\u0000\u02c7\u02bf\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c0\u0001\u0000\u0000\u0000\u02c7\u02c1\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c2\u0001\u0000\u0000\u0000\u02c7\u02c3\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c4\u0001\u0000\u0000\u0000\u02c7\u02c5\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c6\u0001\u0000\u0000\u0000\u02c8a\u0001\u0000\u0000\u0000"+
		"\u02c9\u02ce\u0003d2\u0000\u02ca\u02ce\u0003f3\u0000\u02cb\u02ce\u0003"+
		"h4\u0000\u02cc\u02ce\u0003j5\u0000\u02cd\u02c9\u0001\u0000\u0000\u0000"+
		"\u02cd\u02ca\u0001\u0000\u0000\u0000\u02cd\u02cb\u0001\u0000\u0000\u0000"+
		"\u02cd\u02cc\u0001\u0000\u0000\u0000\u02cec\u0001\u0000\u0000\u0000\u02cf"+
		"\u02db\u0005G\u0000\u0000\u02d0\u02d5\u00034\u001a\u0000\u02d1\u02d2\u0005"+
		"M\u0000\u0000\u02d2\u02d4\u00034\u001a\u0000\u02d3\u02d1\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d7\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001\u0000\u0000"+
		"\u0000\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6\u02d9\u0001\u0000\u0000"+
		"\u0000\u02d7\u02d5\u0001\u0000\u0000\u0000\u02d8\u02da\u0005M\u0000\u0000"+
		"\u02d9\u02d8\u0001\u0000\u0000\u0000\u02d9\u02da\u0001\u0000\u0000\u0000"+
		"\u02da\u02dc\u0001\u0000\u0000\u0000\u02db\u02d0\u0001\u0000\u0000\u0000"+
		"\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02dd\u0001\u0000\u0000\u0000"+
		"\u02dd\u02de\u0005H\u0000\u0000\u02dee\u0001\u0000\u0000\u0000\u02df\u02eb"+
		"\u0005I\u0000\u0000\u02e0\u02e5\u00034\u001a\u0000\u02e1\u02e2\u0005M"+
		"\u0000\u0000\u02e2\u02e4\u00034\u001a\u0000\u02e3\u02e1\u0001\u0000\u0000"+
		"\u0000\u02e4\u02e7\u0001\u0000\u0000\u0000\u02e5\u02e3\u0001\u0000\u0000"+
		"\u0000\u02e5\u02e6\u0001\u0000\u0000\u0000\u02e6\u02e9\u0001\u0000\u0000"+
		"\u0000\u02e7\u02e5\u0001\u0000\u0000\u0000\u02e8\u02ea\u0005M\u0000\u0000"+
		"\u02e9\u02e8\u0001\u0000\u0000\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000"+
		"\u02ea\u02ec\u0001\u0000\u0000\u0000\u02eb\u02e0\u0001\u0000\u0000\u0000"+
		"\u02eb\u02ec\u0001\u0000\u0000\u0000\u02ec\u02ed\u0001\u0000\u0000\u0000"+
		"\u02ed\u02ee\u0005J\u0000\u0000\u02eeg\u0001\u0000\u0000\u0000\u02ef\u02fb"+
		"\u0005K\u0000\u0000\u02f0\u02f5\u00034\u001a\u0000\u02f1\u02f2\u0005M"+
		"\u0000\u0000\u02f2\u02f4\u00034\u001a\u0000\u02f3\u02f1\u0001\u0000\u0000"+
		"\u0000\u02f4\u02f7\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001\u0000\u0000"+
		"\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000\u02f6\u02f9\u0001\u0000\u0000"+
		"\u0000\u02f7\u02f5\u0001\u0000\u0000\u0000\u02f8\u02fa\u0005M\u0000\u0000"+
		"\u02f9\u02f8\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001\u0000\u0000\u0000"+
		"\u02fa\u02fc\u0001\u0000\u0000\u0000\u02fb\u02f0\u0001\u0000\u0000\u0000"+
		"\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fd\u0001\u0000\u0000\u0000"+
		"\u02fd\u02fe\u0005L\u0000\u0000\u02fei\u0001\u0000\u0000\u0000\u02ff\u0300"+
		"\u0005K\u0000\u0000\u0300\u0305\u0003l6\u0000\u0301\u0302\u0005M\u0000"+
		"\u0000\u0302\u0304\u0003l6\u0000\u0303\u0301\u0001\u0000\u0000\u0000\u0304"+
		"\u0307\u0001\u0000\u0000\u0000\u0305\u0303\u0001\u0000\u0000\u0000\u0305"+
		"\u0306\u0001\u0000\u0000\u0000\u0306\u0309\u0001\u0000\u0000\u0000\u0307"+
		"\u0305\u0001\u0000\u0000\u0000\u0308\u030a\u0005M\u0000\u0000\u0309\u0308"+
		"\u0001\u0000\u0000\u0000\u0309\u030a\u0001\u0000\u0000\u0000\u030a\u030b"+
		"\u0001\u0000\u0000\u0000\u030b\u030c\u0005L\u0000\u0000\u030ck\u0001\u0000"+
		"\u0000\u0000\u030d\u0310\u0003n7\u0000\u030e\u0310\u0005]\u0000\u0000"+
		"\u030f\u030d\u0001\u0000\u0000\u0000\u030f\u030e\u0001\u0000\u0000\u0000"+
		"\u0310\u0311\u0001\u0000\u0000\u0000\u0311\u0312\u0005/\u0000\u0000\u0312"+
		"\u0313\u00034\u001a\u0000\u0313m\u0001\u0000\u0000\u0000\u0314\u0315\u0007"+
		"\u0006\u0000\u0000\u0315o\u0001\u0000\u0000\u0000Fs\u0086\u008e\u0097"+
		"\u00a0\u00b3\u00b8\u00c2\u00d4\u00db\u00e0\u00e9\u00f2\u00f9\u0102\u010c"+
		"\u0111\u011f\u012d\u0133\u013f\u0148\u014b\u0156\u015f\u0167\u016e\u0173"+
		"\u0177\u0180\u0187\u0190\u01d1\u01d3\u01df\u01ed\u01f0\u01f2\u01fd\u0204"+
		"\u020e\u0249\u0251\u025d\u026a\u026f\u0278\u027b\u0284\u028a\u028d\u0293"+
		"\u029b\u029f\u02a8\u02b2\u02c7\u02cd\u02d5\u02d9\u02db\u02e5\u02e9\u02eb"+
		"\u02f5\u02f9\u02fb\u0305\u0309\u030f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}