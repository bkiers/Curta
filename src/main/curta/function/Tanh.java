package curta.function;

import curta.Function;

import java.util.List;

public class Tanh extends Function {

    public Tanh() {
        super("tanh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.tanh(super.getNumber(0, params));
    }
}
