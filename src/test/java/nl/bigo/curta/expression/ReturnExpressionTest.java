package nl.bigo.curta.expression;

import nl.bigo.curta.CurtaNode;
import nl.bigo.curta.CurtaParser;
import nl.bigo.curta.CurtaParserTreeConstants;
import nl.bigo.curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReturnExpressionTest extends ExpressionTestBase {

    private final int type = CurtaParserTreeConstants.JJTRETURN;
    private final Expression expression = super.expressions.get(type);

    @Test
    public void testEval() throws ParseException {

        super.variables.put("d", null);

        Object[][] tests = {
                {"return false", false},
                {"42.0", 42.0},
                {"100", 100L},
                {"d", null},
                {"return PI", Math.PI},
                {"E", Math.E}
        };

        for(Object[] test : tests) {

            CurtaNode sourceRoot = new CurtaParser(new java.io.StringReader((String)test[0])).ast();
            CurtaNode ast = (CurtaNode)sourceRoot.jjtGetChild(0);
            assertThat(ast.treeType, is(type));
            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
