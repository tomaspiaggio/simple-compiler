import java.io.*;
import java.util.*;

public class Main {

    private HashMap<String, Object> hm = new HashMap<>();
    private InstructionList instructionList;

    public Main(InstructionList instructionList) {
        this.instructionList = instructionList;
    }

    public void exec() {
        instructionList.run(hm);
    }

    public static void main(String argv[]) {
        try {
            Parser p = new Parser(new Lexer(new FileReader("assets/test.txt")));
            Object result = p.parse().value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


/**
 * OPERATORS
 */
class PlusOperator implements Operator {

    public int count(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 + (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }
}

class TimesOperator implements Operator {

    public int count(Expression e1, Expression e2, HashMap<String, Object> hm) {
        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);
        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 * (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }
}

class MinusOperator implements Operator {

    public int count(Expression e1, Expression e2, HashMap<String, Object> hm) {
        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);
        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 - (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }
}

class DivideOperator implements Operator {

    public int count(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);
        if (v1 instanceof Integer && v2 instanceof Integer) {
            if ((Integer) v2 == 0) {
                System.out.println("Error: division by zero");
                System.exit(1);
            }
            return (Integer) v1 / (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }
}

class ModeOperator implements Operator {

    public int count(Expression e1, Expression e2, HashMap<String, Object> hm) {
        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            if ((Integer) v2 == 0) {
                System.out.println("Error: division by zero");
                System.exit(1);
            }
            return (Integer) v1 % (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }
}

class OperatorExpression implements Expression {

    Expression e, e2;
    Operator o;

    public OperatorExpression(Expression e, Operator o, Expression e2) {
        this.e = e;
        this.e2 = e2;
        this.o = o;
    }

    public Object run(HashMap<String, Object> hm) {
        return o.count(e, e2, hm);
    }
}

/**
 * INT OPERATIONS
 */
class IntExpression implements Expression {
    int value;

    public IntExpression(int e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}

class IntEnterExpression implements Expression {
    public Object run(HashMap<String, Object> hm) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        return in.nextInt();
    }
}

class PIntExpression implements Expression {
    Expression expression;

    public PIntExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return expression.run(hm);
    }
}

class UMinusExpression implements Expression {
    Expression e;

    public UMinusExpression(Expression e) {
        this.e = e;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v = e.run(hm);
        if (v instanceof Integer) {
            return -((Integer) v);
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }

}

class STRLengthExpression implements Expression {
    Expression e;

    public STRLengthExpression(Expression e) {
        this.e = e;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v = e.run(hm);
        if (v instanceof String) {
            return ((String) v).length();
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }

    }

}

class STRPositionExpression implements Expression {
    Expression e, e2;

    public STRPositionExpression(Expression e, Expression e2) {
        this.e = e;
        this.e2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v1 = e.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof String && v2 instanceof String) {
            String s = (String) v1;
            String s2 = (String) v2;

            int pos = s.indexOf(s2);
            return (pos != -1) ? pos + 1 : 0;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0;
        }
    }

}

/**
 * CONDITIONS
 */
class EqCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 == (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }

    }
}

class LtCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 < (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class LeCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 <= (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class GtCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 > (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class GeCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 >= (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class NeCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof Integer && v2 instanceof Integer) {
            return (Integer) v1 != (Integer) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class StrEqCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof String && v2 instanceof String) {
            return ((String) v1).equals((String) v2);
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

class StrNotEqCond implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if (v1 instanceof String && v2 instanceof String) {
            return !((String) v1).equals((String) v2);
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}

/**
 * BOOLEAN OPERATIONS
 */
class BooleanExpression implements Expression {
    Boolean value;

    public BooleanExpression(Boolean e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}

class ConditionBooleanExpression implements Expression {

    Expression e, e2;
    Condition c;

    public ConditionBooleanExpression(Expression e, Condition c, Expression e2) {
        this.e = e;
        this.c = c;
        this.e2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {
        return c.test(e, e2, hm);
    }
}

class PBooleanExpression implements Expression {
    Expression expression;

    public PBooleanExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return expression.run(hm);
    }
}

class NegationBooleanExpression implements Expression {
    Expression expression;

    public NegationBooleanExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return !((Boolean) expression.run(hm));
    }
}

class AndBooleanExpression implements Expression {
    Expression expression, expression2;

    public AndBooleanExpression(Expression e, Expression e2) {
        expression = e;
        expression2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {
        return (Boolean) expression.run(hm) && (Boolean) expression2.run(hm);
    }
}

class OrBooleanExpression implements Expression {
    Expression expression, expression2;

    public OrBooleanExpression(Expression e, Expression e2) {
        expression = e;
        expression2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {
        return (Boolean) expression.run(hm) || (Boolean) expression2.run(hm);
    }
}

/**
 * STRING OPERATIONS
 */

class StringExpression implements Expression {
    String value;

    public StringExpression(String e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}

class StrEnterExpression implements Expression {
    public Object run(HashMap<String, Object> hm) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        return in.next();
    }
}

class ConcatStringExpression implements Expression {
    Expression s, s2;

    public ConcatStringExpression(Expression s, Expression s2) {
        this.s = s;
        this.s2 = s2;
    }

    public Object run(HashMap<String, Object> hm) {
        Object v1 = s.run(hm);
        Object v2 = s2.run(hm);

        if (v1 instanceof String && v2 instanceof String) {
            return (String) v1 + (String) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return null;
        }
    }
}

class SubStringExpression implements Expression {
    Expression sExpression, posExpression, lengthExpression;

    public SubStringExpression(Expression s, Expression pos, Expression length) {
        sExpression = s;
        posExpression = pos;
        lengthExpression = length;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v1 = sExpression.run(hm);
        Object v2 = posExpression.run(hm);
        Object v3 = lengthExpression.run(hm);

        if (v1 instanceof String && v2 instanceof Integer && v3 instanceof Integer) {
            String s = (String) v1;
            int pos = (Integer) v2;
            int length = (Integer) v3;

            if (pos + length - 1 > s.length()) {
                length = s.length() - pos + 1;
            }
            if (pos < 1 || pos > s.length() || length < 1) {
                return "";
            } else {
                return new String(s.substring(pos - 1, pos + length - 1));
            }
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return null;
        }

    }
}


class OutputInstruction implements SimpleInstruction {
    Expression expression;

    public OutputInstruction(Expression e) {
        expression = e;
    }

    public void run(HashMap<String, Object> hm) {
        System.out.println(expression.run(hm));
    }
}


/**
 * FLOW OPERATIONS
 */
class InstructionList {
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

class WhileInstruction implements WhileInstructionI {
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

class DoWhileInstruction implements WhileInstructionI {
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

class IfInstruction implements IfInstructionI {

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

class IfElseInstruction implements IfInstructionI {

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

class BeginEndInstruction implements SimpleInstruction {
    private InstructionList instructions;

    public BeginEndInstruction(InstructionList instructions) {
        this.instructions = instructions;
    }

    public void run(HashMap<String, Object> hm) {
        instructions.run(hm);
    }
}

