package curta;

import org.junit.Test;

public class CurtaTest {


    @Test
    public void test() throws ParseException {

        Curta curta = new Curta();

        System.out.println(curta.eval("a = 666; a"));
    }
}
