package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class ReturnExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        // evaluate the first child in the node, which is the actual return value
        return super.evalChild(0, ast, vars, functions, expressions);
    }
}