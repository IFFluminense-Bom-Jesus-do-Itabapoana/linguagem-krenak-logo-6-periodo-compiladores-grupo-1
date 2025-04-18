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
    : 'intai' number block
    ;

block
    : '[' cmd+ ']'
    ;

ife
    : 'huk' comparison block
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
    : ('mg' | 'mrong') expression
    ;

bk
    : ('at' | 'anthore') expression
    ;

rt
    : ('nk' | 'nikuanin') expression
    ;

lt
    : ('mk' | 'mokia') expression
    ;

cs
    : 'kr'
    | 'kurim'
    ;

pu
    : 'pb'
    | 'po tu um bakui'
    ;

pd
    : 'ph'
    | 'po tu um hek hek'
    ;

ht
    : 'hh'
    | 'hion-hinkut'
    ;

st
    : 'kh'
    | 'kanhinkut'
    ;

home
    : 'kischem'
    ;

stop
    : 'jan'
    ;

label
    : 'kanhun'
    ;

setxy
    : 'iopu' expression expression
    ;

random
    : 'krahiimakuan' expression
    ;

fore
    : 'himpa' '[' name expression expression expression ']' block
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