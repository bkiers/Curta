package curta;

import curta.CurtaParserTreeConstants;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

    Assign("=", CurtaParserTreeConstants.JJTASSIGN),
    Or("||", CurtaParserTreeConstants.JJTOR),
    And("&&", CurtaParserTreeConstants.JJTAND),
    BitOr("|", CurtaParserTreeConstants.JJTBOR),
    BitXOr("^", CurtaParserTreeConstants.JJTBXOR),
    BitAnd("&", CurtaParserTreeConstants.JJTBAND),
    BitNot("~", CurtaParserTreeConstants.JJTBNOT),
    Equals("==", CurtaParserTreeConstants.JJTEQ),
    NotEquals("!=", CurtaParserTreeConstants.JJTNEQ),
    GreaterThanEqual(">=", CurtaParserTreeConstants.JJTGTE),
    LessThanEqual("<=", CurtaParserTreeConstants.JJTLTE),
    GreaterThan(">", CurtaParserTreeConstants.JJTGT),
    LessThan("<", CurtaParserTreeConstants.JJTLT),
    Add("+", CurtaParserTreeConstants.JJTADD),
    Subtract("-", CurtaParserTreeConstants.JJTSUB),
    Multiply("*", CurtaParserTreeConstants.JJTMUL),
    Division("/", CurtaParserTreeConstants.JJTDIV),
    Modulus("%", CurtaParserTreeConstants.JJTMOD),
    Not("!", CurtaParserTreeConstants.JJTNOT),
    Power("**", CurtaParserTreeConstants.JJTPOW),
    SignedLeftShift("<<", CurtaParserTreeConstants.JJTSLSHIFT),
    SignedRightShift(">>", CurtaParserTreeConstants.JJTSRSHIFT),
    UnsignedRightShift(">>>", CurtaParserTreeConstants.JJTURSHIFT),
    UnaryMinus("-", CurtaParserTreeConstants.JJTUNARYSUB),
    UnaryPlus("+", CurtaParserTreeConstants.JJTUNARYADD);

    public final String text;
    public final int type;

    private Operator(String text, int type) {
        this.text = text;
        this.type = type;
    }
}
