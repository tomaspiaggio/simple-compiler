package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class StringLengthExpression implements Expression {
    Expression e;

    public StringLengthExpression(Expression e) {
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
