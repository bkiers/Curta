package curta.function;

import curta.Function;

import java.util.List;

public class IEEERemainder extends Function {

    public IEEERemainder() {
        super("IEEEremainder");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.IEEEremainder(super.getNumber(0, params), super.getNumber(1, params));
    }
}
