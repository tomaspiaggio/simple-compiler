package instruction.impl;

import instruction.SimpleInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InstructionList {
    private List<SimpleInstruction> simpleInstructions;

    public InstructionList(SimpleInstruction s) {
        simpleInstructions = new ArrayList<SimpleInstruction>();
        simpleInstructions.add(s);
    }

    public void add(SimpleInstruction s) {
        simpleInstructions.add(s);
    }

    public void run(HashMap<String, Object> hm) {
        for (SimpleInstruction si : simpleInstructions) {
            si.run(hm);
        }
    }
}

