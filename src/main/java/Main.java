import java_cup.parser;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            parser p = new parser(new Lexer(new FileReader("/assets/test.txt")));
            Object result = p.parse().value;
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }

    // STEPS

    // LEXICAL ANALYSIS:
    // Decompose source into tokens (identifiers, reserved words) Tipically skipping whitespaces
        /*
        Example: if this is the code ->


        if (x >= 13) { // a comment
            sum = sum + x
        }

        the tokens would be these: if, (, x, >=, 13, ), {, sum, =, sum, +, x, }
         */

    // Errors: Token not defined


    // SYNTACTIC ANALYSIS

    // Takes the token produced from the lexical analysis and produces a parse tree or syntax tree.
    // In this step it's checked whether the expression made by the tokens is correct.

    // Errors: Syntax error ->


    // SEMANTIC ANALYSIS

    // Graph

    // This step checks whether the tree makes sense. This means checking that the assignments
    // are the correct types, that operations are not made between incompatible types, if identifiers
    // are being used before declaration or not, etc

    // Define operations

    // CODE EXECUTION -> Create a stack
}