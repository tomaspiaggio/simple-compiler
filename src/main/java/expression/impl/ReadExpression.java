package expression.impl;

import expression.Expression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ReadExpression implements Expression {

    public Object run(HashMap<String, Object> hm) {
        final Scanner in = new Scanner(System.in);
        final String result = in.next();
        if(result.matches("[0-9]+")) return new Integer(result);
        else if(result.matches("[0-9]+.[0-9]+")) return new Double(result);
        return result;
    }

}
