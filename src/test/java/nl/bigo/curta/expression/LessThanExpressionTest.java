package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.Operator;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LessThanExpressionTest extends ExpressionTestBase {

    private final String op = "<";
    private final Operator operator = Operator.findByText(op);
    private final Expression expression = super.expressions.get(operator.type);

    @Test
    public void testEval() throws ParseException {

        Object[][] tests = {
                {"1 " + op + " 2", 1 < 2},
                {"2 " + op + " 2", 2 < 2},
                {"-1 " + op + " -2", -1 < -2},
                {"-1 " + op + " -1", -1 < -1},
                {"-10 " + op + " 2", -10 < 2},
                {"100000 " + op + " -2", 100000 < -2}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(operator.type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testEvalInvalid1() throws ParseException {

        CurtaNode ast = super.getExpressionRoot("1 " + op + " null");
        assertThat(ast.treeType, is(operator.type));
        expression.eval(ast, super.variables, super.functions, super.expressions);
    }

    @Test(expected = RuntimeException.class)
    public void testEvalInvalid2() throws ParseException {

        CurtaNode ast = super.getExpressionRoot("1 " + op + " true");
        assertThat(ast.treeType, is(operator.type));
        expression.eval(ast, super.variables, super.functions, super.expressions);
    }

    @Test(expected = RuntimeException.class)
    public void testEvalInvalid3() throws ParseException {

        CurtaNode ast = super.getExpressionRoot("1 " + op + " false");
        assertThat(ast.treeType, is(operator.type));
        expression.eval(ast, super.variables, super.functions, super.expressions);
    }
}
