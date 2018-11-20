import instruction.impl.InstructionList;

import java.io.*;
import java.util.*;

public class Main {

    private HashMap<String, Object> hm = new HashMap<>();
    private InstructionList instructionList;

    public Main(InstructionList instructionList) {
        this.instructionList = instructionList;
    }

    public void exec() {
        instructionList.run(hm);
    }

    public static void main(String args[]) {
        try {
            Parser p;
            if(args.length != 0) p = new Parser(new Lexer(new FileReader(args[0])));
//            if(args.length == 0) p = new Parser(new Lexer(new FileReader("assets/test.txt")));
            else {
                System.out.printf("Paiton 1.0.5 | Virtual Envaironment | (default %s)\n", new Date().toString());
                System.out.println("[GCC 4.2.1 Compatible Clang 4.0.1 (tags/RELEASE_401/final)] on darwin");
                System.out.println("Type \"read\" to read, \"write\" to print, or \"end\" to finish.");
                p = new Parser(new Lexer(new Interpreter()));
            }
            Object result = p.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}