package expression.impl;

import expression.Expression;

import java.util.HashMap;

public class SubStringExpression implements Expression {
    Expression sExpression, posExpression, lengthExpression;

    public SubStringExpression(Expression s, Expression pos, Expression length) {
        sExpression = s;
        posExpression = pos;
        lengthExpression = length;
    }

    public Object run(HashMap<String, Object> hm) {

        Object v1 = sExpression.run(hm);
        Object v2 = posExpression.run(hm);
        Object v3 = lengthExpression.run(hm);

        if (v1 instanceof String && v2 instanceof Integer && v3 instanceof Integer) {
            String s = (String) v1;
            int pos = (Integer) v2;
            int length = (Integer) v3;

            if (pos + length - 1 > s.length()) {
                length = s.length() - pos + 1;
            }
            if (pos < 1 || pos > s.length() || length < 1) {
                return "";
            } else {
                return new String(s.substring(pos - 1, pos + length - 1));
            }
        } else {
            System.out.println("Error: wrong objects type");
            System.exit(1);
            return null;
        }

    }
}
