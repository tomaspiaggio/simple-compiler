package instruction.impl;

import expression.Expression;
import instruction.SimpleInstruction;
import instruction.WhileInstructionI;

import java.util.HashMap;

public class DoWhileInstruction implements WhileInstructionI {
    Expression cond;
    SimpleInstruction si;

    public DoWhileInstruction(Expression c, SimpleInstruction s) {
        cond = c;
        si = s;
    }

    public void run(HashMap<String, Object> hm) {
        do
            si.run(hm);
        while ((Boolean) cond.run(hm));
    }
}

