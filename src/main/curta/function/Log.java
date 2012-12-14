package curta.function;

import curta.Function;

import java.util.List;

public class Log extends Function {

    public Log() {
        super("log");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.log(super.getNumber(0, params));
    }
}
