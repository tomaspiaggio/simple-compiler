package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class IntExpression implements Expression {
    int value;

    public IntExpression(int e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}