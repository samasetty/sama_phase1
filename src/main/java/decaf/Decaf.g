grammar Decaf;

/* 
  ======================
  Parser (Non-Terminal) Rules
  ======================
*/

/**
 * program -> importDecl* fieldDecl* methodDecl*
 */
program
    : importDecl* fieldDecl* methodDecl* EOF
    ;

/** importDecl -> 'import' id ';' */
importDecl
    : IMPORT id SEMI
    ;

/**
 * fieldDecl -> type fieldItem (',' fieldItem)* ';'
 * fieldItem -> id | id '[' INTLITERAL ']'
 */
fieldDecl
    : type fieldItem (COMMA fieldItem)* SEMI
    ;

fieldItem
    : id
    | id LBRACK INTLITERAL RBRACK
    ;

/**
 * methodDecl -> (type | 'void') id '(' [ param (',' param)* ] ')' block
 */
methodDecl
    : (type | VOID) id LPAREN (param (COMMA param)*)? RPAREN block
    ;

param
    : type id
    ;

/**
 * block -> '{' fieldDecl* statement* '}'
 */
block
    : LBRACE fieldDecl* statement* RBRACE
    ;

/**
 * type -> 'int' | 'long' | 'bool'
 */
type
    : INT
    | LONG
    | BOOL
    ;

/**
 * statement -> 
 *    location assignExpr ';'
 *  | methodCall ';'
 *  | if '(' expr ')' block else block
 *  | for '(' id '=' expr ';' expr ';' forUpdate ')' block
 *  | while '(' expr ')' block
 *  | return expr? ';'
 *  | break ';'
 *  | continue ';'
 */
statement
    : location assignExpr SEMI
    | methodCall SEMI
    | IF LPAREN expr RPAREN block (ELSE block)?   // else is optional now
    | FOR LPAREN id EQUAL expr SEMI expr SEMI forUpdate RPAREN block
    | WHILE LPAREN expr RPAREN block
    | RETURN expr? SEMI
    | BREAK SEMI
    | CONTINUE SEMI
    ;

/** forUpdate -> location assignExpr */
forUpdate
    : location assignExpr
    ;

/** assignExpr -> assignOp expr | increment */
assignExpr
    : assignOp expr
    | increment
    ;

/** assignOp -> = | += | -= | *= | /= | %= */
assignOp
    : EQUAL
    | PLUS_EQ
    | MINUS_EQ
    | STAR_EQ
    | SLASH_EQ
    | PERCENT_EQ
    ;

/** increment -> ++ | -- */
increment
    : PLUS_PLUS
    | MINUS_MINUS
    ;

/**
 * methodCall -> methodName '(' [ callArgs ] ')'
 * callArgs -> callArg (',' callArg)*
 * callArg -> expr | STRINGLITERAL
 */
methodCall
    : methodName LPAREN callArgs? RPAREN
    ;

callArgs
    : callArg (COMMA callArg)*
    ;

callArg
    : expr
    | STRINGLITERAL
    ;

/** methodName -> id */
methodName
    : id
    ;

/**
 * location -> id | id '[' expr ']'
 */
location
    : id
    | id LBRACK expr RBRACK
    ;

/**
 * expr -> 
 *   location
 * | methodCall
 * | literal
 * | 'int' '(' expr ')' 
 * | 'long' '(' expr ')' 
 * | 'len' '(' id ')' 
 * | expr binOp expr
 * | '-' expr
 * | '!' expr
 * | '(' expr ')'
 */
expr
    : location
    | methodCall
    | literal
    | INT LPAREN expr RPAREN
    | LONG LPAREN expr RPAREN
    | LEN LPAREN id RPAREN
    | expr binOp expr
    | MINUS expr
    | BANG expr
    | LPAREN expr RPAREN
    ;

/**
 * binOp -> + | - | * | / | % | < | > | <= | >= | == | != | && | ||
 */
binOp
    : PLUS
    | MINUS
    | STAR
    | SLASH
    | PERCENT
    | LESS
    | GREATER
    | LESS_EQ
    | GREATER_EQ
    | EQUAL_EQ
    | BANG_EQ
    | AND_AND
    | OR_OR
    ;

/**
 * literal -> '-' INTLITERAL | LONGLITERAL | CHARLITERAL | ( 'true' | 'false' )
 */
literal
    : MINUS INTLITERAL
+   | INTLITERAL
    | LONGLITERAL
    | CHARLITERAL
    | TRUE
    | FALSE
    ;

/** id -> IDENTIFIER */
id
    : IDENTIFIER
    ;

/* 
  ======================
  Lexer (Terminal) Rules
  ======================
*/

/** Keywords in lowercase */
IF         : 'if'       ;
BOOL       : 'bool'     ;
BREAK      : 'break'    ;
IMPORT     : 'import'   ;
CONTINUE   : 'continue' ;
ELSE       : 'else'     ;
FALSE      : 'false'    ;
FOR        : 'for'      ;
WHILE      : 'while'    ;
INT        : 'int'      ;
LONG       : 'long'     ;
RETURN     : 'return'   ;
LEN        : 'len'      ;
TRUE       : 'true'     ;
VOID       : 'void'     ;

/** Operators/punctuation */
PLUS       : '+' ;
MINUS      : '-' ;
STAR       : '*' ;
SLASH      : '/' ;
PERCENT    : '%' ;

EQUAL      : '=' ;
PLUS_EQ    : '+=' ;
MINUS_EQ   : '-=' ;
STAR_EQ    : '*=' ;
SLASH_EQ   : '/=' ;
PERCENT_EQ : '%=' ;

EQUAL_EQ   : '==' ;
BANG_EQ    : '!=' ;
GREATER    : '>' ;
GREATER_EQ : '>=' ;
LESS       : '<' ;
LESS_EQ    : '<=' ;

AND_AND    : '&&' ;
OR_OR      : '||' ;
BANG       : '!'  ;
PLUS_PLUS  : '++' ;
MINUS_MINUS: '--' ;

LPAREN     : '(' ;
RPAREN     : ')' ;
LBRACE     : '{' ;
RBRACE     : '}' ;
LBRACK     : '[' ;
RBRACK     : ']' ;
SEMI       : ';' ;
COMMA      : ',' ;

/**
 * Identifiers
 */
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

/**
 * intLiteral => decimalLiteral or hexLiteral
 */
INTLITERAL
    : DECIMAL_LITERAL
    | HEX_LITERAL
    ;

/** longLiteral => decimalLiteral|hexLiteral followed by 'L' */
LONGLITERAL
    : DECIMAL_LITERAL 'L'
    | HEX_LITERAL 'L'
    ;

/** decimal => 1+ digits */
fragment DECIMAL_LITERAL
    : [0-9]+
    ;

/** hex => '0x' + [0-9a-fA-F]+ */
fragment HEX_LITERAL
    : '0x' [0-9a-fA-F]+
    ;

/** charLiteral => ' aChar ' */
CHARLITERAL
    : '\'' CHAR_CONTENT '\''
    ;

/** stringLiteral => "stuff" */
STRINGLITERAL
    : '"' ( STRING_CONTENT )* '"'
    ;

fragment CHAR_CONTENT
    // allow escapes or a single non-quote/backslash character
    : '\\' [btnrf"'\\]
    | ~[\\'\r\n]
    ;

fragment STRING_CONTENT
    : '\\' [btnrf"'\\]
    | ~[\\"\r\n]
    ;

/** Whitespace + comments => skip */
WS
    : [ \t\r\n\f]+ -> skip
    ;

/** Line comments: // ... up to line break */
LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT 
    : '/*' .*? '*/' -> skip
    ;