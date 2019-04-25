%{
#include <stdio.h>
#include "y.tab.h"
%}
DIGIT [0-9]
REAL {DIGIT}+[.]{DIGIT}*
NUM {DIGIT}+
SC ";"
ASS "="
COMA ","
INTEGER "int"
CHAR     "char"
FLOAT   "float"
STRIN  "String"
ID [a-zA-Z]+[a-zA-z0-9_]*
NL [\n]
%%
{NUM} {printf("NUM\n");return (NUM);}
{REAL} {printf("Real \n"); return (REAL);}
{INTEGER} {printf("INTEGER\n");return (INT);}
{CHAR} {printf("CHAR\n");return (CHAR);}
{FLOAT} {printf("FLOAT\n");return (FLOAT);}
{STRIN} { printf("STRIN\n");return (STRIN);}
{ASS} {printf("ASS\n");return (ASS);}
{COMA} {return (COMA);}
{ID} {printf("ID\n");return (ID);}
{SC} {printf("SC\n");return (SC);}
{NL} {printf("NL\n");return (NL);}
%%
int yywrap()
{
return 1 ;
}
