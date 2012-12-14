package curta;

import org.junit.Test;

import java.io.File;

public class CurtaTest {

    @Test
    public void test() throws Exception {

        Curta curta = new Curta();

        System.out.println(curta.eval("abs(-666)"));

        //System.out.println(curta.eval(new File("src/scripts/test.curta")));
    }
}
