package curta.function;

import curta.Function;

import java.util.List;

public class Hypot extends Function {

    public Hypot() {
        super("hypot");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.hypot(super.getNumber(0, params), super.getNumber(1, params));
    }
}
