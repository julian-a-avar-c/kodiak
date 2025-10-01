lexer grammar KodiakLexer;

LTUPLE: '(';
RTUPLE: ')';
LARRAY: '[';
RARRAY: ']';
LSET: '{';
RSET: '}';
END: 'end';

VAL: 'val';
VAR: 'var';
SET: 'set';
LET: 'let';
FN: 'fn';

IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
FOR: 'for';
YIELD: 'yield';
MATCH: 'match';
WITH: 'with';

THROWS: 'throws';
TRY: 'try';
CATCH: 'catch';

CLASS: 'class';
THIS: 'this';
SUPER: 'super';
EXTENSION: 'extension';

PRIVATE: 'private';
PROTECTED: 'protected';
PUBLIC: 'public';

BACK_QUOTE: '`';
DOUBLE_QUOTE: '"';
SINGLE_QUOTE: '\'';

EQ: '=';
LT: '<';
GT: '>';

TIMES: '*';
SLASH: '/';
PLUS: '+';
DASH: '-';

BACKSLASH: '\\';

SEMI: ';';
AT: '@';
HASH: '#';
COLON: ':';
COMMA: ',';
DOT: '.';

TILDE: '~';
BANG: '!';
DOLLAR: '$';
MOD: '%';
HAT: '^';
AMP: '&';
UNDER: '_';
PIPE: '|';
QUESTION: '?';

// Literals
TRUE: 'true';
FALSE: 'false';
UNIT: 'unit';

// Comments
SINGLE_LINE_COMMENT: '{?}' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT: '{?' .*? '?}' -> skip;

// Whitespace
SL: [ \t];
NL: [\r\n];

//
DIGIT: [0-9];
WORD: ~[ \t\r\n()[\]{},;.#"];
