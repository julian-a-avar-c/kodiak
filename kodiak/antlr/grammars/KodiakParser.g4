parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: WS? (stmts WS?)? EOF;

stmts: stmt (WS? stmtSep WS? stmt)* (WS? stmtSep)?;
stmtSep: SEMI | NL;

stmt: decl | ifStmt | whileStmt | forStmt | expr;

decl: valDecl | varDecl | setDecl;
valDecl: VAL SL id SL eqDeclOp (STMT_WS expr | WS expr (WS END VAL)?);
varDecl: VAR SL id SL eqDeclOp (STMT_WS expr | WS expr (WS END VAR)?);
setDecl: SET SL id SL eqDeclOp (STMT_WS expr | WS expr (WS END SET)?);

eqDeclOp: EQ | plainEqDeclOp | rawEqDeclOp;
plainEqDeclOp: (rawIdWord | rawId) EQ;
rawEqDeclOp:
	LTID NOT_RTEQOP+ RTEQOP
	| LAID NOT_RAEQOP+ RAEQOP
	| LSID NOT_RSEQOP+ RSEQOP
	;

expr:
	if
	| match
    | for
	| fnApp
    | opApp
	| pathApp
    | exprHead;

ifStmt: IF WS expr WS THEN WS expr (WS END IF)?;
if: IF WS expr WS THEN WS expr WS ELSE WS expr (WS END IF)?;

match: MATCH WS expr (WS matchBranch)+ (WS END MATCH)?;
matchBranch: exprHead WS THEN WS expr;

forStmt: FOR WS forEnumerator WS DO WS expr (WS END FOR)?;
for: FOR WS forEnumerator WS YIELD WS expr (WS END FOR)?;
forEnumerator: LET? WS id WS EQ WS expr;

whileStmt: WHILE WS expr WS DO WS block (WS END WHILE)?;

fnApp: exprHead SL? collection;
opApp: exprHead SL id STMT_WS exprHead;
pathApp: staticPathApp | indexPathApp;
staticPathApp: exprHead STMT_WS? DOT id;
indexPathApp: exprHead STMT_WS? DOT integer;

exprHead:
	TRUE
	| FALSE
	| UNIT
	| plainText
	| rawNumber
    | rawId plainText
    | rawId rawNumber
    | rawId
    | group
	| collection
	| decimal
	| integer
	| plainId plainText
	| plainId rawNumber
	| plainId;

group: LTUPLE exprHead RTUPLE;

block: LSET (| WS | WS? stmts WS?) RSET;

// ----------------------------------------------------------------------------

collection: tuple | array | set;
tuple: LTUPLE (| WS | collectionContents) RTUPLE;
array: LARRAY (| WS | collectionContents) RARRAY;
set: LSET (| WS | collectionContents) RSET;
collectionContents:
	WS?
	expr
	(collectionSep expr)*
	(collectionSep)?
	;
collectionSep: WS? COMMA WS?;

// ----------------------------------------------------------------------------

integer: DIGIT+;
decimal: DIGIT+ DOT DIGIT+;
rawNumber: rawNumberBlock | rawNumberWord;
rawNumberBlock:
	LTNUMBER NOT_RTUPLE* RTUPLE
	| LANUMBER NOT_RARRAY* RARRAY
	| LSNUMBER NOT_RSET* RSET
	;
rawNumberWord: HASH WORD+;

plainText: plainTextBlock | plainTextWord;
plainTextBlock:
	LTTEXT NOT_RTUPLE* RTUPLE
	| LATEXT NOT_RARRAY* RARRAY
	| LSTEXT NOT_RSET* RSET
	;
plainTextWord: DOUBLE_QUOTE WORD+;

id: rawId | plainId;
plainId: ID_WORD WORD*;
rawId: rawIdBlock | rawIdWord;
rawIdWord: BACK_QUOTE WORD+;
rawIdBlock:
	LTID NOT_RTUPLE* RTUPLE
	| LAID NOT_RARRAY* RARRAY
	| LSID NOT_RSET* RSET
	;


