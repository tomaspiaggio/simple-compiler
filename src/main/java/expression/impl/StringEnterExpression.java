package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class StringEnterExpression implements Expression {
    public Object run(HashMap<String, Object> hm) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        return in.next();
    }
}
