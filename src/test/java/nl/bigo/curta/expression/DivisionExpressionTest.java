package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.Operator;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DivisionExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.Division;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"2 / 6", 2.0 / 6},
                {"-2 / 6", -2.0 / 6},
                {"2.2 / 1.1", 2.2 / 1.1}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
