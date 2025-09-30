lexer grammar KodiakLexer;

LTUPLE: '(';
RTUPLE: ')';
LARRAY: '[';
RARRAY: ']';
LSET: '{';
RSET: '}';
END: 'end';
NOT_RTUPLE: ~')';
NOT_RARRAY: ~']';
NOT_RSET: ~'}';

LTTEXT: '"(';
LATEXT: '"[';
LSTEXT: '"{';
LTID: '`(';
LAID: '`[';
LSID: '`{';
LTNUMBER: '#(';
LANUMBER: '#[';
LSNUMBER: '#{';

RTEQOP: '=)';
RAEQOP: '=]';
RSEQOP: '=}';
NOT_RTEQOP: ~[=)];
NOT_RAEQOP: ~[=\]];
NOT_RSEQOP: ~[=}];

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

TILDE: '~';
BANG: '!';
AT: '@';
HASH: '#';
DOLLAR: '$';
MOD: '%';
HAT: '^';
AMP: '&';
UNDER: '_';
PIPE: '|';
SEMI: ';';
COLON: ':';
COMMA: ',';
DOT: '.';
QUESTION: '?';

// Literals
TRUE: 'true';
FALSE: 'false';
UNIT: 'unit';

// Comments
SINGLE_LINE_COMMENT: '{?}' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT: '{?' .*? '?}' -> skip;

// Whitespace 
WS: [ \t\r\n]+ -> channel(HIDDEN);
SL: [ \t]+ -> channel(HIDDEN);
NL: [\r\n]+ -> channel(HIDDEN);
STMT_WS: // Whitespace with 1 optional NL
    ( [ \t]+ ([\r\n] [ \t]*)?
    | ([ \t]* [\r\n])? [ \t]+ 
    | [\r\n]
    ) -> channel(HIDDEN);

// 
ID_WORD: ~[0-9 \t\r\n()[\]{},;.#"];
WORD: ~[ \t\r\n()[\]{},;.#"];
NON_WORD: [ \t\r\n()[\]{},;.#"];
DIGIT: [0-9];