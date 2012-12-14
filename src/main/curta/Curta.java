package curta;

import curta.function.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Curta {

    protected static final Map<String, Function> DEFAULT_FUNCTIONS = new LinkedHashMap<String, Function>();
    protected static final Map<String, Object> DEFAULT_VARIABLES = new LinkedHashMap<String, Object>();

    static {

        DEFAULT_VARIABLES.put("PI", Math.PI);
        DEFAULT_VARIABLES.put("E", Math.E);

        Function[] defaultFunctions = {
                new Abs(), new ACos(), new ASin(), new ATan(), new ATan2(),
                new Cbrt(), new Ceil(), new CopySign(), new Cos(), new Cosh(),
                new Exp(), new Expm1(), new Floor(), new GetExponent(), new Hypot(),
                new IEEERemainder(), new Log(), new Log1p(), new Log10(), new Max(),
                new Min(), new NextAfter(), new NextUp(), new Pow(), new Random(),
                new RInt(), new Round(), new Scalb(), new Signum(), new Sin(),
                new Sinh(), new Sqrt(), new Tan(), new Tanh(), new ToDegrees(),
                new ToRadians(), new Ulp()
        };

        for(Function function : defaultFunctions) {
            DEFAULT_FUNCTIONS.put(function.id, function);
        }
    }

    private Map<String, Function> functions;
    private Map<String, Object> variables;

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
    }

    public Object eval(File file) throws ParseException, FileNotFoundException {

        CurtaParser parser = new CurtaParser(new FileInputStream(file));
        CurtaNode root = parser.ast();
        return root.eval(variables, functions);
    }

    public Object eval(String source) throws ParseException {

        CurtaParser parser = new CurtaParser(new java.io.StringReader(source));
        CurtaNode root = parser.ast();
        return root.eval(variables, functions);
    }
}
