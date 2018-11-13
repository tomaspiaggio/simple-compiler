package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class DoubleExpression implements Expression {
    double value;

    public DoubleExpression(double e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}
