package operator.impl.floating;

import expression.Expression;
import operator.Operator;

import java.util.HashMap;

public class MinusDoubleOperator implements Operator<Double> {

    public Double count(Expression e1, Expression e2, HashMap<String, Object> hm) {
        Object v1 = e1.run(hm);
        Object v2 = e2.run(hm);
        if (v1 instanceof Double && v2 instanceof Double) {
            return (Double) v1 - (Double) v2;
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0.0;
        }
    }

}
