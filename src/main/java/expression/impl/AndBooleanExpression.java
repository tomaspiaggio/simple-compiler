package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class AndBooleanExpression implements Expression {
    Expression expression, expression2;

    public AndBooleanExpression(Expression e, Expression e2) {
        expression = e;
        expression2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {
        return (Boolean) expression.run(hm) && (Boolean) expression2.run(hm);
    }
}
