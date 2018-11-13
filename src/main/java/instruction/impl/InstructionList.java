package instruction.impl;

import instruction.Instruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstructionList {
    private List<Instruction> instructions;

    public InstructionList(Instruction s) {
        instructions = new ArrayList<Instruction>();
        instructions.add(s);
    }

    public void add(Instruction s) {
        instructions.add(s);
    }

    public void run(HashMap<String, Object> hm) {
        for (Instruction si : instructions) {
            si.run(hm);
        }
    }
}

