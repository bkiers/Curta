package curta.function;

import curta.Function;

import java.util.List;

public class Log10 extends Function {

    public Log10() {
        super("log10");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.log10(super.getNumber(0, params));
    }
}
