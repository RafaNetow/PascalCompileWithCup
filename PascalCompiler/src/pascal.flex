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



          return new Symbol(type, yyline, yycolumn, value);
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
leftBracket = \{
rightBracket = \}
string = \'([^'])*\'
space = [ \n\t\r]
notBracket = [^}]|{space}
commentBody= {notBracket}*
comment = {leftBracket}{commentBody}{rightBracket}
%%
<YYINITIAL> {
     ","                { return symbol(sym.COMMA,  new SemanticSymbol(yycolumn, yyline)); }
    ":"                { return symbol(sym.COLON,  new SemanticSymbol(yycolumn, yyline)); }
  "var"   {return symbol(sym.VAR);}
    ";"                { return symbol(sym.SEMI, new SemanticSymbol(yycolumn, yyline)); }
   "const"                { return symbol(sym.CONST, new SemanticSymbol(yycolumn, yyline)); }
     "repeat"                { return symbol(sym.REPEAT, new SemanticSymbol(yycolumn, yyline)); }
      "until"                { return symbol(sym.UNTIL, new SemanticSymbol(yycolumn, yyline)); }

    "+"                {  return symbol(sym.PLUS, new SemanticSymbol(yycolumn, yyline)); }
      "type"                {  return symbol(sym.TYPE, new SemanticSymbol(yycolumn, yyline)); }
    "-"                {  return symbol(sym.MINUS, new SemanticSymbol(yycolumn, yyline)); }
    "*"                {  return symbol(sym.TIMES, new SemanticSymbol(yycolumn, yyline)); }
    "/"                {  return symbol(sym.DIVIDE, new SemanticSymbol(yycolumn, yyline)); }
    "true"                {  return symbol(sym.TRUE, new SemanticSymbol(yycolumn, yyline)); }
    "false"                {  return symbol(sym.FALSE, new SemanticSymbol(yycolumn, yyline)); }
    "("                {  return symbol(sym.LPAREN, new SemanticSymbol(yycolumn, yyline)); }
    ")"                {  return symbol(sym.RPAREN, new SemanticSymbol(yycolumn, yyline)); }
    ":="                 { return symbol(sym.ASSIGMENT, new SemanticSymbol(yycolumn, yyline)); }
    "scanf"                 { return symbol(sym.SCANF, new SemanticSymbol(yycolumn, yyline)); }
    "if"                { return symbol(sym.IF, new SemanticSymbol(yycolumn, yyline)); }
    "else"              { return symbol(sym.ELSE, new SemanticSymbol(yycolumn, yyline)); }
    "{"                 { return symbol(sym.LCURLY, new SemanticSymbol(yycolumn, yyline)); }
    "}"                 { return symbol(sym.RCURLY, new SemanticSymbol(yycolumn, yyline)); }
    "while"             { return symbol(sym.WHILE, new SemanticSymbol(yycolumn, yyline)); }
    "for"             { return symbol(sym.FOR, new SemanticSymbol(yycolumn, yyline)); }
    "to"             { return symbol(sym.TO, new SemanticSymbol(yycolumn, yyline)); }
    "integer"             { return symbol(sym.INTEGER, new SemanticSymbol(yycolumn, yyline)); }
    "char"             { return symbol(sym.CHAR, new SemanticSymbol(yycolumn, yyline)); }
    "float"             { return symbol(sym.FLOAT, new SemanticSymbol(yycolumn, yyline)); }
    "string"             { return symbol(sym.STRING, new SemanticSymbol(yycolumn, yyline)); }
    "procedure"             { return symbol(sym.PROCEDURE, new SemanticSymbol(yycolumn, yyline) ); }
     "boolean"             { return symbol(sym.BOOLEAN); }
    "of"            {return symbol(sym.OF, new SemanticSymbol(yycolumn, yyline));}
    "array"         {return symbol(sym.ARRAY, new SemanticSymbol(yycolumn, yyline));}
    ".."         {return symbol(sym.RANGE, new SemanticSymbol(yycolumn, yyline));}
    "["             {return symbol(sym.LBRACK, new SemanticSymbol(yycolumn, yyline));}
    "]"             {return symbol(sym.RBRACK, new SemanticSymbol(yycolumn, yyline));}
    ">"             { return symbol(sym.GREATERTHAN, new SemanticSymbol(yycolumn, yyline)); }
    "do"             { return symbol(sym.DO, new SemanticSymbol(yycolumn, yyline)); }
    "function"             { return symbol(sym.FUNCTION, new SemanticSymbol(yycolumn, yyline)); }
     "."  {return symbol(sym.DOT , new SemanticSymbol(yycolumn, yyline));}
    "begin"  {return symbol(sym.BEGIN, new SemanticSymbol(yycolumn, yyline));}
    "end"  {return symbol(sym.END ,  new SemanticSymbol(yycolumn, yyline));}
    "then"  {return symbol(sym.THEN ,  new SemanticSymbol(yycolumn, yyline));}
    ""  {return symbol(sym.THEN ,  new SemanticSymbol(yycolumn, yyline));}
    "<"             { return symbol(sym.LESSTHAN, new SemanticSymbol(yycolumn, yyline)); }
    ">="             { return symbol(sym.GREATEROREQUALTHAN, new SemanticSymbol(yycolumn, yyline)); }
    "<="             { return symbol(sym.LESSOREQUALTHAN, new SemanticSymbol(yycolumn, yyline)); }
    "=="             { return symbol(sym.EQUALSEQUALS, new SemanticSymbol(yycolumn, yyline)); }
    "program"             { return symbol(sym.PROGRAM, new SemanticSymbol(yycolumn, yyline)); }
    {character}  {return symbol(sym.LIT_CHAR , new SemanticSymbol(yycolumn, yyline));}
    {comment} {return symbol(sym.COMMENT);}
    {string} {return symbol(sym.LIT_STRING , yytext());}
    "!="             { return symbol(sym.NOTEQUALS, new SemanticSymbol(yycolumn, yyline)); }
    "="             { return symbol(sym.EQUAL, new SemanticSymbol(yycolumn, yyline)); }
    {dec_int_lit}      { 
                         return symbol(sym.NUMBER, new Integer(yytext())); }
    {dec_int_id}       { 
                         return symbol(sym.ID, yytext() );}
    {WhiteSpace}       { /* just skip what was found, do nothing */ }   
}
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }
