package curta.function;

import curta.Function;

import java.util.List;

public class NextUp extends Function {

    public NextUp() {
        super("nextUp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.nextUp(super.getNumber(0, params));
    }
}
