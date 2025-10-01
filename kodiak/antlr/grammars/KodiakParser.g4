parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: programStart ws* stmts? ws* programEnd ws* EOF;
// stmts: stmt (ssws? stmtSep ws* stmt)* (ssws? stmtSep)?;
stmts: stmt (stmtSep stmt?)*;
stmt: expr;
stmtSep: (SL* | SL* NL SL*) (SEMI | NL) ws*;
programStart: ;
programEnd: (SEMI | NL)?;

expr: opApp | /*fnApp |*/ exprHead;
opApp: simpleExpr SL id SL simpleExpr;
// fnApp: simpleExpr args;
exprHead: simpleExpr;

simpleExpr:
	TRUE
	| FALSE
	| UNIT
	| group
	| collection
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
	| plainId
    ;

// ----------------------------------------------------------------------------

args: group | collection;

group: tupleGroup | arrayGroup | setGroup;
tupleGroup: LTUPLE ws* expr ws* RTUPLE;
arrayGroup: LARRAY ws* expr ws* RARRAY;
setGroup: LSET ws* expr ws* RSET;

collection: tuple | array | set;
tuple: LTUPLE ws* collectionItems ws* RTUPLE;
array: LARRAY ws* collectionItems ws* RARRAY;
set: LSET ws* collectionItems ws* RSET;
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

decimal: DIGIT+ DOT DIGIT+;
integer: DIGIT+;
numberBlock: HASH rawBlock;
numberWord: HASH word;

id: idBlock | idWord | plainId;
plainId: idStart WORD;
idWord: BACK_QUOTE word;
idBlock: BACK_QUOTE rawBlock;

// ----------------------------------------------------------------------------

rawBlock:
	LTUPLE ~RTUPLE+? RTUPLE
	| LARRAY ~RARRAY+? RARRAY
	| LSET ~RSET+? RSET;
idStart: (WORD | PLUS)+;
word: (DIGIT | WORD | PLUS)+;

ws: SL | NL;
// Single Statement WS
ssws: SL+ | SL* NL SL*;

//
// stmt: // decl // | ifStmt // | whileStmt // | forStmt // | expr ;
// 
// decl: valDecl | varDecl | setDecl; valDecl: VAL SL id SL eqDeclOp (STMT_WS expr | WS expr (WS END
// VAL)?); varDecl: VAR SL id SL eqDeclOp (STMT_WS expr | WS expr (WS END VAR)?); setDecl: SET SL id
// SL eqDeclOp (STMT_WS expr | WS expr (WS END SET)?);
// 
// eqDeclOp: EQ | plainEqDeclOp | rawEqDeclOp; plainEqDeclOp: (rawIdWord | rawId) EQ; rawEqDeclOp:
// LTID NOT_RTEQOP+ RTEQOP | LAID NOT_RAEQOP+ RAEQOP | LSID NOT_RSEQOP+ RSEQOP;
// 
// expr: // if // | match // | for // | fnApp // | opApp // | pathApp // | exprHead ;
// 
// ifStmt: IF WS expr WS THEN WS expr (WS END IF)?; if: IF WS expr WS THEN WS expr WS ELSE WS expr
// (WS END IF)?;
// 
// match: MATCH WS expr (WS matchBranch)+ (WS END MATCH)?; matchBranch: exprHead WS THEN WS expr;
// 
//
// 
//
// forStmt: FOR WS forEnumerator WS DO WS expr (WS END FOR)?; for: FOR WS forEnumerator WS YIELD WS
// expr (WS END FOR)?; forEnumerator: LET? WS id WS EQ WS expr;
// 
// whileStmt: WHILE WS expr WS DO WS block (WS END WHILE)?;
// 
// fnApp: exprHead SL? collection; opApp: exprHead SL id STMT_WS exprHead; pathApp: staticPathApp |
// indexPathApp; staticPathApp: exprHead STMT_WS? DOT id; indexPathApp: exprHead STMT_WS? DOT
// integer;
// 
// exprHead: TRUE | FALSE | UNIT // | plainText // | rawNumber // | rawId plainText // | rawId
// rawNumber // | rawId // | group // | collection // | decimal | integer // | plainId plainText //
// | plainId rawNumber // | plainId ;
// 
// block: LSET ( | WS | WS? stmts WS?) RSET;
// 
// // ----------------------------------------------------------------------------
// 
// args: group | collection;
// 
// group: tupleGroup | arrayGroup | setGroup; tupleGroup: LTUPLE WS? (expr WS?)? RTUPLE; arrayGroup:
// LARRAY WS? (expr WS?)? RARRAY; setGroup: LSET WS? (expr WS?)? RSET;
// 
// collection: tuple | array | set; tuple: LTUPLE WS? collectionItems WS? RTUPLE; array: LARRAY WS?
// collectionItems WS? RARRAY; set: LSET WS? collectionItems WS? RSET;
// 
// collectionItems: collectionSep | expr WS? collectionSep | expr WS? (collectionSep WS? expr WS?)+
// collectionSep?;
// 
// collectionSep: WS? COMMA WS?;
// 
// // ----------------------------------------------------------------------------
// 
// integer: DIGIT+; decimal: DIGIT+ DOT DIGIT+; rawNumber: rawNumberBlock | rawNumberWord;
// rawNumberBlock: LTNUMBER NOT_RTUPLE* RTUPLE | LANUMBER NOT_RARRAY* RARRAY | LSNUMBER NOT_RSET*
// RSET; rawNumberWord: HASH WORD+;
// 
// plainText: plainTextBlock | plainTextWord; plainTextBlock: LTTEXT NOT_RTUPLE* RTUPLE | LATEXT
// NOT_RARRAY* RARRAY | LSTEXT NOT_RSET* RSET; plainTextWord: DOUBLE_QUOTE WORD+;
// 
// id: rawId | plainId; plainId: ID_WORD WORD*; rawId: rawIdBlock | rawIdWord; rawIdWord: BACK_QUOTE
// WORD+; rawIdBlock: LTID NOT_RTUPLE* RTUPLE | LAID NOT_RARRAY* RARRAY | LSID NOT_RSET* RSET;
// 
//
// 
//