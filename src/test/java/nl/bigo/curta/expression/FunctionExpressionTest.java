package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.CurtaParserTreeConstants;
import nl.bigo.curta.ParseException;
import nl.bigo.curta.function.Function;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FunctionExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        int type = CurtaParserTreeConstants.JJTFUNCTION;
        Expression expression = super.expressions.get(type);

        super.functions.put("minusOne", new Function("minusOne") {
            @Override
            public Object eval(Object... params) {
                return super.getDouble(0, params) - 1;
            }
        });

        Object[][] tests = {
                {"abs(-4)", 4.0},
                {"hypot(3, 4)", 5.0},
                {"minusOne(-1)", -2.0}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
