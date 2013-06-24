package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ScalbTest {

    private final Function function = new Scalb();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(-1.0, 1)), is(Math.scalb(-1.0, 1)));
        assertThat((Double)(function.eval(0.75, 3)), is(Math.scalb(0.75, 3)));
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
