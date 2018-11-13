package operator;

import expression.Expression;
import java.util.HashMap;

public interface Operator<T> {
    T count(Expression e1, Expression e2, HashMap<String, Object> hm);
}