package expression;

import java.util.HashMap;

public class ID implements Expression {
    String name;

    public ID(String s) {
        name = s;
    }

    public Object run(HashMap<String, Object> hm) {
        return hm.get(name);
    }
}
