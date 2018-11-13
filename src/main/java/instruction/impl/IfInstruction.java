package instruction.impl;

import expression.Expression;
import instruction.IfInstructionI;
import instruction.Instruction;

import java.util.HashMap;

public class IfInstruction implements IfInstructionI {

    Expression condition;
    Instruction instruction;

    public IfInstruction(Expression condition, Instruction instruction) {
        this.condition = condition;
        this.instruction = instruction;
    }

    public void run(HashMap<String, Object> hm) {
        if ((Boolean) condition.run(hm)) {
            instruction.run(hm);
        }
    }
}
