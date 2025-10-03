lexer grammar KodiakLexer;

// Comments
SINGLE_LINE_COMMENT:
	'{?}' ~[\r\n]*;
MULTI_LINE_COMMENT: '{?' .*? '?}';

// Simple literals
TRUE: 'true';
FALSE: 'false';
UNIT: 'unit';

// Keywords
FOR: 'for';
IF: 'if';
WHILE: 'while';
MATCH: 'match';
WITH: 'with';
THEN: 'then';
ELSE: 'else';
DO: 'do';
YIELD: 'yield';

END: 'end';
CASE: 'case';

VAL: 'val';
VAR: 'var';
SET: 'set';
LET: 'let';

FAT_ARROW: '=>';
THIN_ARROW: '->';

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

// Whitespace
SPACE: ' ';
TAB: '\t';
RETURN: '\r';
NEW_LINE: '\n';

//
DIGIT: [0-9]+;
WORD: (LETTER | SYMBOL)+;
fragment LETTER: [A-Za-z];
fragment SYMBOL: [~!%^&*_+=|<>/];
