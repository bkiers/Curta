package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class AssignExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        String id = super.getTextFromChild(0, ast);
        Object value = super.evalChild(1, ast, vars, functions,expressions);

        vars.put(id, value);

        return value;
    }
}