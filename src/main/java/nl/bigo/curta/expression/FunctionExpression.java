package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class FunctionExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        String id = super.getTextFromChild(0, ast);
        Object[] params = new Object[ast.jjtGetNumChildren() - 1];

        Function function = functions.get(id);

        if(function == null) {
            throw new RuntimeException("Unknown function: " + id + "(...)");
        }

        for(int i = 1; i < ast.jjtGetNumChildren(); i++) {
            params[i - 1] = super.evalChild(i, ast, vars, functions, expressions);
        }

        return function.eval(params);
    }
}