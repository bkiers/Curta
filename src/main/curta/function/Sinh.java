package curta.function;

import curta.Function;

import java.util.List;

public class Sinh extends Function {

    public Sinh() {
        super("sinh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.sinh(super.getNumber(0, params));
    }
}
