%{
  FILE *yyin ;
  int ch=0 , word=0 , line =0;
%}
CHAR [a-zA-Z]
TEXT {CHAR}*
NL [\n]
S  [ ]
SP {S}+
%%
{TEXT} {printf("%s\t%d\n",yytext,yyleng); ch += yyleng ;word++;}
{NL} {line++;printf("\n\nline %d ends here \n\n ",line);}
{SP} {}

%%
int yywrap(void)
{
  return 1 ;
}
int main()
{
  yyin = fopen("a.txt","r");
  yylex();
  printf("%d  %d %d ",ch ,word , line );
  fclose(yyin);
  return 0 ;
}
