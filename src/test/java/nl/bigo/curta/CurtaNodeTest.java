package nl.bigo.curta;

import org.junit.Test;

public class CurtaNodeTest {


    @Test
    public void testEval() throws Exception {
        /*
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
        */

        // TODO
        Object value = new Curta().eval("42");
    }
}
