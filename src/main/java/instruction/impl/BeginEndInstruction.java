package instruction.impl;

import instruction.SimpleInstruction;

import java.util.HashMap;

public class BeginEndInstruction implements SimpleInstruction {
    private InstructionList instructions;

    public BeginEndInstruction(InstructionList instructions) {
        this.instructions = instructions;
    }

    public void run(HashMap<String, Object> hm) {
        instructions.run(hm);
    }
}

