package curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CeilTest {

    private final Function function = new Ceil();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(1.000000001)), is(Math.ceil(1.000000001)));
        assertThat((Double)(function.eval(-500.1)), is(Math.ceil(-500.1)));
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
