package curta.function;

import curta.Function;

import java.util.List;

public class Random extends Function {

    public Random() {
        super("random");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(0, 0, params);

        return Math.random();
    }
}
