package curta.expression;

import curta.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Expression expression = super.expressions.get(Operator.Add.type);

        Object[][] tests = {
                {"2 + 6", 8.0},
                {"-2 + 6", 4.0},
                {"2.2 + 6.01", 8.21}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
