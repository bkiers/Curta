package nl.bigo.curta.expression;

import nl.bigo.curta.*;
import nl.bigo.curta.function.*;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ExpressionTestBase {

    protected Map<String, Function> functions;
    protected Map<String, Object> variables;
    protected Map<Integer, Expression> expressions;
    
    public ExpressionTestBase() {
        
        functions = new LinkedHashMap<String, Function>();
        variables = new LinkedHashMap<String, Object>();
        expressions = new LinkedHashMap<Integer, Expression>();

        variables.put("PI", Math.PI);
        variables.put("E", Math.E);

        Function[] defaultFunctions = {
                new Abs(),
                new ACos(),
                new ASin(),
                new ATan(),
                new ATan2(),
                new Cbrt(),
                new Ceil(),
                new CopySign(),
                new Cos(),
                new Cosh(),
                new Exp(),
                new Expm1(),
                new Floor(),
                new GetExponent(),
                new Hypot(),
                new IEEERemainder(),
                new Log(),
                new Log1p(),
                new Log10(),
                new Max(),
                new Min(),
                new NextAfter(),
                new NextUp(),
                new Pow(),
                new Random(),
                new RInt(),
                new Round(),
                new Scalb(),
                new Signum(),
                new Sin(),
                new Sinh(),
                new Sqrt(),
                new Tan(),
                new Tanh(),
                new ToDegrees(),
                new ToRadians(),
                new Ulp()
        };

        for(Function function : defaultFunctions) {
            functions.put(function.id, function);
        }

        expressions.put(Operator.Add.type, new AddExpression());
        expressions.put(Operator.And.type, new AndExpression());
        expressions.put(Operator.Assign.type, new AssignExpression());
        expressions.put(Operator.BitAnd.type, new BitAndExpression());
        expressions.put(Operator.BitOr.type, new BitOrExpression());
        expressions.put(Operator.BitNot.type, new BitNotExpression());
        expressions.put(Operator.BitXOr.type, new BitXOrExpression());
        expressions.put(Operator.Division.type, new DivisionExpression());
        expressions.put(Operator.Equals.type, new EqualsExpression());
        expressions.put(Operator.GreaterThanEqual.type, new GreaterThanEqualExpression());
        expressions.put(Operator.GreaterThan.type, new GreaterThanExpression());
        expressions.put(Operator.LessThanEqual.type, new LessThanEqualExpression());
        expressions.put(Operator.LessThan.type, new LessThanExpression());
        expressions.put(Operator.Modulus.type, new ModulusExpression());
        expressions.put(Operator.Multiply.type, new MultiplyExpression());
        expressions.put(Operator.Not.type, new NotExpression());
        expressions.put(Operator.NotEquals.type, new NotEqualsExpression());
        expressions.put(Operator.Or.type, new OrExpression());
        expressions.put(Operator.Power.type, new PowerExpression());
        expressions.put(Operator.Subtract.type, new SubtractExpression());
        expressions.put(Operator.SignedLeftShift.type, new SignedLeftShiftExpression());
        expressions.put(Operator.SignedRightShift.type, new SignedRightShiftExpression());
        expressions.put(Operator.UnsignedRightShift.type, new UnsignedRightShiftExpression());
        expressions.put(Operator.UnaryMinus.type, new UnaryMinusExpression());
        expressions.put(Operator.UnaryPlus.type, new UnaryPlusExpression());


        expressions.put(CurtaParserTreeConstants.JJTRETURN, new ReturnExpression());
        expressions.put(CurtaParserTreeConstants.JJTROOT, new RootExpression());
        expressions.put(CurtaParserTreeConstants.JJTFUNCTION, new FunctionExpression());
        expressions.put(CurtaParserTreeConstants.JJTID, new IdExpression());
    }

    /*
     * in:
     * ----------
     * Root
     *   Return
     *     Add
     *       Num
     *       Num
     *
     * out:
     * ----------
     * Add
     *   Num
     *   Num
     */
    public CurtaNode getExpressionRoot(String source) throws ParseException {
        CurtaNode sourceRoot = new CurtaParser(new java.io.StringReader(source)).ast();
        return (CurtaNode)sourceRoot.jjtGetChild(0).jjtGetChild(0);
    }
}
