package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RandomTest {

    private final Function function = new Random();

    @Test
    public void evalTest() {

        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
        assertTrue((Double)function.eval() < 1.0);
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid2() {
        function.eval(null);
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid3() {
        function.eval(true, "Foo");
    }
}
