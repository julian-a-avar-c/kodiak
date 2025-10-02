lexer grammar KodiakLexer;

LTUPLE: '(';
RTUPLE: ')';
LARRAY: '[';
RARRAY: ']';
LSET: '{';
RSET: '}';

BACK_QUOTE: '`';
DOUBLE_QUOTE: '"';
DASH: '-';
HASH: '#';
DOT: '.';
QUESTION: '?';

EQ: '=';

BACKSLASH: '\\';

COMMA: ',';
SEMI: ';';
AT: '@';
COLON: ':';

// Comments
SINGLE_LINE_COMMENT: '{?}' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT: '{?' .*? '?}' -> skip;

// Whitespace
SPACE: ' ';
TAB: '\t';
RETURN: '\r';
NEW_LINE: '\n';

// 
DIGIT: [0-9];
WORD: .;
