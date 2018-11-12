package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class PBooleanExpression implements Expression {
    Expression expression;

    public PBooleanExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return expression.run(hm);
    }
}
