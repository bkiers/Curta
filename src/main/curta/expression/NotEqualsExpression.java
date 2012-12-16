package curta.expression;

import curta.CurtaNode;
import curta.function.Function;

import java.util.Map;

public class NotEqualsExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        Object lhs = super.evalChild(0, ast, vars, functions, expressions);
        Object rhs = super.evalChild(1, ast, vars, functions, expressions);

        if(lhs == rhs) {
            return false;
        }
        else if(lhs == null) {
            return true;
        }

        return !lhs.equals(rhs);
    }
}