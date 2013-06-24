package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GetExponentTest {

    private final Function function = new GetExponent();

    @Test
    public void evalTest() {

        double value = -500.0;

        assertThat((Integer)(function.eval(value)), is(Math.getExponent(value)));

        value = 500.00001;

        assertThat((Integer)(function.eval(value)), is(Math.getExponent(value)));
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
        function.eval("Foo");
    }
}
