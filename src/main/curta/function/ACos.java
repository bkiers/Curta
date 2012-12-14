package curta.function;

import curta.Function;

import java.util.List;

public class ACos extends Function {

    public ACos() {
        super("acos");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.acos(super.getNumber(0, params));
    }
}
