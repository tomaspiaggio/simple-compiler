package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class NegationBooleanExpression implements Expression {
    Expression expression;

    public NegationBooleanExpression(Expression e) {
        expression = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return !((Boolean) expression.run(hm));
    }
}
