package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CopySignTest {

    private final Function function = new CopySign();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(1.1, 1.2)), is(Math.copySign(1.1, 1.2)));
        assertThat((Double)(function.eval(-0.3, 555.0)), is(Math.copySign(-0.3, 555.0)));
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
