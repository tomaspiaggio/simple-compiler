package instruction.impl;

import expression.Expression;
import instruction.IfInstructionI;
import instruction.Instruction;

import java.util.HashMap;

public class IfElseInstruction implements IfInstructionI {

    Expression condition;
    Instruction instruction;
    Instruction instruction2;

    public IfElseInstruction(Expression condition, Instruction instruction, Instruction instruction2) {
        this.condition = condition;
        this.instruction = instruction;
        this.instruction2 = instruction2;
    }

    public void run(HashMap<String, Object> hm) {
        if ((Boolean) condition.run(hm)) {
            instruction.run(hm);
        } else {
            instruction2.run(hm);
        }
    }
}
