import java_cup.runtime.*;
%%
%class Lexer
%line
%column
%cup
%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {


  System.out.println("Token: "+value+" linea: "+yyline+ " columna: "+yycolumn);
        return new Symbol(type, yyline, yycolumn, value);
    }

     private void error(String message) {
        System.out.println("Error at line "+(yyline+1)+", column "+(yycolumn+1)+" : "+message);
      }

    private void Semita(int a, int b){
        int c = a+b;
    }
    int asd=42;
%}
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
dec_int_lit = 0 | [1-9][0-9]*
dec_int_id = [A-Za-z_][A-Za-z_0-9]*
character = \'([^'])?\'
string = \'([^'])*\'
leftBracket = \{
rightBracket = \}
space = [ \n\t\r]
notBracket = [^}]|{space}
commentBody= {notBracket}*
comment = {leftBracket}{commentBody}{rightBracket}
%%
<YYINITIAL> {
    ";"                { return symbol(sym.SEMI , ";"); }
    ":"                { return symbol(sym.COLON, ":"); }
    "+"                {  return symbol(sym.PLUS , "+"); }
    "-"                {  return symbol(sym.MINUS , "-"); }
    "*"                {  return symbol(sym.TIMES , "+"); }
    "/"                {  return symbol(sym.DIVIDE , "/"); }
    "("                {  return symbol(sym.LPAREN , "("); }
    ")"                {  return symbol(sym.RPAREN , ")"); }
    "="                 { return symbol(sym.EQUALSEQUALS, "="); }
    ","                 { return symbol(sym.COMMA, ","); }
    "read"                 { return symbol(sym.READ , "read"); }
    "if"                { return symbol(sym.IF , "if"); }
    "else"              { return symbol(sym.ELSE ,"else"); }
    "{"                 { return symbol(sym.LCURLY ,"lcurly"); }
    "}"                 { return symbol(sym.RCURLY ,"rcurly"); }
    "goto"             { return symbol(sym.GOTO , "goto"); }
    "to"             { return symbol(sym.TO , "to"); }
    "$"                { return symbol(sym.EOF , "eof"); }
    "float"             { return symbol(sym.FLOAT , "float"); }
    "string"           { return symbol(sym.STRING, "string"); }
    ">"             { return symbol(sym.GREATERTHAN , ">"); }
    "<"             { return symbol(sym.LESSTHAN, "<"); }
    ">="             { return symbol(sym.GREATEROREQUALTHAN , ">="); }
    "<="             { return symbol(sym.LESSOREQUALTHAN ,"<=");}

    "&&"             { return symbol (sym.ANDOP ,"&&");}
    "||"             { return symbol (sym.OROP , "||");}
    "<>"             { return symbol(sym.NOTEQUALS, "<>"); }

    ":="             { return symbol(sym.ASSIGNATION, ":="); }
    "and"       {return symbol(sym.AND , "and");}
    "or"       {return symbol(sym.OR, "or");}
    "while"       {return symbol(sym.WHILE , "while");}
    "for"      {return symbol(sym.FOR ,"for");}
    "break"     {return symbol(sym.BREAK ,"break");}
    "integer"   {return symbol(sym.INTEGER ,"integer");}
    "char"   {return symbol(sym.CHAR ,"char");}
    "boolean"   {return symbol(sym.BOOLEAN, "boolean");}
    "["   {return symbol(sym.LBRACE, "(");}
    "]"   {return symbol(sym.RBRACE , ")");}
    "constchar"   {return symbol(sym.CONSTCHAR , "constchar");}
    "conststr"   {return symbol(sym.CONSTSTR ,"conststring");}
    "write"   {return symbol(sym.WRITE, "write");}
    "div"   {return symbol(sym.DIV , "div");}
    "mod"   {return symbol(sym.MOD , "mod");}
    "%"   {return symbol(sym.MODOP ,"%");}
    "var"   {return symbol(sym.VAR);}
    "begin"   {return symbol(sym.BEGIN , "begin");}
    "end"   {return symbol(sym.END ," end");}
    "function"   {return symbol(sym.FUNCTION , "function");}
    "then"   {return symbol(sym.THEN , "then");}
    "begin"   {return symbol(sym.BEGIN , "begin");}
    "end"   {return symbol(sym.END , "end");}
    "."  {return symbol(sym.DOT , ".");}
     "do"   {return symbol(sym.DO , "do");}
     "continue"   {return symbol(sym.CONTINUE ,"continue");}
     "until" {return symbol(sym.UNTIL , "until");}
     "repeat" {return symbol(sym.REPEAT ,"repeat");}
     "program" {return symbol(sym.PROGRAM, "program");}
      "procedure" {return symbol(sym.PROCEDURE ,"procedure");}
     "::=" {return symbol(sym.ASSIGMENT ,"::=");}


  {character}  {return symbol(sym.CHAR , "char");}

  {string} {return symbol(sym.lit_string ,"lit_string");}
  {comment} {return symbol(sym.COMMENT);}

    {dec_int_lit}      {
                         return symbol(sym.NUMBER, new Integer(yytext())); }
    {dec_int_id}       {
                         return symbol(sym.ID, yytext() );}
    {WhiteSpace}       { /* just skip what was found, do nothing */ }
}
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
