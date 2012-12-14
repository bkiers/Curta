package curta.function;

import curta.Function;

import java.util.List;

public class RInt extends Function {

    public RInt() {
        super("rint");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.rint(super.getNumber(0, params));
    }
}
