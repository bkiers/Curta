package curta.function;

import curta.Function;

import java.util.List;

public class Tan extends Function {

    public Tan() {
        super("tan");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.tan(super.getNumber(0, params));
    }
}
