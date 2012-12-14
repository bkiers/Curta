package curta.function;

import curta.Function;

import java.util.List;

public class Sqrt extends Function {

    public Sqrt() {
        super("sqrt");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.sqrt(super.getNumber(0, params));
    }
}
