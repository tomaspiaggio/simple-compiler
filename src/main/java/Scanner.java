import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class scanner {

    /* single lookahead character */
    protected static int nextChar;

    /* we use a SymbolFactory to generate Symbols */
    private SymbolFactory sf = new DefaultSymbolFactory();

    /* advance input by one character */
    protected static void advance() throws java.io.IOException {
        System.out.print("> ");
        nextChar = System.in.read();
    }

    /* initialize the Scanner */
    public static void init() throws java.io.IOException {
        advance();
    }

    /* recognize and return the next complete token */
    public Symbol next_token() throws java.io.IOException {
        for (; ; )
            switch (nextChar) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    /* parse a decimal integer */
                    int iVal = 0;
                    do {
                        iVal = iVal * 10 + (nextChar - '0');
                        advance();
                    } while (nextChar >= '0' && nextChar <= '9');
                    return sf.newSymbol("NUMBER", sym.NUMBER, new Integer(iVal));

                case ';':
                    advance();
                    return sf.newSymbol("SEMI", sym.SEMI);
                case '+':
                    advance();
                    return sf.newSymbol("PLUS", sym.PLUS);
                case '-':
                    advance();
                    return sf.newSymbol("MINUS", sym.MINUS);
                case '/':
                    advance();
                    return sf.newSymbol("DIVIDE", sym.DIVIDE);
                case '*':
                    advance();
                    return sf.newSymbol("TIMES", sym.TIMES);
                case '(':
                    advance();
                    return sf.newSymbol("LPAREN", sym.LPAREN);
                case ')':
                    advance();
                    return sf.newSymbol("RPAREN", sym.RPAREN);

                case -1:
                    return sf.newSymbol("EOF", sym.EOF);

                default:
                    /* in this simple Scanner we just ignore everything else */
                    advance();
                    break;
            }
    }
}
