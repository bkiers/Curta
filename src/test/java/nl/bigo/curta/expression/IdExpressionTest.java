package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.CurtaParserTreeConstants;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class IdExpressionTest extends ExpressionTestBase {

    private final int type = CurtaParserTreeConstants.JJTID;
    private final Expression expression = super.expressions.get(type);

    @Test
    public void testEval() throws ParseException {

        super.variables.put("a", false);
        super.variables.put("b", 42.0);
        super.variables.put("c", 100L);
        super.variables.put("d", null);

        Object[][] tests = {
                {"a", false},
                {"b", 42.0},
                {"c", 100L},
                {"d", null},
                {"PI", Math.PI},
                {"E", Math.E}
        };

        for(Object[] test : tests) {

            CurtaNode ast = super.getExpressionRoot((String)test[0]);
            assertThat(ast.treeType, is(type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testEvalInvalid() throws ParseException {

        CurtaNode ast = super.getExpressionRoot("x");
        assertThat(ast.treeType, is(type));
        expression.eval(ast, super.variables, super.functions, super.expressions);
    }
}
