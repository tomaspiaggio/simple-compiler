package condition.impl;

import condition.Condition;
import expression.Expression;

import java.util.HashMap;

public class GreaterThanCondition implements Condition {

    public boolean test(Expression e1, Expression e2, HashMap<String, Object> hm) {
        return !new LessOrEqualsCondition().test(e1, e2, hm);
    }

}
