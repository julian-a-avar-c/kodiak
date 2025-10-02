parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

@parser::members {
	private Set<String> keywords = Set.of(
		// simple literals
		"true", "false", "unit",
		// ctl
		"for", "if", "while", "match", "with", "then", "else", "do", "yield",
		// scope
		"end", "case",
		// decl
		"val", "var", "set", "let"
	);
		
	private boolean isKeyword(keyword: String) {
		return
			keywords.contains(keyword) &&
			keywords.contains(_input.LT(1).getText());
	}

	private boolean isNotKeyword() {
		return !keywords.contains(_input.LT(1).getText());
	}
	private boolean isNotKeyword(keyword: String) {
		return !isKeyword(keyword);
	}
}

// Program Structure
program: ws* stmts ws* EOF;
stmts: stmt? (stmtSep stmt?)* stmtSep?;
stmt: expr | decl;
stmtSep: (sl* (SEMI | nl)+ sl*)+;

decl: valDecl | varDecl | setDecl;
valDecl: val sl+ id sl+ EQ ws+ expr;
varDecl: var sl+ id sl+ EQ ws+ expr;
setDecl: set sl+ id sl+ EQ ws+ expr;
letDecl: let sl+ id sl+ EQ ws+ expr;

expr: group | collection | app | ctl;

ctl: ifExpr | matchExpr | forExpr | whileExpr;

ifExpr:
	if ws+ app ws+ then ws+ expr (ws+ else ws+ expr)* (
		ws+ end ' ' if
	)?;
matchExpr:
	match ws+ app (ws+ matchBranch)+ (ws+ end ' ' match)?;
matchBranch: matchBranchPatternWith | matchBranchPatternElse;
matchBranchPatternWith:
	with ws+ simpleExpr ws+ then ws+ expr (ws+ end ' ' case)?;
matchBranchPatternElse: else ws+ expr (ws+ end ' ' case)?;

forExpr:
	for ws+ generatorStmts ws+ (do | yield) ws+ expr (
		ws+ end ' ' for
	)?;
generatorStmts: generatorStmt (ws+ generatorConditional)?;
generatorStmt: letDecl | valDecl;
generatorConditional: if ws+ expr;

whileExpr: while ws+ expr ws+ do ws+ expr (ws+ end ' ' while)?;

app:
	app (sl* args)+					# fnApp
	| app (ws* DOT sl* simpleExpr)+	# pathApp
	| app sl+ (id sl+ simpleExpr)+	# opApp
	| simpleExpr					# exprHead;

simpleExpr:
	true
	| false
	| unit
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

decimal: DIGIT+ DOT DIGIT+;
integer: DIGIT+;
numberBlock: HASH rawBlock;
numberWord: HASH word;

id: idBlock | idWord | plainId;
plainId: {isNotKeyword()}? idStart word?;
idWord: BACK_QUOTE word;
idBlock: BACK_QUOTE rawBlock;

// ----------------------------------------------------------------------------

true: {isKeyword("true")}? WORD;
false: {isKeyword("false")}? WORD;
unit: {isKeyword("unit")}? WORD;

end: {isKeyword("end")}? WORD;
case: {isKeyword("case")}? WORD;

val: {isKeyword("val")}? WORD;
var: {isKeyword("var")}? WORD;
set: {isKeyword("set")}? WORD;
let: {isKeyword("let")}? WORD;

for: {isKeyword("for")}? WORD;
if: {isKeyword("if")}? WORD;
while: {isKeyword("while")}? WORD;
match: {isKeyword("match")}? WORD;
with: {isKeyword("with")}? WORD;
then: {isKeyword("then")}? WORD;
else: {isKeyword("else")}? WORD;
do: {isKeyword("do")}? WORD;
yield: {isKeyword("yield")}? WORD;

// ----------------------------------------------------------------------------

rawBlock:
	LTUPLE ~RTUPLE+? RTUPLE
	| LARRAY ~RARRAY+? RARRAY
	| LSET ~RSET+? RSET;
block:
	LTUPLE stmts RTUPLE
	| LARRAY stmts RARRAY
	| LSET stmts RSET;
idStart: WORD;
word: (WORD | DIGIT)+;

sl: SPACE | TAB;
nl: RETURN | NEW_LINE;
ws: sl | nl;
// Single Statement WS
ssws: sl+ | sl* nl sl*;