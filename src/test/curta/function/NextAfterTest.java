package curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NextAfterTest {

    private final Function function = new NextAfter();

    @Test
    public void evalTest() {

        assertThat((Double)(function.eval(-1.0, 0.0001)), is(Math.nextAfter(-1.0, 0.0001)));
        assertThat((Double)(function.eval(0.75, 0.333)), is(Math.nextAfter(0.75, 0.333)));
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
