package condition.impl;

import condition.Condition;
import expression.Expression;

import java.util.HashMap;

public class EqualsCondition implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {

        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);

        if ((v1 instanceof Comparable) && (v2 instanceof Comparable)) {
            return ((Comparable) v1).compareTo(v2) == 0;
        } else{
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return false;
        }
    }
}
