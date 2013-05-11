package curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinTest {

    private final Function function = new Min();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(1.0, 2.0)), is(Math.min(1.0, 2.0)));
        assertThat((Double)(function.eval(-500.0,-501.0)), is(Math.min(-500.0,-501.0)));
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
