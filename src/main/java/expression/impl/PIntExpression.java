package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class PIntExpression implements Expression {
    Expression expression;

    public PIntExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return expression.run(hm);
    }
}
