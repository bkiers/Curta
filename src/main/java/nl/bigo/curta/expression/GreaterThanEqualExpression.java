package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class GreaterThanEqualExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        Double lhs = super.evalChildAsDouble(0, ast, vars, functions, expressions);
        Double rhs = super.evalChildAsDouble(1, ast, vars, functions, expressions);

        return lhs >= rhs;
    }
}