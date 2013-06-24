package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.function.Function;

import java.util.Map;

public class RootExpression extends Expression {

    @Override
    public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {

        int count = ast.jjtGetNumChildren();

        // loop through the assignment nodes
        for(int i = 0; i < count - 1; i++) {
            super.evalChild(i, ast, vars, functions, expressions);
        }

        // the last is the return statement node
        return super.evalChild(count - 1, ast, vars, functions, expressions);
    }
}