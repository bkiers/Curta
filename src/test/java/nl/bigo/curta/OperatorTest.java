package nl.bigo.curta;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OperatorTest {

    @Test
    public void findByTextTest() {

        assertThat(Operator.findByText("+"), is(Operator.Add));
        assertThat(Operator.findByText("-"), is(Operator.Subtract));

        assertThat(Operator.findByText("-", false), is(Operator.UnaryMinus));
        assertThat(Operator.findByText("+", false), is(Operator.UnaryPlus));

        assertThat(Operator.findByText("="), is(Operator.Assign));
        assertThat(Operator.findByText("||"), is(Operator.Or));
        assertThat(Operator.findByText("&&"), is(Operator.And));
        assertThat(Operator.findByText("|"), is(Operator.BitOr));
        assertThat(Operator.findByText("^"), is(Operator.BitXOr));
        assertThat(Operator.findByText("&"), is(Operator.BitAnd));
        assertThat(Operator.findByText("~"), is(Operator.BitNot));
        assertThat(Operator.findByText("=="), is(Operator.Equals));
        assertThat(Operator.findByText("!="), is(Operator.NotEquals));
        assertThat(Operator.findByText(">="), is(Operator.GreaterThanEqual));
        assertThat(Operator.findByText("<="), is(Operator.LessThanEqual));
        assertThat(Operator.findByText(">"), is(Operator.GreaterThan));
        assertThat(Operator.findByText("<"), is(Operator.LessThan));
        assertThat(Operator.findByText("*"), is(Operator.Multiply));
        assertThat(Operator.findByText("/"), is(Operator.Division));
        assertThat(Operator.findByText("%"), is(Operator.Modulus));
        assertThat(Operator.findByText("!"), is(Operator.Not));
        assertThat(Operator.findByText("**"), is(Operator.Power));
        assertThat(Operator.findByText("<<"), is(Operator.SignedLeftShift));
        assertThat(Operator.findByText(">>"), is(Operator.SignedRightShift));
        assertThat(Operator.findByText(">>>"), is(Operator.UnsignedRightShift));
    }

    @Test
    public void findByIdTest() {

        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTASSIGN), is(Operator.Assign));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTOR), is(Operator.Or));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTAND), is(Operator.And));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTBOR), is(Operator.BitOr));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTBXOR), is(Operator.BitXOr));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTBAND), is(Operator.BitAnd));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTBNOT), is(Operator.BitNot));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTEQ), is(Operator.Equals));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTNEQ), is(Operator.NotEquals));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTGTE), is(Operator.GreaterThanEqual));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTLTE), is(Operator.LessThanEqual));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTGT), is(Operator.GreaterThan));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTLT), is(Operator.LessThan));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTADD), is(Operator.Add));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTSUB), is(Operator.Subtract));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTMUL), is(Operator.Multiply));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTDIV), is(Operator.Division));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTMOD), is(Operator.Modulus));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTNOT), is(Operator.Not));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTPOW), is(Operator.Power));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTSLSHIFT), is(Operator.SignedLeftShift));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTSRSHIFT), is(Operator.SignedRightShift));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTURSHIFT), is(Operator.UnsignedRightShift));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTUNARYSUB), is(Operator.UnaryMinus));
        assertThat(Operator.findByType(CurtaParserTreeConstants.JJTUNARYADD), is(Operator.UnaryPlus));
    }
}
