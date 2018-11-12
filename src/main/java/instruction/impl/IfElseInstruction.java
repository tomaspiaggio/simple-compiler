package instruction.impl;

import expression.Expression;
import instruction.IfInstructionI;
import instruction.SimpleInstruction;

import java.util.HashMap;

public class IfElseInstruction implements IfInstructionI {

    Expression condition;
    SimpleInstruction simpleInstruction;
    SimpleInstruction simpleInstruction2;

    public IfElseInstruction(Expression condition, SimpleInstruction simpleInstruction, SimpleInstruction simpleInstruction2) {
        this.condition = condition;
        this.simpleInstruction = simpleInstruction;
        this.simpleInstruction2 = simpleInstruction2;
    }

    public void run(HashMap<String, Object> hm) {
        if ((Boolean) condition.run(hm)) {
            simpleInstruction.run(hm);
        } else {
            simpleInstruction2.run(hm);
        }
    }
}
