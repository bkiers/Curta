package curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ATanTest {

    private final Function function = new ATan();

    @Test
    public void evalTest() {

        double value = 1.0;

        assertThat((Double)(function.eval(value)), is(Math.atan(value)));

        value = 0.00001;

        assertThat((Double)(function.eval(value)), is(Math.atan(value)));
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
