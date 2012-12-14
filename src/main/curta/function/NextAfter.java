package curta.function;

import curta.Function;

import java.util.List;

public class NextAfter extends Function {

    public NextAfter() {
        super("nextAfter");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.nextAfter(super.getNumber(0, params), super.getNumber(1, params));
    }
}
