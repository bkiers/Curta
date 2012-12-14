package curta.function;

import curta.Function;

import java.util.List;

public class Cosh extends Function {

    public Cosh() {
        super("cosh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cosh(super.getNumber(0, params));
    }
}
