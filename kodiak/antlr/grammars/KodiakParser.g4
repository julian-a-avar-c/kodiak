parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: ws* stmts ws* EOF;
stmts: stmt? (stmtSep stmt?)* stmtSep?;
stmt: decl | anyExpr;
stmtSep: (sl* (SEMI | nl)+ sl*)+;

decl: valDecl | varDecl | setDecl;
valDecl: VAL ssws assignment;
varDecl: VAR ssws assignment;
setDecl: SET ssws assignment;
letDecl: LET ssws assignment;
assignment: id ssws (type ssws)? EQ ssws (anyExpr | stmtBlock);
collectionAssignment: (
		WITH fnExpr
		| group
		| anyCollection
		| simpleExpr
	) ssws EQ ssws stmtBlock;

anyExpr: ctlExpr | fnExpr | expr;

expr:
	group										# groupExpr
	| anyCollection								# collectionExpr
	| expr ssws? args							# implicitApplicationExpr
	| expr ssws? BACKSLASH ssws? (args | expr)	# explicitApplicationExpr
	| expr ssws id ssws expr					# operationApplication
	| simpleExpr								# exprHead;

type: COLON ssws? (group | anyCollection | simpleExpr);

ctlExpr: ifExpr | matchExpr | forExpr | whileExpr;
ifExpr:
	IF ws+ expr ws+ THEN ws+ expr (ws+ ELSE ws+ expr)* (
		ws+ END ssws IF
	)?;
matchExpr:
	MATCH ws+ expr (ws+ matchBranch)+ (ws+ END ssws MATCH)?;
matchBranch: matchBranchPatternWith | matchBranchPatternElse;
matchBranchPatternWith:
	WITH ws+ simpleExpr ws+ THEN ws+ expr (ws+ END ssws CASE)?;
matchBranchPatternElse: ELSE ws+ expr (ws+ END ssws CASE)?;
forExpr:
	FOR ws+ generatorStmts ws+ (DO | YIELD) ws+ expr (
		ws+ END ssws FOR
	)?;
generatorStmts:
	assignment
	| generatorStmt? (stmtSep generatorStmt?)* stmtSep?;
generatorStmt: (letDecl | valDecl) (ws+ generatorConditional)?;
generatorConditional: IF ws+ expr;
whileExpr:
	WHILE ws+ expr ws+ DO ws+ expr (ws+ END ssws WHILE)?;

fnExpr:
	(simpleExpr | group | args) ws* FAT_ARROW ws* (
		stmtBlock
		| anyExpr
	);

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
group: tupleGroup | arrayGroup | setGroup;
anyCollection:
	collection
	| namedCollection
	| someNamedCollection;

collection: tupleExpr | arrayExpr | setExpr;
namedCollection: namedTupleExpr | namedArrayExpr | namedSetExpr;
someNamedCollection:
	someNamedTupleExpr
	| someNamedArrayExpr
	| someNamedSetExpr;

tupleArgs:
	tupleGroup
	| tupleExpr
	| namedTupleExpr
	| someNamedTupleExpr;
arrayArgs:
	arrayGroup
	| arrayExpr
	| namedArrayExpr
	| someNamedArrayExpr;
setArgs:
	setGroup
	| setExpr
	| namedSetExpr
	| someNamedSetExpr;

tupleGroup: LTUPLE ws* anyExpr ws* RTUPLE;
arrayGroup: LARRAY ws* anyExpr ws* RARRAY;
setGroup: LSET ws* anyExpr ws* RSET;

tupleExpr: LTUPLE ws* collectionItems ws* RTUPLE;
arrayExpr: LARRAY ws* collectionItems ws* RARRAY;
setExpr: LSET ws* collectionItems ws* RSET;
namedTupleExpr: LTUPLE ws* namedCollectionItems ws* RTUPLE;
namedArrayExpr: LARRAY ws* namedCollectionItems ws* RARRAY;
namedSetExpr: LSET ws* namedCollectionItems ws* RSET;
someNamedTupleExpr:
	LTUPLE ws* someNamedCollectionItems ws* RTUPLE;
someNamedArrayExpr:
	LARRAY ws* someNamedCollectionItems ws* RARRAY;
someNamedSetExpr: LSET ws* someNamedCollectionItems ws* RSET;

collectionItems:
	// Empty
	COMMA?
	// One item
	| anyExpr ws* COMMA
	// Multiple items
	| anyExpr (ws* COMMA ws* anyExpr)+ (ws* COMMA)?;
namedCollectionItems:
	// Empty
	EQ
	// Multiple items
	| collectionAssignment (ws* COMMA ws* collectionAssignment)* (
		ws* COMMA
	)?;
someNamedCollectionItems:
	(anyExpr | collectionAssignment) (
		ws* COMMA ws* (anyExpr | collectionAssignment)
	)+ (ws* COMMA)?;

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
	(id? AT)? LTUPLE ws* stmts ws* RTUPLE
	| (id? AT)? LARRAY ws* stmts ws* RARRAY
	| (id? AT)? LSET ws* stmts ws* RSET;
idHead: WORD;
word: (WORD | DIGIT | DASH)+;

sl: SPACE | TAB;
nl: RETURN | NEW_LINE;
ws: sl | nl;
// Single Statement WS
ssws: sl+ | sl* nl sl*;
