parser grammar KodiakParser;

options {
    tokenVocab = KodiakLexer;
}

// Program Structure
program: statement* EOF;

statement:
    valDecl
    | varDecl
    | setStmt
    | letDecl
    | whileLoop
    | ifStmt
    | matchStmt
    | forLoop
    | forYield
    | plexDecl
    | extensionDecl
    | functionDecl
    | tryStmt
    | exprStmt
    ;

exprStmt: expr;

block: LBRACE statement* RBRACE;

// Declarations
valDecl: VAL_DEF identifier (COLON type)? ASSIGN expr;
varDecl: VAR_DEF identifier (COLON type)? ASSIGN expr;
setStmt: SET identifier (ASSIGN | PLUS_ASSIGN | MINUS_ASSIGN | MULTIPLY_ASSIGN | DIVIDE_ASSIGN) expr;
letDecl: LET identifier ASSIGN expr;

// Functions
functionDecl: FN identifier LPAREN parameters? RPAREN (COLON type)? ARROW expr;
parameters: parameter (COMMA parameter)*;
parameter: identifier COLON type;

// Control Flow
whileLoop: WHILE expr DO expr;
ifStmt: IF expr THEN expr (ELSE expr)?;
matchStmt: MATCH expr matchCase* (ELSE expr)?;
matchCase: WITH pattern THEN expr;
forLoop: FOR (LET)? identifier ASSIGN expr (TO | DOWNTO) expr (STEP expr)? DO expr;
forYield: FOR (LET)? identifier ASSIGN expr (TO | DOWNTO) expr (STEP expr)? YIELD expr;

// Exception handling
tryStmt: TRY expr catchClause* (THROWS identifier)?;
catchClause: CATCH identifier COLON type THEN expr;

// Patterns
pattern:
    literalPattern
    | typePattern
    | destructurePattern
    | guardPattern
    | wildcardPattern
    ;

literalPattern: literal;
typePattern: identifier COLON type;
destructurePattern:
    LBRACKET pattern (COMMA pattern)* (COMMA ELLIPSIS identifier)? RBRACKET
    | LBRACKET identifier COMMA ELLIPSIS identifier RBRACKET
    | plexPattern
    ;
plexPattern: identifier LBRACE (identifier (COMMA identifier)*)? RBRACE;
guardPattern: identifier GREATER_EQUAL expr | UNDERSCORE GREATER_EQUAL expr;
wildcardPattern: UNDERSCORE;

// Expressions
expr:
    ifExpr
    | matchExpr
    | forExpr
    | forYieldExpr
    | binaryExpr
    ;

ifExpr: IF expr THEN expr (ELSE expr)?;
matchExpr: MATCH expr matchCase* (ELSE expr)?;
forExpr: FOR (LET)? identifier ASSIGN expr (TO | DOWNTO) expr (STEP expr)? DO expr;
forYieldExpr: FOR (LET)? identifier ASSIGN expr (TO | DOWNTO) expr (STEP expr)? YIELD expr;

binaryExpr:
    unaryExpr
    | binaryExpr MULTIPLY binaryExpr
    | binaryExpr DIVIDE binaryExpr
    | binaryExpr MODULO binaryExpr
    | binaryExpr PLUS binaryExpr
    | binaryExpr MINUS binaryExpr
    | binaryExpr LEFT_SHIFT binaryExpr
    | binaryExpr RIGHT_SHIFT binaryExpr
    | binaryExpr LESS_THAN binaryExpr
    | binaryExpr LESS_EQUAL binaryExpr
    | binaryExpr GREATER_THAN binaryExpr
    | binaryExpr GREATER_EQUAL binaryExpr
    | binaryExpr EQUALS binaryExpr
    | binaryExpr NOT_EQUALS binaryExpr
    | binaryExpr REFERENCE_EQUALS binaryExpr
    | binaryExpr BITWISE_AND binaryExpr
    | binaryExpr BITWISE_XOR binaryExpr
    | binaryExpr BITWISE_OR binaryExpr
    | binaryExpr AND binaryExpr
    | binaryExpr OR binaryExpr
    ;

unaryExpr:
    NOT unaryExpr
    | MINUS unaryExpr
    | PLUS unaryExpr
    | BITWISE_NOT unaryExpr
    | postfixExpr
    ;

postfixExpr:
    primary
    | postfixExpr DOT identifier
    | postfixExpr DOT INTEGER
    | postfixExpr LPAREN arguments? RPAREN
    ;

primary:
    literal
    | identifier
    | THIS
    | LPAREN expr RPAREN
    | block
    ;

arguments: expr (COMMA expr)*;

// This rule is now unused since we handle operators directly in binaryExpr
// but kept for reference
operator:
    MULTIPLY | DIVIDE | MODULO
    | PLUS | MINUS
    | LEFT_SHIFT | RIGHT_SHIFT
    | LESS_THAN | LESS_EQUAL | GREATER_THAN | GREATER_EQUAL
    | EQUALS | NOT_EQUALS | REFERENCE_EQUALS
    | BITWISE_AND
    | BITWISE_XOR
    | BITWISE_OR
    | AND
    | OR
    ;

// Types
type:
    basicType
    | collectionType
    | tupleType
    | functionType
    | plexType
    ;

basicType: INT | INT8 | INT16 | INT64 | DEC | DEC32 | DEC64 | BOOL | TEXT | UNIT;

collectionType:
    SEQ LPAREN type RPAREN
    | SET LPAREN type RPAREN
    | MAP LPAREN type COMMA type RPAREN
    | LBRACKET type RBRACKET
    | LBRACE type RBRACE
    | COLON LBRACKET type RBRACKET
    | COLON LBRACE type RBRACE
    | COLON SEQ LPAREN type RPAREN
    | COLON SET LPAREN type RPAREN
    | COLON MAP LPAREN type COMMA type RPAREN
    ;

tupleType:
    LPAREN type (COMMA type)* RPAREN
    | COLON LPAREN type (COMMA type)* RPAREN
    | COLON TUPLE LPAREN type (COMMA type)* RPAREN
    ;
functionType: FN LPAREN (type (COMMA type)*)? RPAREN TYPE_ARROW type;
plexType: identifier | COLON identifier;

// Plexes
plexDecl: PLEX identifier (LPAREN parameters? RPAREN)? ARROW plexBody* END identifier;
plexBody: field | method;
field: (VAL_DEF | VAR_DEF) (PRIVATE | PUBLIC)? identifier COLON type ASSIGN expr;
method: (PRIVATE | PUBLIC)? functionDecl;

// Extensions
extensionDecl: EXTENSION type ARROW method* END EXTENSION;

// Literals
literal:
    INTEGER
    | DECIMAL
    | SCIENTIFIC
    | HEX_LITERAL
    | BIN_LITERAL
    | OCT_LITERAL
    | STRING
    | RAW_STRING
    | INTERPOLATED_STRING
    | RAW_NUMBER
    | RAW_TEXT
    | TRUE
    | FALSE
    | UNIT
    | collection
    ;

collection:
    tuple
    | sequence
    | set
    | map
    ;

tuple: LPAREN (expr (COMMA expr)* COMMA?)? RPAREN;
sequence: LBRACKET (expr (COMMA expr)* COMMA?)? RBRACKET;
set: LBRACE (expr (COMMA expr)* COMMA?)? RBRACE;
map: LBRACE mapEntry (COMMA mapEntry)* COMMA? RBRACE;

mapEntry: (identifier | STRING) ASSIGN expr;

// Identifiers
identifier: PLAIN_ID | RAW_ID;
