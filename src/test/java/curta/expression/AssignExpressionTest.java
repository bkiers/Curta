package curta.expression;

import curta.CurtaNode;
import curta.CurtaParser;
import curta.Operator;
import curta.ParseException;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AssignExpressionTest extends ExpressionTestBase {

    @Test
    public void testEval() throws ParseException {

        Operator operator = Operator.Assign;
        Expression expression = super.expressions.get(operator.type);

        Object[][] tests = {
                {"a = false; a", false},
                {"b = 1; b", 1L},
                {"c = 3.0; c", 3.0}
        };

        for(Object[] test : tests) {

            CurtaNode sourceRoot = new CurtaParser(new java.io.StringReader((String)test[0])).ast();
            CurtaNode ast = (CurtaNode)sourceRoot.jjtGetChild(0);

            Object value = expression.eval(ast, super.variables, super.functions, super.expressions);

            assertEquals(value, test[1]);
        }
    }
}
