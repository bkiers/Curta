package curta.expression;

import curta.CurtaNode;
import curta.CurtaParser;
import curta.CurtaParserTreeConstants;
import curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RootExpressionTest extends ExpressionTestBase {

    private final int type = CurtaParserTreeConstants.JJTROOT;
    private final Expression expression = super.expressions.get(type);

    @Test
    public void testEval() throws ParseException {

        int n = 0;

        Object[][] tests = {
                {"1.0", 1.0},
                {"a = 2.0; a", 2.0},
                {"a = 2.0; b = a + 1; return b", 3.0},
        };

        for(Object[] test : tests) {

            n++;

            CurtaNode ast = new CurtaParser(new java.io.StringReader((String)test[0])).ast();

            assertThat(ast.treeType, is(type));
            assertThat(ast.jjtGetNumChildren(), is(n));

            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
