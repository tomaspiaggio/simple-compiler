package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class UMinusExpression implements Expression {
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
