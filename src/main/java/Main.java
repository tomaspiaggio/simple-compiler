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

    public static void main(String argv[]) {
//        try {
////            Parser p = new Parser(new Lexer(new FileReader("assets/test.txt")));
//            System.out.printf("Paiton 1.0.5 | Virtual Envaironment | (default %s)\n", new Date().toString());
//            System.out.println("[GCC 4.2.1 Compatible Clang 4.0.1 (tags/RELEASE_401/final)] on darwin");
//            System.out.println("Type \"readstr\" or \"readint\" to read, \"write\" to print, or \"end\" to finish.");
//            Parser p = new Parser(new Lexer(new FileReader("assets/test.txt")));
////            Parser p = new Parser(new Lexer(new Interpreter()));
//            Object result = p.parse().value;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

class Interpreter extends Reader {

    private Reader reader;

    Interpreter() {
        this.reader = new StringReader("begin");
    }

    @Override
    public int read(char cbuf[], int off, int len) throws IOException {
        int result = reader.read(cbuf, off, len);
        if(result >= 0) return result;
        else reader = askInput();
        return reader.read(cbuf, off, len);
    }

    private Reader askInput() {
        System.out.print(">>> ");
        Scanner s = new Scanner(System.in);
        return new StringReader("\n\t" + s.next());
    }

    @Override
    public void close() throws IOException {
    }
}