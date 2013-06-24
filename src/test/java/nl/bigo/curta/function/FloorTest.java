package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FloorTest {

    private final Function function = new Floor();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(1.000000001)), is(Math.floor(1.000000001)));
        assertThat((Double)(function.eval(-500.1)), is(Math.floor(-500.1)));
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid1() {
        function.eval();
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid2() {
        function.eval(null);
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid3() {
        function.eval("Mu", true);
    }
}
