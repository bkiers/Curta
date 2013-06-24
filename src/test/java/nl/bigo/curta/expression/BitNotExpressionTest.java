package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.Operator;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BitNotExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.BitNot;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"~+20", ~+20},
                {"~-11", ~-11},
                {"~9999", ~9999}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, ((Number)test[1]).longValue());
        }
    }
}
