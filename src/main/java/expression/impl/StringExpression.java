package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class StringExpression implements Expression {
    String value;

    public StringExpression(String e) {
        value = e;
    }

    public Object run(HashMap<String, Object> hm) {
        return value;
    }
}
