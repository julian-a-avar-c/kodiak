parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: ws* stmts ws* EOF;
stmts: stmt? (stmtSep stmt?)* stmtSep?;
stmt: expr | decl;
stmtSep: (sl* (SEMI | nl)+ sl*)+;

decl: valDecl | varDecl | setDecl;
valDecl: VAL sl+ assignment;
varDecl: VAR sl+ assignment;
setDecl: SET sl+ assignment;
letDecl: LET sl+ assignment;
assignment: id sl+ EQ ws+ expr;

expr: group | collection | app;

app:
	app (sl* args)+										# fnApp
	| receiver = app (ws* DOT sl* member = simpleExpr)+		# pathApp
	| left = app sl+ (op = id sl+ right = simpleExpr)+	# opApp
	| complexExpr										# exprHead;

complexExpr: ctl | fn | simpleExpr;

ctl: ifExpr | matchExpr | forExpr | whileExpr;
ifExpr:
	IF ws+ app ws+ THEN ws+ expr (ws+ ELSE ws+ expr)* (
		ws+ END SPACE IF
	)?;
matchExpr:
	MATCH ws+ app (ws+ matchBranch)+ (ws+ END SPACE MATCH)?;
matchBranch: matchBranchPatternWith | matchBranchPatternElse;
matchBranchPatternWith:
	WITH ws+ simpleExpr ws+ THEN ws+ expr (ws+ END SPACE CASE)?;
matchBranchPatternElse: ELSE ws+ expr (ws+ END SPACE CASE)?;
forExpr:
	FOR ws+ generatorStmts ws+ (DO | YIELD) ws+ expr (
		ws+ END SPACE FOR
	)?;
generatorStmts:
	assignment
	| generatorStmt? (stmtSep generatorStmt?)* stmtSep?;
generatorStmt: (letDecl | valDecl) (ws+ generatorConditional)?;
generatorConditional: IF ws+ expr;
whileExpr:
	WHILE ws+ expr ws+ DO ws+ expr (ws+ END SPACE WHILE)?;

fn: args ws* FAT_ARROW ws* expr;

simpleExpr:
	TRUE
	| FALSE
	| UNIT
	| textBlock
	| textWord
	| numberBlock
	| numberWord
	// interpolated with idBlock identifier
	| idBlock textBlock
	| idBlock textWord
	| idBlock numberBlock
	| idBlock numberWord
	// interpolated with idWord identifier
	| idWord textBlock
	| idWord textWord
	| idWord numberBlock
	| idWord numberWord
	// regular raw ident
	| idBlock
	| idWord
	| decimal
	| integer
	| plainId;

// ----------------------------------------------------------------------------

args: tupleArgs | arrayArgs | setArgs;
tupleArgs: tupleGroup | LTUPLE ws* collectionItems ws* RTUPLE;
arrayArgs: arrayGroup | LARRAY ws* collectionItems ws* RARRAY;
setArgs: setGroup | LSET ws* collectionItems ws* RSET;

group: tupleGroup | arrayGroup | setGroup;
tupleGroup: LTUPLE ws* expr ws* RTUPLE;
arrayGroup: LARRAY ws* expr ws* RARRAY;
setGroup: LSET ws* expr ws* RSET;

collection: tupleExpr | arrayExpr | setExpr;
tupleExpr: DOT LTUPLE ws* collectionItems ws* RTUPLE;
arrayExpr: DOT LARRAY ws* collectionItems ws* RARRAY;
setExpr: DOT LSET ws* collectionItems ws* RSET;
collectionItems:
	// Empty
	COMMA?
	// One item
	| expr ws* COMMA
	// Multiple items
	| expr (ws* COMMA ws* expr)+ (ws* COMMA)?;

// ----------------------------------------------------------------------------

textBlock: DOUBLE_QUOTE rawBlock;
textWord: DOUBLE_QUOTE word;

decimal: DIGIT DOT DIGIT;
integer: DIGIT;
numberBlock: HASH rawBlock;
numberWord: HASH word;

id: idBlock | idWord | plainId;
plainId: idHead word?;
idWord: BACK_QUOTE word;
idBlock: BACK_QUOTE rawBlock;

// ----------------------------------------------------------------------------

rawBlock:
	LTUPLE ~RTUPLE+? RTUPLE
	| LARRAY ~RARRAY+? RARRAY
	| LSET ~RSET+? RSET;
stmtBlock:
	LTUPLE stmts RTUPLE
	| LARRAY stmts RARRAY
	| LSET stmts RSET;
idHead: WORD;
word: (WORD | DIGIT)+;

sl: SPACE | TAB;
nl: RETURN | NEW_LINE;
ws: sl | nl;
// Single Statement WS
ssws: sl+ | sl* nl sl*;
