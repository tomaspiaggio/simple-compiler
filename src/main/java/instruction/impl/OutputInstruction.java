package instruction.impl;

import expression.Expression;
import instruction.Instruction;

import java.util.HashMap;

public class OutputInstruction implements Instruction {
    Expression expression;

    public OutputInstruction(Expression e) {
        expression = e;
    }

    public void run(HashMap<String, Object> hm) {
        System.out.println(expression.run(hm));
    }
}
