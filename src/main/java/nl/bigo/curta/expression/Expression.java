package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public abstract class Expression {

    public abstract Object eval(CurtaNode ast, Map<String, Object> vars,
                                Map<String, Function> functions,
                                Map<Integer, Expression> expressions);

    protected Object evalChild(int index, CurtaNode ast,
                               Map<String, Object> vars,
                               Map<String, Function> functions,
                               Map<Integer, Expression> expressions) {

        return CurtaNode.eval(CurtaNode.child(index, ast), vars, functions, expressions);
    }

    protected Boolean evalChildAsBoolean(int index, CurtaNode ast,
                                         Map<String, Object> vars,
                                         Map<String, Function> functions,
                                         Map<Integer, Expression> expressions) {

        Object value = CurtaNode.eval(CurtaNode.child(index, ast), vars, functions, expressions);

        if(!(value instanceof Boolean)) {
            throw new RuntimeException("expected child " + (index + 1) + " from " + getClass().getName() + " to be a boolean, encountered: " + value);
        }

        return (Boolean)value;
    }

    protected Double evalChildAsDouble(int index, CurtaNode ast,
                                       Map<String, Object> vars,
                                       Map<String, Function> functions,
                                       Map<Integer, Expression> expressions) {

        Object value = CurtaNode.eval(CurtaNode.child(index, ast), vars, functions, expressions);

        if(!(value instanceof Number)) {
            throw new RuntimeException("expected child " + (index + 1) + " from " + getClass().getName() + " to be a number, encountered: " + value);
        }

        return ((Number)value).doubleValue();
    }

    protected Long evalChildAsLong(int index, CurtaNode ast,
                                   Map<String, Object> vars,
                                   Map<String, Function> functions,
                                   Map<Integer, Expression> expressions) {

        Object value = CurtaNode.eval(CurtaNode.child(index, ast), vars, functions, expressions);

        if(!(value instanceof Number)) {
            throw new RuntimeException("expected child " + (index + 1) + " from " + getClass().getName() + " to be an integer, encountered: " + value);
        }

        double number = ((Number)value).doubleValue();

        if(number % 1 != 0) {
            throw new RuntimeException("expected child " + (index + 1) + " from " + getClass().getName() + " to be an integer");
        }

        return (long)number;
    }

    protected String getTextFromChild(int index, CurtaNode ast) {
        return (String)((CurtaNode)ast.jjtGetChild(index)).jjtGetValue();
    }
}
