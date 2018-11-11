import java.io.*;

public class Main {
    public static void main(String[] args) {
        String dirName = null;

        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dir")) {
                    i++;
                    if (i >= args.length)
                        throw new Error("Missing directory name");
                    dirName = args[i];
                } else {
                    throw new Error(
                            "Usage: java Main -dir directory");
                }
            }
            if (dirName == null)
                throw new Error("Directory not specified");
            FileInputStream fileInputStream = new FileInputStream(
                    new File(dirName, "program.in"));
            System.setErr(new PrintStream(new FileOutputStream(
                    new File(dirName, "program.err"))));
            System.setOut(new PrintStream(new FileOutputStream(
                    new File(dirName, "program.out"))));
            Sentence lexer = new Sentence(new BufferedReader(fileInputStream));
            lexer.yylex();
        } catch (Exception exception) {
            System.err.println("Exception in Main " + exception.toString());
            exception.printStackTrace();
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
}
