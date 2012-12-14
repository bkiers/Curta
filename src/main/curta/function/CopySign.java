package curta.function;

import curta.Function;

import java.util.List;

public class CopySign extends Function {

    public CopySign() {
        super("copySign");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.copySign(super.getNumber(0, params), super.getNumber(1, params));
    }
}
