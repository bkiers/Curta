package curta.function;

import curta.Function;

import java.util.List;

public class Abs extends Function {

    public Abs() {
        super("abs");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.abs(super.getNumber(0, params));
    }
}
