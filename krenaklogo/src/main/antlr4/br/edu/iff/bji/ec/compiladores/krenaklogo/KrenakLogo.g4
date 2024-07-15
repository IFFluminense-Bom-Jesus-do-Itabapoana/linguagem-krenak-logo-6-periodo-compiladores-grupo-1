grammar KrenakLogo;

prog
    : (line? EOL)+ line? EOF
    ;

line
    : cmd+ comment?
    | comment
    | print_ comment?
    | procedureDeclaration
    ;

cmd
    : repeat_
    | fd
    | bk
    | rt
    | lt
    | cs
    | pu
    | pd
    | ht
    | st
    | home
    | label
    | setxy
    | make
    | procedureInvocation
    | ife
    | stop
    | fore
    ;

procedureInvocation
    : name expression*
    ;

procedureDeclaration
    : 'tupü' name parameterDeclarations* EOL? (line? EOL)+ 'ak'
    ;

parameterDeclarations
    : ':' name (',' parameterDeclarations)*
    ;

func_
    : random
    ;

repeat_
    : 'repeat' number block
    ;

block
    : '[' cmd+ ']'
    ;

ife
    : 'if' comparison block
    ;

comparison
    : expression comparisonOperator expression
    ;

comparisonOperator
    : '<'
    | '>'
    | '='
    ;

make
    : 'intschom' STRINGLITERAL value
    ;

print_
    : 'pip' (value | quotedstring)
    ;

quotedstring
    : '[' (quotedstring | ~ ']')* ']'
    ;

name
    : STRING
    ;

value
    : STRINGLITERAL
    | expression
    | deref
    ;

signExpression
    : (('+' | '-'))* (number | deref | func_)
    ;

multiplyingExpression
    : signExpression (('*' | '/') signExpression)*
    ;

expression
    : multiplyingExpression (('+' | '-') multiplyingExpression)*
    ;

deref
    : ':' name
    ;

fd
    : ('fd' | 'forward') expression
    ;

bk
    : ('bk' | 'backward') expression
    ;

rt
    : ('rt' | 'right') expression
    ;

lt
    : ('lt' | 'mokia') expression
    ;

cs
    : 'cs'
    | 'clearscreen'
    ;

pu
    : 'pu'
    | 'penup'
    ;

pd
    : 'pd'
    | 'pendown'
    ;

ht
    : 'ht'
    | 'hideturtle'
    ;

st
    : 'st'
    | 'showturtle'
    ;

home
    : 'home'
    ;

stop
    : 'stop'
    ;

label
    : 'label'
    ;

setxy
    : 'setxy' expression expression
    ;

random
    : 'random' expression
    ;

fore
    : 'for' '[' name expression expression expression ']' block
    ;

number
    : NUMBER
    ;

comment
    : COMMENT
    ;

STRINGLITERAL
    : '"' ( ~["\\] | '\\' . )* '"'
    ;

STRING
    : [a-zA-Z] [a-zA-Z0-9_]*
    ;

NUMBER
    : [0-9]+
    ;

COMMENT
    : ';' ~ [\r\n]*
    ;

EOL
    : '\r'? '\n'
    ;

WS
    : [ \t\r\n] -> skip
    ;