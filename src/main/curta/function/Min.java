package curta.function;

import curta.Function;

import java.util.Collections;
import java.util.List;

public class Min extends Function {

    public Min() {
        super("min");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.min(super.getNumber(0, params), super.getNumber(1, params));
    }
}
