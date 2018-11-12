package instruction.impl;

import expression.Expression;
import instruction.SimpleInstruction;
import instruction.WhileInstructionI;

import java.util.HashMap;

public class WhileInstruction implements WhileInstructionI {
    Expression cond;
    SimpleInstruction si;

    public WhileInstruction(Expression c, SimpleInstruction s) {
        cond = c;
        si = s;
    }

    public void run(HashMap<String, Object> hm) {
        while ((Boolean) cond.run(hm)) {
            si.run(hm);
        }
    }
}
