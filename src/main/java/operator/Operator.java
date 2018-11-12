package operator;

import expression.Expression;
import java.util.HashMap;

public interface Operator {
    int count(Expression e1, Expression e2, HashMap<String, Object> hm);
}