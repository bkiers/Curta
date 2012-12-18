package curta.expression;

import curta.CurtaNode;
import curta.function.Function;

import java.util.Map;

public class IdExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        String id = (String)ast.jjtGetValue();

        if(!vars.containsKey(id)) {
            throw new RuntimeException("Unknown variable: " + id);
        }

        return vars.get(id);
    }
}