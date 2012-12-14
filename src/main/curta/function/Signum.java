package curta.function;

import curta.Function;

import java.util.List;

public class Signum extends Function {

    public Signum() {
        super("signum");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.signum(super.getNumber(0, params));
    }
}
