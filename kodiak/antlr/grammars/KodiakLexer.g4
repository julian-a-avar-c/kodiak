lexer grammar KodiakLexer;

// Keywords
VAL_DEF: 'val';
VAR_DEF: 'var';
SET: 'set';
LET: 'let';
FN: 'fn';
IF: 'if';
THEN: 'then';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
FOR: 'for';
TO: 'to';
DOWNTO: 'downto';
STEP: 'step';
YIELD: 'yield';
MATCH: 'match';
WITH: 'with';
PLEX: 'plex';
END: 'end';
EXTENSION: 'extension';
PRIVATE: 'private';
PUBLIC: 'public';
TRY: 'try';
CATCH: 'catch';
THROWS: 'throws';
THIS: 'this';
TRUE: 'true';
FALSE: 'false';
UNIT: 'unit';

// Basic Types
INT: 'int';
INT8: 'int8';
INT16: 'int16';
INT64: 'int64';
DEC: 'dec';
DEC32: 'dec32';
DEC64: 'dec64';
BOOL: 'bool';
TEXT: 'text';
SEQ: 'seq';
TUPLE: 'tuple';
MAP: 'map';

// Operators
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODULO: '%';
ASSIGN: '=';
EQUALS: '==';
NOT_EQUALS: '!=';
LESS_THAN: '<';
LESS_EQUAL: '<=';
GREATER_THAN: '>';
GREATER_EQUAL: '>=';
REFERENCE_EQUALS: '===';
AND: '&&';
OR: '||';
NOT: '!';
BITWISE_AND: '&';
BITWISE_OR: '|';
BITWISE_XOR: '^';
BITWISE_NOT: '~';
LEFT_SHIFT: '<<';
RIGHT_SHIFT: '>>';
ARROW: '=>';
TYPE_ARROW: '->';
QUESTION: '?';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MULTIPLY_ASSIGN: '*=';
DIVIDE_ASSIGN: '/=';

// Delimiters
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';
SEMICOLON: ';';
COLON: ':';
DOT: '.';
HASH: '#';
BACKTICK: '`';
DOUBLE_QUOTE: '"';
UNDERSCORE: '_';
ELLIPSIS: '..';
INTERPOLATION_START: '${';

// Literals
INTEGER: DIGIT+ ('i' DIGIT+)?;
DECIMAL: DIGIT+ '.' DIGIT+ ('d' DIGIT+)?;
SCIENTIFIC: DIGIT+ ('.' DIGIT+)? [eE] [+-]? DIGIT+;

// Hexadecimal, Binary, Octal literals
HEX_LITERAL: [xX] '#' [0-9a-fA-F]+;
BIN_LITERAL: [bB] '#' [01]+;
OCT_LITERAL: [oO] '#' [0-7]+;

// String literals
STRING: '"' (~["\r\n\\] | '\\' .)* '"';
RAW_STRING: 'r"' (~["] | '\\' '"')* '"';
INTERPOLATED_STRING: '"[' (~["] | '\\' .)* ']"';

// Identifiers
PLAIN_ID: (LETTER | '_') (LETTER | DIGIT | '_' | '-')*;
RAW_ID: '`' (~[`\r\n])+ '`';
RAW_NUMBER: PLAIN_ID '#' (~[ \t\r\n()[\]{},;."`#])+;
RAW_TEXT: PLAIN_ID '"' (~["\r\n\\] | '\\' .)* '"';

// Comments
SINGLE_LINE_COMMENT: '{?}' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT: '{?' .*? '?}' -> skip;

// Whitespace
WS: [ \t]+ -> skip;
NL: [\r\n]+;

// Character classes
fragment LETTER: [a-zA-Z] | [\u00C0-\u00FF] | [\u0100-\u017F] | [\u0180-\u024F];
fragment DIGIT: [0-9];
