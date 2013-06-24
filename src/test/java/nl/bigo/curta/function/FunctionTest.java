package nl.bigo.curta.function;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionTest {

    @Test
    public void FunctionTest() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        assertThat(dummy.id, is(dummyName));
    }

    @Test(expected = RuntimeException.class)
    public void FunctionTestNullIdShouldFail() {

        String dummyName = null;

        new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };
    }

    @Test
    public void checkNumberOfParamsTest() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.checkNumberOfParams(2, 4, new String[]{"a", "b"});
        dummy.checkNumberOfParams(2, 4, new String[]{"a", "b", "c"});
        dummy.checkNumberOfParams(2, 4, new String[]{"a", "b", "c" ,"d"});
    }

    @Test(expected = RuntimeException.class)
    public void checkNumberOfParamsTestTooLittle1() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.checkNumberOfParams(2, 4, new String[]{});
    }

    @Test(expected = RuntimeException.class)
    public void checkNumberOfParamsTestTooLittle2() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.checkNumberOfParams(2, 4, new String[]{"a"});
    }

    @Test(expected = RuntimeException.class)
    public void checkNumberOfParamsTestTooMuch() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.checkNumberOfParams(2, 4, new String[]{"a", "b", "c" ,"d", "e"});
    }

    @Test
    public void getNumbersTest() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.getNumbers(new Object[]{});
        dummy.getNumbers(new Object[]{1, 2, 3.12159265});
    }

    @Test(expected = RuntimeException.class)
    public void getNumbersTestOtherThanNumber() {

        String dummyName = "DUMMY";

        Function dummy = new Function(dummyName) {
            @Override
            public Object eval(Object... params) {
                return null;
            }
        };

        dummy.getNumbers(new Object[]{1, "2", 3.12159265});
    }
}
