parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: stmts? EOF;
stmts: expr;

expr:
    exprHead;

exprHead:
    rawNumberBlock
    | rawNumberWord
    | textBlock
    | textWord
    | rawIdBlock
    | rawIdWord
    | decimal
    | integer
    | plainId;

rawNumberWord: HASH rawWord+ (DOT rawWord+)*;
rawNumberBlock: HASH rawBlock;
decimal: DIGIT+ DOT DIGIT+;
integer: DIGIT+;

textWord: DOUBLE_QUOTE rawWord+;
textBlock: DOUBLE_QUOTE rawBlock;

plainId: WORD rawWord*;
// TODO: Add more keywords
rawIdWord: BACK_QUOTE (IF | rawWord+);
rawIdBlock: BACK_QUOTE rawBlock;

rawWord: WORD | DIGIT;
rawBlock:
    LTUPLE ~RTUPLE* RTUPLE
    | LARRAY ~RARRAY* RARRAY
    | LSET ~RSET* RSET
    ;
