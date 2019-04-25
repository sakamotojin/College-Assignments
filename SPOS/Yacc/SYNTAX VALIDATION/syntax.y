%{
#include <string.h>
#include <stdio.h>
void yyerror(char *);
int yylex();
%}
%token INT CHAR FLOAT ASS COMA ID  SC NUM STRIN NL REAL

%%
start : typ1 | typ2 | typ3
;
typ1 : INT  var1  SC NL{printf("integer");return 0;}
;
var1 : ID | ID  COMA  var1  |  ID  ASS  NUM  var1  
;
typ2 : CHAR var2 SC NL { printf("char \n"); return 0 ;}
;
var2 : ID | ID COMA var2 
;
typ3 : FLOAT var3 SC NL {printf("float \n"); return 0 ;}
;
var3 : ID | ID COMA var3 | ID ASS REAL |ID ASS REAL COMA var3 
;
%%
void yyerror(char *s)
{
  printf("error\n");
}
int main()
{
  yyparse();
}
