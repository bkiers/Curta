package curta.expression;

import curta.CurtaNode;
import curta.CurtaParser;
import curta.ParseException;
import curta.function.Function;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExpressionTest extends ExpressionTestBase {

    private final Expression dummyExpression = new Expression() {
        @Override
        public Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions, Map<Integer, Expression> expressions) {
            return null;
        }
    };

    @Test
    public void evalChildTest() throws ParseException {

        String source = "4";
        CurtaNode rootNode = new CurtaParser(new java.io.StringReader(source)).ast();
        CurtaNode returnNode = (CurtaNode)rootNode.jjtGetChild(0);

        assertThat((Long)dummyExpression.evalChild(
                0, returnNode, super.variables, super.functions, super.expressions), is(4L));
    }

    @Test
    public void evalChildAsBooleanTest() throws ParseException {

        String source = "false";
        CurtaNode rootNode = new CurtaParser(new java.io.StringReader(source)).ast();
        CurtaNode returnNode = (CurtaNode)rootNode.jjtGetChild(0);

        assertThat((Boolean)dummyExpression.evalChildAsBoolean(
                0, returnNode, super.variables, super.functions, super.expressions), is(false));
    }

    @Test
    public void evalChildAsLong() throws ParseException {

        String source = "9" + Integer.MAX_VALUE;
        CurtaNode rootNode = new CurtaParser(new java.io.StringReader(source)).ast();
        CurtaNode returnNode = (CurtaNode)rootNode.jjtGetChild(0);

        assertThat((Long)dummyExpression.evalChildAsLong(
                0, returnNode, super.variables, super.functions, super.expressions), is(Long.valueOf(source)));
    }

    @Test
    public void evalChildAsDouble() throws ParseException {

        String source = "9" + Integer.MAX_VALUE + ".001";
        CurtaNode rootNode = new CurtaParser(new java.io.StringReader(source)).ast();
        CurtaNode returnNode = (CurtaNode)rootNode.jjtGetChild(0);

        assertThat((Double)dummyExpression.evalChildAsDouble(
                0, returnNode, super.variables, super.functions, super.expressions), is(Double.valueOf(source)));
    }

    @Test
    public void testGetTextFromChild() throws ParseException {

        String id = "abc";
        String source = id + " = 42; return abc";
        CurtaNode ast = new CurtaParser(new java.io.StringReader(source)).ast();
        CurtaNode assignNode = (CurtaNode)ast.jjtGetChild(0);

        assertThat(dummyExpression.getTextFromChild(0, assignNode), is(id));
    }
}
