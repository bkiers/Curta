package curta.function;

import curta.Function;

import java.util.List;

public class Cbrt extends Function {

    public Cbrt() {
        super("cbrt");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cbrt(super.getNumber(0, params));
    }
}
