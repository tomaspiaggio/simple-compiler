package expression.impl;

import expression.Expression;
import operator.Operator;

import java.util.HashMap;

public class OperatorExpression implements Expression {

    Expression e, e2;
    Operator o;

    public OperatorExpression(Expression e, Operator o, Expression e2) {
        this.e = e;
        this.e2 = e2;
        this.o = o;
    }

    public Object run(HashMap<String, Object> hm) {
        return o.count(e, e2, hm);
    }
}