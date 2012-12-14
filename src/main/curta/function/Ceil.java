package curta.function;

import curta.Function;

import java.util.List;

public class Ceil extends Function {

    public Ceil() {
        super("ceil");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.ceil(super.getNumber(0, params));
    }
}
