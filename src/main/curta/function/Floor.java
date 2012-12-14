package curta.function;

import curta.Function;

import java.util.List;

public class Floor extends Function {

    public Floor() {
        super("floor");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.floor(super.getNumber(0, params));
    }
}
