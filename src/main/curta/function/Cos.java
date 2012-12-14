package curta.function;

import curta.Function;

import java.util.List;

public class Cos extends Function {

    public Cos() {
        super("cos");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cos(super.getNumber(0, params));
    }
}
