package instruction.impl;

import instruction.Instruction;

import java.util.HashMap;

public class BeginEndInstruction implements Instruction {
    private InstructionList instructions;

    public BeginEndInstruction(InstructionList instructions) {
        this.instructions = instructions;
    }

    public void run(HashMap<String, Object> hm) {
        instructions.run(hm);
    }
}

