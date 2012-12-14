package curta.function;

import curta.Function;

import java.util.List;

public class Ulp extends Function {

    public Ulp() {
        super("ulp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.ulp(super.getNumber(0, params));
    }
}
