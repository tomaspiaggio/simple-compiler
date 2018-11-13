package condition.impl;

import condition.Condition;
import expression.Expression;

import java.util.HashMap;

public class GreaterOrEqualsCondition implements Condition {
    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {
        return !new LessThanCondition().test(e1, e2, hm);
    }
}