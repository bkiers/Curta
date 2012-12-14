package curta.function;

import curta.Function;

import java.util.List;

public class ToDegrees extends Function {

    public ToDegrees() {
        super("toDegrees");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.toDegrees(super.getNumber(0, params));
    }
}
