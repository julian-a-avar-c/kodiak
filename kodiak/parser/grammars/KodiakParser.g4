parser grammar KodiakParser;

options {
	tokenVocab = KodiakLexer;
}

// Program Structure
program: stmts? EOF;
stmts: expr (stmtSep+ expr)*;
stmtSep: SEMI;

expr:
    exprHead;

exprHead:
    rawNumberBlock
    | rawNumberWord
    | textBlock
    | textWord
    | rawIdBlock rawIdTail?
    | rawIdWord rawIdTail?
    | decimal
    | integer
    | plainId;

rawIdTail: rawNumberBlock | rawNumberWord | textBlock | textWord;

rawNumberWord: HASH rawWord+ (DOT rawWord+)*;
rawNumberBlock: HASH rawBlock;
decimal: DASH? DIGIT+ DOT DIGIT+;
integer: DASH? DIGIT+;

textWord: DOUBLE_QUOTE rawWord+;
textBlock: DOUBLE_QUOTE rawBlock;

plainId: WORD rawWord*;
// TODO: Add more keywords
rawIdWord: BACK_QUOTE (IF | rawWord+);
rawIdBlock: BACK_QUOTE rawBlock;

rawWord: WORD | DIGIT | DASH;
rawBlock:
    LTUPLE ~RTUPLE* RTUPLE
    | LARRAY ~RARRAY* RARRAY
    | LSET ~RSET* RSET
    ;
