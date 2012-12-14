package curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MinTest {

    @Test
    public void evalTest() {

        assertThat((Double)(new Min().eval(new Double[]{1.0, 2.0, 5.0, 4.0, 3.0})), is(1.0));
        assertThat((Double)(new Min().eval(new Double[]{-500.0})), is(-500.0));
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid1() {
        new Min().eval(new Double[]{});
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid2() {
        new Min().eval(null);
    }

    @Test(expected = RuntimeException.class)
    public void evalTestInvalid3() {
        new Min().eval(new Object[]{true, false});
    }
}
