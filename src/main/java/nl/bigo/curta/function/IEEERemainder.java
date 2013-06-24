package nl.bigo.curta.function;

public class IEEERemainder extends Function {

    public IEEERemainder() {
        super("IEEEremainder");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.IEEEremainder(super.getDouble(0, params), super.getDouble(1, params));
    }
}
