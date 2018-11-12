package condition.impl;

import condition.Condition;
import expression.Expression;

import java.util.HashMap;

public class StringEqualsCondition implements Condition {
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
