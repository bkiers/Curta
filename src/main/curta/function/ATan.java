package curta.function;

import curta.Function;

import java.util.List;

public class ATan extends Function {

    public ATan() {
        super("atan");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.atan(super.getNumber(0, params));
    }
}
