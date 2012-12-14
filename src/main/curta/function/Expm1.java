package curta.function;

import curta.Function;

import java.util.List;

public class Expm1 extends Function {

    public Expm1() {
        super("expm1");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.expm1(super.getNumber(0, params));
    }
}
