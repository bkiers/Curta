package curta.expression;

import curta.CurtaNode;
import curta.Operator;
import curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BitAndExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.BitAnd;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"20 & 30", 20 & 30},
                {"-11 & 3", -11 & 3},
                {"9999 & -3", 9999 & -3}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, ((Number)test[1]).longValue());
        }
    }
}
