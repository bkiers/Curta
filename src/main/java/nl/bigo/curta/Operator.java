package nl.bigo.curta;

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

    public static Operator findByText(String text) {

        return findByText(text, true);
    }

    public static Operator findByText(String text, boolean binaryExpression) {

        if("-".equals(text)) {
            return binaryExpression ? Operator.Subtract : Operator.UnaryMinus;
        }
        else if("+".equals(text)) {
            return binaryExpression ? Operator.Add : Operator.UnaryPlus;
        }

        for(Operator op : Operator.values()) {
            if(op.text.equals(text)) {
                return op;
            }
        }

        throw new RuntimeException("did not find an operator: " + text);
    }

    public static Operator findByType(int type) {

        for(Operator op : Operator.values()) {
            if(op.type == type) {
                return op;
            }
        }

        throw new RuntimeException("did not find an operator with type: " + type);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.text, this.name());
    }
}
