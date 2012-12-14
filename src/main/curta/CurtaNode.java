package curta;

import curta.function.Function;

import java.io.File;
import java.util.Map;

public class CurtaNode extends SimpleNode implements CurtaParserTreeConstants {

    public static final double EPSILON = 0.00000000001;
    public static final Object VOID = new Object();

    protected CurtaNode(int i) {
        super(i);
    }

    protected Object eval(Map<String, Object> vars, Map<String, Function> functions) {
        return CurtaNode.eval(this, vars, functions);
    }

    @Override
    public String toString() {
        return String.format("%s",
                super.value instanceof File ? ((File)super.value).getAbsolutePath() :
                super.value == null ? super.toString() : String.valueOf(super.value)
        );
    }

    /*
     * static utility methods
     */
    protected static CurtaNode child(int index, CurtaNode ast) {
        return (CurtaNode)ast.jjtGetChild(index);
    }

    private static Object eval(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        switch(ast.id) {
            case JJTNUM:
            case JJTBOOL:
                return ast.value;
            case JJTFUNCTION:
                return evalFunction(ast, vars, functions);
            case JJTID:
                return evalId(ast, vars, functions);
            case JJTAND:
                return evalAnd(ast, vars, functions);
            case JJTOR:
                return evalOr(ast, vars, functions);
            case JJTGTE:
                return evalGTE(ast, vars, functions);
            case JJTGT:
                return evalGT(ast, vars, functions);
            case JJTLTE:
                return evalLTE(ast, vars, functions);
            case JJTLT:
                return evalLT(ast, vars, functions);
            case JJTEQ:
                return evalEq(ast, vars, functions);
            case JJTNEQ:
                return evalNEq(ast, vars, functions);
            case JJTNOT:
                return evalNot(ast, vars, functions);
            case JJTADD:
                return evalAdd(ast, vars, functions);
            case JJTSUB:
                return evalSub(ast, vars, functions);
            case JJTUNARYSUB:
                return evalUnarySub(ast, vars, functions);
            case JJTMUL:
                return evalMul(ast, vars, functions);
            case JJTDIV:
                return evalDiv(ast, vars, functions);
            case JJTMOD:
                return evalMod(ast, vars, functions);
            case JJTASSIGN:
                return evalAssign(ast, vars, functions);
            case JJTRETURN:
                return eval(child(0, ast), vars, functions);
            case JJTROOT:
                return evalRoot(ast, vars, functions);
            default:
                throw new RuntimeException("Node not yet implemented: " + jjtNodeName[ast.id]);
        }
    }

    private static Object evalFunction(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {

        String id = (String)child(0, ast).value;
        Object[] params = new Object[ast.jjtGetNumChildren() - 1];

        Function function = functions.get(id);

        if(function == null) {
            throw new RuntimeException("Unknown function: " + id + "(...)");
        }

        for(int i = 1; i < ast.jjtGetNumChildren(); i++) {
            params[i - 1] = eval(child(i, ast), vars, functions);
        }

        return function.eval(params);
    }

    private static Object evalMod(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs % (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " % " + rhs);
    }

    private static Object evalDiv(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs / (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " / " + rhs);
    }

    private static Object evalNot(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object expr = eval(child(0, ast), vars, functions);
        if(expr.getClass() == Boolean.class) {
            return !(Boolean)expr;
        }
        throw new RuntimeException("Cannot perform: !" + expr);
    }

    private static Object evalNEq(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return Math.abs((Double)lhs - (Double)rhs) >= EPSILON;
        }
        else {
            return !lhs.equals(rhs);
        }
    }

    private static Object evalEq(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return Math.abs((Double)lhs - (Double)rhs) < EPSILON;
        }
        else {
            return lhs.equals(rhs);
        }
    }

    private static Object evalLT(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs < (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " < " + rhs);
    }

    private static Object evalLTE(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs <= (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " <= " + rhs);
    }

    private static Object evalGT(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs > (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " > " + rhs);
    }

    private static Object evalGTE(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs >= (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " >= " + rhs);
    }

    private static Object evalAdd(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs + (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " + " + rhs);
    }

    private static Object evalSub(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs - (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " - " + rhs);
    }

    private static Object evalAnd(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Boolean.class && rhs.getClass() == Boolean.class) {
            return (Boolean)lhs && (Boolean)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " && " + rhs);
    }

    private static Object evalAssign(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        String id = (String) child(0, ast).value;
        CurtaNode expr = child(1, ast);
        vars.put(id, eval(expr, vars, null));
        return VOID;
    }

    private static Object evalId(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        String key = String.valueOf(ast.value);
        Object value = vars.get(key);
        if(value == null) {
            throw new RuntimeException("Unknown variable: " + key);
        }
        return value;
    }

    private static Object evalMul(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Double.class && rhs.getClass() == Double.class) {
            return (Double)lhs * (Double)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " * " + rhs);
    }

    private static Object evalOr(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object lhs = eval(child(0, ast), vars, functions);
        Object rhs = eval(child(1, ast), vars, functions);
        if(lhs.getClass() == Boolean.class && rhs.getClass() == Boolean.class) {
            return (Boolean)lhs || (Boolean)rhs;
        }
        throw new RuntimeException("Cannot perform: " + lhs + " || " + rhs);
    }

    private static Object evalRoot(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        int count = ast.jjtGetNumChildren();
        // loop through the assignment nodes
        for(int i = 0; i < count - 1; i++) {
            eval(child(i, ast), vars, functions);
        }
        // the last is the return statement node
        return eval(child(count - 1, ast), vars, functions);
    }

    private static Object evalUnarySub(CurtaNode ast, Map<String, Object> vars, Map<String, Function> functions) {
        Object expr = eval(child(0, ast), vars, functions);
        if(expr.getClass() == Double.class) {
            return -(Double)expr;
        }
        throw new RuntimeException("Cannot perform: - " + expr);
    }
}
