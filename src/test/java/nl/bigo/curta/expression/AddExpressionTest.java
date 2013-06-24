package nl.bigo.curta.expression;

import nl.bigo.curta.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AddExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.Add;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"2 + 6", 8.0},
                {"-2 + 6", 4.0},
                {"2.2 + 6.01", 8.21}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
