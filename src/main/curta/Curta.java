package curta;

import curta.function.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class Curta {

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

        functions = new LinkedHashMap<String, Function>();
        variables = new LinkedHashMap<String, Object>();

        addVariable("PI", Math.PI);
        addVariable("E", Math.E);

        addFunction(new Max());
        addFunction(new Min());
    }

    public Object eval(String source) throws ParseException {
        CurtaParser parser = new CurtaParser(new java.io.StringReader(source));
        CurtaNode root = parser.ast();
        return root.eval(variables, functions);
    }
}
