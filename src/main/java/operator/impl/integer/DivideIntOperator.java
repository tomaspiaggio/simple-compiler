package operator.impl.integer;

import expression.Expression;
import operator.Operator;

import java.util.HashMap;

public class DivideIntOperator implements Operator<Integer> {

    public Integer count(Expression e1, Expression e2, HashMap<String, Object> hm) {

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
