package curta.expression;

import curta.CurtaNode;
import curta.Operator;
import curta.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Expression expression = super.expressions.get(Operator.Not.type);

        Object[][] tests = {
                {"!false", true},
                {"!true", false}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
