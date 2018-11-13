package instruction;

import expression.Expression;

import java.util.HashMap;

public class AssignInstruction implements Instruction {
    String name;
    Expression val;

    public AssignInstruction(String i, Expression e) {
        name = i;
        val = e;
    }

    public void run(HashMap<String, Object> hm) {
        hm.put(name, val.run(hm));
    }
}
