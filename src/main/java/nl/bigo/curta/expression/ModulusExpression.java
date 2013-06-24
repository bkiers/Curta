package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class ModulusExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        double lhs = super.evalChildAsDouble(0, ast, vars, functions, expressions);
        double rhs = super.evalChildAsDouble(1, ast, vars, functions, expressions);

        if(lhs % 1 == 0 && rhs % 1 == 0) {
            return (long)(lhs % rhs);
        }
        else {
            return lhs % rhs;
        }
    }
}