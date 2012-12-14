package curta.function;

import curta.Function;

import java.util.List;

public class ASin extends Function {

    public ASin() {
        super("asin");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.asin(super.getNumber(0, params));
    }
}
