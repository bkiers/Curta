package curta.function;

import curta.Function;

import java.util.List;

public class Exp extends Function {

    public Exp() {
        super("exp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.exp(super.getNumber(0, params));
    }
}
