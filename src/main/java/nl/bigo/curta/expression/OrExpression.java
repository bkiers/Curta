package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class OrExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        Boolean lhs = super.evalChildAsBoolean(0, ast, vars, functions, expressions);
        Boolean rhs = super.evalChildAsBoolean(1, ast, vars, functions, expressions);

        return lhs || rhs;
    }
}