package nl.bigo.curta.function;

public class ATan extends Function {

    public ATan() {
        super("atan");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.atan(super.getDouble(0, params));
    }
}
