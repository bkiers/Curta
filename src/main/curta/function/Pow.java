package curta.function;

import curta.Function;

import java.util.List;

public class Pow extends Function {

    public Pow() {
        super("pow");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.pow(super.getNumber(0, params), super.getNumber(1, params));
    }
}
