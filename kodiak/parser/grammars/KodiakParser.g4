parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: stmts? EOF;
stmts: expr (stmtSep+ expr)*;
stmtSep: SEMI;

expr:
	group					# groupExpr
	| expr sl anyId sl expr	# opApp
	| simpleExpr			# exprHead;

simpleExpr:
	TRUE
	| FALSE
	| textBlock
	| textWord
	| rawNumberBlock
	| rawNumberWord
	| rawIdBlock idTail?
	| rawIdWord idTail?
	| decimal
	| integer
	| plainId idTail?;

idTail: textBlock | textWord | rawNumberBlock | rawNumberWord;

// ----------------------------------------------------------------------------

ctl: if_ | match;
if_: IF sl expr sl THEN sl expr sl ELSE sl expr;
match: MATCH sl expr sl matchPattern;
matchPattern: matchGuard sl expr;
matchGuard: matchElseGuard | matchUntypedSimplExprGuard;
matchElseGuard: ELSE;
matchUntypedSimplExprGuard: WITH sl expr sl THEN;

// ----------------------------------------------------------------------------

group: tupleGroup;
tupleGroup: LTUPLE (expr | ctl) RTUPLE;

// ----------------------------------------------------------------------------

textBlock: DOUBLE_QUOTE rawBlock;
textWord: DOUBLE_QUOTE rawWord+;

rawNumberWord: HASH rawWord+ (DOT rawWord+)*;
rawNumberBlock: HASH rawBlock;
decimal: DASH? DIGIT+ DOT DIGIT+;
integer: DASH? DIGIT+;

anyId: rawIdBlock | rawIdWord | plainId;
plainId: WORD rawWord*;
rawIdWord:
	BACK_QUOTE (IF | TRUE | FALSE | rawWord+); // TODO: Add more keywords
rawIdBlock: BACK_QUOTE rawBlock;

// ----------------------------------------------------------------------------

rawWord: WORD | DIGIT | DASH;
rawBlock:
	LTUPLE ~RTUPLE* RTUPLE
	| LARRAY ~RARRAY* RARRAY
	| LSET ~RSET* RSET;

sl: SPACE | TAB;
nl: RETURN | NEW_LINE;
ws: sl | nl;
// Single Statement WS
ssws: sl+ | sl* nl sl*;