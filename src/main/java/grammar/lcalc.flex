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

    private Object parseNumber(String o) {
        if(o.matches("[0-9]+.[0-9]+")) return new Double(o);
        return new Integer(o);
    }

    private Symbol numberSymbol(Object value) {
        if(value instanceof Integer) return symbol(sym.DOUBLE, value);
        return symbol(sym.INT, value);
    }
%}


LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

UNUMBER = [0-9]+.[0-9]+ | [0-9]+
NUMBER = [-+]{UNUMBER} | {UNUMBER}
IDENT = [A-Za-z_][A-Za-z_0-9]*
STRING = \"([^\\\"]|\\.)*\"
ID = [a-zA-Z][a-zA-Z_0-9]*

%%

<YYINITIAL> {

    /** Keywords. */
    "and"             { return symbol(sym.AND); }
    "or"              { return symbol(sym.OR); }
    "not"             { return symbol(sym.NOT); }
    "true"            { return symbol(sym.TRUE); }
    "false"           { return symbol(sym.FALSE); }

    "begin"           { return symbol(sym.BEGIN); }
    "end"             { return symbol(sym.END); }
    "exit"            { return symbol(sym.EXIT); }
    "if"              { return symbol(sym.IF); }
    "then"            { return symbol(sym.THEN); }
    "else"            { return symbol(sym.ELSE); }

    "write"           { return symbol(sym.WRITE); }
    "read"            { return symbol(sym.READ); }

    "=="              { return symbol(sym.EQ); }
    "="               {return symbol(sym.ASSIGN); }
    "<"               { return symbol(sym.LT); }
    "<="              { return symbol(sym.LE); }
    ">"               { return symbol(sym.GT); }
    ">="              { return symbol(sym.GE); }
    "!="              { return symbol(sym.NE); }

    ";"                { return symbol(sym.SEMI); }
    "("                { return symbol(sym.LPAREN); }
    ")"                { return symbol(sym.RPAREN); }
    "+"                { return symbol(sym.PLUS); }
    "-"                { return symbol(sym.MINUS); }
    "*"                { return symbol(sym.TIMES); }
    "%"                { return symbol(sym.MODE);  }
    "/"                { return symbol(sym.DIVIDE); }

    {NUMBER}      { return numberSymbol(parseNumber(yytext())); }
    {STRING}      { return symbol(sym.STRING, new String(yytext())); }
    {ID}          { return symbol(sym.ID, new String(yytext())); }

    {WhiteSpace}       { /* do nothing */ }
    <<EOF>> { return symbol(sym.EOF); }
}


/* error */
[^]                    { throw new Error("Illegal character <"+yytext()+">"); }