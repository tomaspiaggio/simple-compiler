package expression.impl;

import expression.Expression;
import java.util.HashMap;

public class IntEnterExpression implements Expression {
    public Object run(HashMap<String, Object> hm) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        return in.nextInt();
    }
}
