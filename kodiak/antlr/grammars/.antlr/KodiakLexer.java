// Generated from /home/julian-a-avar-c/Dev/sandbox/kodiak/kodiak/antlr/grammars/KodiakLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KodiakLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LTUPLE=1, RTUPLE=2, LARRAY=3, RARRAY=4, LSET=5, RSET=6, BACK_QUOTE=7, 
		DOUBLE_QUOTE=8, DASH=9, HASH=10, DOT=11, QUESTION=12, EQ=13, BACKSLASH=14, 
		COMMA=15, SEMI=16, AT=17, COLON=18, SINGLE_LINE_COMMENT=19, MULTI_LINE_COMMENT=20, 
		SPACE=21, TAB=22, RETURN=23, NEW_LINE=24, DIGIT=25, WORD=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LTUPLE", "RTUPLE", "LARRAY", "RARRAY", "LSET", "RSET", "BACK_QUOTE", 
			"DOUBLE_QUOTE", "DASH", "HASH", "DOT", "QUESTION", "EQ", "BACKSLASH", 
			"COMMA", "SEMI", "AT", "COLON", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", 
			"SPACE", "TAB", "RETURN", "NEW_LINE", "DIGIT", "WORD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'`'", "'\"'", "'-'", 
			"'#'", "'.'", "'?'", "'='", "'\\'", "','", "';'", "'@'", "':'", null, 
			null, "' '", "'\\t'", "'\\r'", "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LTUPLE", "RTUPLE", "LARRAY", "RARRAY", "LSET", "RSET", "BACK_QUOTE", 
			"DOUBLE_QUOTE", "DASH", "HASH", "DOT", "QUESTION", "EQ", "BACKSLASH", 
			"COMMA", "SEMI", "AT", "COLON", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", 
			"SPACE", "TAB", "RETURN", "NEW_LINE", "DIGIT", "WORD"
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


	public KodiakLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KodiakLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001a\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012_\b\u0012\n\u0012\f\u0012b\t\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013j\b\u0013"+
		"\n\u0013\f\u0013m\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001k\u0000\u001a\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a\u0001\u0000\u0002\u0002"+
		"\u0000\n\n\r\r\u0001\u000009\u0080\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001\u0000\u0000"+
		"\u0000\u00037\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007"+
		";\u0001\u0000\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000b?\u0001\u0000"+
		"\u0000\u0000\rA\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000\u0000"+
		"\u0011E\u0001\u0000\u0000\u0000\u0013G\u0001\u0000\u0000\u0000\u0015I"+
		"\u0001\u0000\u0000\u0000\u0017K\u0001\u0000\u0000\u0000\u0019M\u0001\u0000"+
		"\u0000\u0000\u001bO\u0001\u0000\u0000\u0000\u001dQ\u0001\u0000\u0000\u0000"+
		"\u001fS\u0001\u0000\u0000\u0000!U\u0001\u0000\u0000\u0000#W\u0001\u0000"+
		"\u0000\u0000%Y\u0001\u0000\u0000\u0000\'e\u0001\u0000\u0000\u0000)s\u0001"+
		"\u0000\u0000\u0000+u\u0001\u0000\u0000\u0000-w\u0001\u0000\u0000\u0000"+
		"/y\u0001\u0000\u0000\u00001{\u0001\u0000\u0000\u00003}\u0001\u0000\u0000"+
		"\u000056\u0005(\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0005)\u0000"+
		"\u00008\u0004\u0001\u0000\u0000\u00009:\u0005[\u0000\u0000:\u0006\u0001"+
		"\u0000\u0000\u0000;<\u0005]\u0000\u0000<\b\u0001\u0000\u0000\u0000=>\u0005"+
		"{\u0000\u0000>\n\u0001\u0000\u0000\u0000?@\u0005}\u0000\u0000@\f\u0001"+
		"\u0000\u0000\u0000AB\u0005`\u0000\u0000B\u000e\u0001\u0000\u0000\u0000"+
		"CD\u0005\"\u0000\u0000D\u0010\u0001\u0000\u0000\u0000EF\u0005-\u0000\u0000"+
		"F\u0012\u0001\u0000\u0000\u0000GH\u0005#\u0000\u0000H\u0014\u0001\u0000"+
		"\u0000\u0000IJ\u0005.\u0000\u0000J\u0016\u0001\u0000\u0000\u0000KL\u0005"+
		"?\u0000\u0000L\u0018\u0001\u0000\u0000\u0000MN\u0005=\u0000\u0000N\u001a"+
		"\u0001\u0000\u0000\u0000OP\u0005\\\u0000\u0000P\u001c\u0001\u0000\u0000"+
		"\u0000QR\u0005,\u0000\u0000R\u001e\u0001\u0000\u0000\u0000ST\u0005;\u0000"+
		"\u0000T \u0001\u0000\u0000\u0000UV\u0005@\u0000\u0000V\"\u0001\u0000\u0000"+
		"\u0000WX\u0005:\u0000\u0000X$\u0001\u0000\u0000\u0000YZ\u0005{\u0000\u0000"+
		"Z[\u0005?\u0000\u0000[\\\u0005}\u0000\u0000\\`\u0001\u0000\u0000\u0000"+
		"]_\b\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000cd\u0006\u0012\u0000\u0000d&\u0001\u0000"+
		"\u0000\u0000ef\u0005{\u0000\u0000fg\u0005?\u0000\u0000gk\u0001\u0000\u0000"+
		"\u0000hj\t\u0000\u0000\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000no\u0005?\u0000\u0000op\u0005}\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qr\u0006\u0013\u0000\u0000r(\u0001\u0000"+
		"\u0000\u0000st\u0005 \u0000\u0000t*\u0001\u0000\u0000\u0000uv\u0005\t"+
		"\u0000\u0000v,\u0001\u0000\u0000\u0000wx\u0005\r\u0000\u0000x.\u0001\u0000"+
		"\u0000\u0000yz\u0005\n\u0000\u0000z0\u0001\u0000\u0000\u0000{|\u0007\u0001"+
		"\u0000\u0000|2\u0001\u0000\u0000\u0000}~\t\u0000\u0000\u0000~4\u0001\u0000"+
		"\u0000\u0000\u0003\u0000`k\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}