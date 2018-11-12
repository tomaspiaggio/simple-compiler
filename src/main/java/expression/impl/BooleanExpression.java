package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class BooleanExpression implements Expression {
    Boolean value;

    public BooleanExpression(Boolean e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}
