package expression;

import java.util.HashMap;

public interface Expression {
    Object run(HashMap<String, Object> hm);
}
