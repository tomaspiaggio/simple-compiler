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
        try {
            Parser p = new Parser(new Lexer(new FileReader("assets/test.txt")));
            Object result = p.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
