%{
  FILE *yyin;
%}
KEYWORDS "class"|"static"|"main"
ACCESS "public"|"protected"|"private"
DIGIT [0-9]
NUMBER {DIGIT}+
CHAR [A-Za-z]
TEXT {CHAR}+
DATATYPE "int"|"float"|"String"|"boolean"|"double"|"void"
IMPORT "import"[^\n]*";"
CONDITIONAl "if"|"else"|"else if"
ITERATIVE  "for("[^\n]*")"|"while("[^\n]*")"
IDENTIFIER {TEXT}|({DIGIT}|{TEXT}|"_")*
SC ";"
BRACES "{"|"}"|"("|")"
%%
{KEYWORDS} {printf("KEYWORD %s\n",yytext);}
{ACCESS} {printf("ACESS %s\n",yytext);}
{DATATYPE} {printf("DATATYPE  %s\n",yytext);}
{IMPORT} {printf("IMPORT  %s\n",yytext);}
{ITERATIVE} {printf("ITERATIVE  %s\n",yytext);}
{IDENTIFIER} {printf("Identifier  %s\n",yytext);}
{BRACES} {printf("BRACES %s \n",yytext);}
%%
int yywrap()
{
  return 1 ;
}
int main()
{
  yyin = fopen("a.java","r");
  yylex();
  return 0 ;
}
