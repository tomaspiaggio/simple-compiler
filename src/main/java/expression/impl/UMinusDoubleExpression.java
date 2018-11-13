package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class UMinusDoubleExpression implements Expression {

    Expression e;

    public UMinusDoubleExpression(Expression e) {
        this.e = e;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v = e.run(hm);
        if (v instanceof Double) {
            return -((Double) v);
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return 0.0;
        }
    }
}
