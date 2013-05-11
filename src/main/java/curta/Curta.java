package curta;

import curta.expression.*;
import curta.function.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Curta {

    private static final Map<String, Function> DEFAULT_FUNCTIONS = new LinkedHashMap<String, Function>();
    private static final Map<String, Object> DEFAULT_VARIABLES = new LinkedHashMap<String, Object>();
    private static final Map<Integer, Expression> DEFAULT_EXPRESSIONS = new LinkedHashMap<Integer, Expression>();

    static {

        DEFAULT_VARIABLES.put("PI", Math.PI);
        DEFAULT_VARIABLES.put("E", Math.E);

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
            DEFAULT_FUNCTIONS.put(function.id, function);
        }

        DEFAULT_EXPRESSIONS.put(Operator.Add.type, new AddExpression());
        DEFAULT_EXPRESSIONS.put(Operator.And.type, new AndExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Assign.type, new AssignExpression());
        DEFAULT_EXPRESSIONS.put(Operator.BitAnd.type, new BitAndExpression());
        DEFAULT_EXPRESSIONS.put(Operator.BitOr.type, new BitOrExpression());
        DEFAULT_EXPRESSIONS.put(Operator.BitNot.type, new BitNotExpression());
        DEFAULT_EXPRESSIONS.put(Operator.BitXOr.type, new BitXOrExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Division.type, new DivisionExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Equals.type, new EqualsExpression());
        DEFAULT_EXPRESSIONS.put(Operator.GreaterThanEqual.type, new GreaterThanEqualExpression());
        DEFAULT_EXPRESSIONS.put(Operator.GreaterThan.type, new GreaterThanExpression());
        DEFAULT_EXPRESSIONS.put(Operator.LessThanEqual.type, new LessThanEqualExpression());
        DEFAULT_EXPRESSIONS.put(Operator.LessThan.type, new LessThanExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Modulus.type, new ModulusExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Multiply.type, new MultiplyExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Not.type, new NotExpression());
        DEFAULT_EXPRESSIONS.put(Operator.NotEquals.type, new NotEqualsExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Or.type, new OrExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Power.type, new PowerExpression());
        DEFAULT_EXPRESSIONS.put(Operator.Subtract.type, new SubtractExpression());
        DEFAULT_EXPRESSIONS.put(Operator.SignedLeftShift.type, new SignedLeftShiftExpression());
        DEFAULT_EXPRESSIONS.put(Operator.SignedRightShift.type, new SignedRightShiftExpression());
        DEFAULT_EXPRESSIONS.put(Operator.UnsignedRightShift.type, new UnsignedRightShiftExpression());
        DEFAULT_EXPRESSIONS.put(Operator.UnaryMinus.type, new UnaryMinusExpression());
        DEFAULT_EXPRESSIONS.put(Operator.UnaryPlus.type, new UnaryPlusExpression());


        DEFAULT_EXPRESSIONS.put(CurtaParserTreeConstants.JJTRETURN, new ReturnExpression());
        DEFAULT_EXPRESSIONS.put(CurtaParserTreeConstants.JJTROOT, new RootExpression());
        DEFAULT_EXPRESSIONS.put(CurtaParserTreeConstants.JJTFUNCTION, new FunctionExpression());
        DEFAULT_EXPRESSIONS.put(CurtaParserTreeConstants.JJTID, new IdExpression());
    }

    protected Map<String, Function> functions;
    protected Map<String, Object> variables;
    protected Map<Integer, Expression> expressions;

    public Curta() {

        clear();
    }

    protected void addFunction(Function function) {

        functions.put(function.id, function);
    }

    protected void addVariable(String id, Object value) {

        variables.put(id, value);
    }

    public boolean containsFunction(String id) {

        return functions.containsKey(id);
    }

    public boolean containsVariable(String id) {

        return variables.containsKey(id);
    }

    public void clear() {
        functions = new LinkedHashMap<String, Function>(DEFAULT_FUNCTIONS);
        variables = new LinkedHashMap<String, Object>(DEFAULT_VARIABLES);
        expressions = new LinkedHashMap<Integer, Expression>(DEFAULT_EXPRESSIONS);
    }

    public Object eval(File file) throws ParseException, FileNotFoundException {

        CurtaParser parser = new CurtaParser(new FileInputStream(file));
        CurtaNode root = parser.ast();

        return root.eval(variables, functions, expressions);
    }

    public Object eval(String source) throws ParseException {

        CurtaParser parser = new CurtaParser(new java.io.StringReader(source));
        CurtaNode root = parser.ast();

        return root.eval(variables, functions, expressions);
    }

    public void setExpression(Operator operator, Expression expression) {
        expressions.put(operator.type, expression);
    }
}
