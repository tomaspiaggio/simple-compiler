package condition;

import expression.Expression;

import java.util.HashMap;

public interface Condition {
    boolean test(Expression e1, Expression e2, HashMap<String, Object> hm);
}
