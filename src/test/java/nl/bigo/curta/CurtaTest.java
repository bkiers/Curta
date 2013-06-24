package nl.bigo.curta;

import nl.bigo.curta.expression.Expression;
import nl.bigo.curta.function.Function;
import org.junit.Test;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class CurtaTest {

    @Test
    public void evalTest() throws Exception {

        Curta curta = new Curta();

        // logical
        assertThat( curta.eval("false || true"), is((Object)true) );
		assertThat( curta.eval("(true || false) && true"), is((Object)true) );

        // equality
        assertEquals( curta.eval("1 == 1.0"), true );
        assertEquals( curta.eval("1 != 0.99999"), true );

        // relational
        assertEquals( curta.eval("-1 < -0.99999"), true );
        assertEquals( curta.eval("1 <= 0.99999"), false );

        // binary
        assertEquals( curta.eval("~8"), -9L );
        assertEquals( curta.eval("4 << 1"), 8L );

        // basic arithmetic
        assertEquals( curta.eval("1 + 2 * 3"), 7.0 );
        assertEquals( curta.eval("(1 + 2) * 3"), 9.0 );

        // variables
        curta.addVariable("mu", 42);
        assertEquals( curta.eval("mu + mu"), 84.0 );
        assertEquals( curta.eval("return mu + mu"), 84.0 );
        assertEquals( curta.eval("foo = 2; mu + foo"), 44.0 );

        // built-in functions
        assertEquals( curta.eval("abs(-999)"), 999.0 );
        assertEquals( curta.eval("cos(PI)"), -1.0 );
        assertEquals( curta.eval("hypot(3, 4)"), 5.0 );

        // custom function
        curta.addFunction(new Function("thrice") {
            @Override
            public Object eval(Object... params) {
                return super.getDouble(0, params) * 3;
            }
        });
        assertEquals( curta.eval("thrice(9)"), 27.0 );

        // change existing expressions
        curta.setExpression(Operator.Add, new Expression() {
            @Override
            public Object eval(CurtaNode ast,
                               Map<String, Object> vars,
                               Map<String, Function> functions,
                               Map<Integer, Expression> expressions) {

                // from now on N + M will become N * M
                return super.evalChildAsDouble(0, ast, vars, functions, expressions) *
                        super.evalChildAsDouble(1, ast, vars, functions, expressions);
            }
        });
        assertEquals( curta.eval("3 + 5"), 15.0 );

        // reset variables, functions and expressions
        curta.clear();
        assertEquals( curta.eval("3 + 5"), 8.0 );
    }
}
