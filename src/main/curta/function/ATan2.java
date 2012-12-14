package curta.function;

import curta.Function;

import java.util.List;

public class ATan2 extends Function {

    public ATan2() {
        super("atan2");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.atan2(super.getNumber(0, params), super.getNumber(1, params));
    }
}
