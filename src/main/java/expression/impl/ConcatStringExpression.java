package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class ConcatStringExpression implements Expression {
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
