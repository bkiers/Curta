package curta.function;

import curta.Function;

import java.util.List;

public class Round extends Function {

    public Round() {
        super("round");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.round(super.getNumber(0, params));
    }
}
