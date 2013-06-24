package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    private final Function function = new Max();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(-500.0, -500.0001)), is(Math.max(-500.0, -500.0001)));
        assertThat((Double)(function.eval(-500.0, 500.0001)), is(Math.max(-500.0, 500.0001)));
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
        function.eval(true, "Foo");
    }
}
