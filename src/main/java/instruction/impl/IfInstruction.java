package instruction.impl;

import expression.Expression;
import instruction.IfInstructionI;
import instruction.SimpleInstruction;

import java.util.HashMap;

public class IfInstruction implements IfInstructionI {

    Expression condition;
    SimpleInstruction simpleInstruction;

    public IfInstruction(Expression condition, SimpleInstruction simpleInstruction) {
        this.condition = condition;
        this.simpleInstruction = simpleInstruction;
    }

    public void run(HashMap<String, Object> hm) {
        if ((Boolean) condition.run(hm)) {
            simpleInstruction.run(hm);
        }
    }
}
