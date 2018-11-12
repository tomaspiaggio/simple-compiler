package expression.impl;

import condition.Condition;
import expression.Expression;

import java.util.HashMap;

public class ConditionBooleanExpression implements Expression {

    Expression e, e2;
    Condition c;

    public ConditionBooleanExpression(Expression e, Condition c, Expression e2) {
        this.e = e;
        this.c = c;
        this.e2 = e2;
    }

    public Object run(HashMap<String, Object> hm) {
        return c.test(e, e2, hm);
    }
}
