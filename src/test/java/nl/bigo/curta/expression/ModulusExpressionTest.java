package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.Operator;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ModulusExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.Modulus;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"288 % 6", 288 % 6},
                {"-20 % 6", -20 % 6},
                {"2.2 % 1.1", 2.2 % 1.1}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            Number expected = (Number)test[1];

            if(expected.getClass() == Integer.class) {
                assertEquals(value, expected.longValue());
            }
            else {
                assertEquals(value, expected);
            }
        }
    }
}
