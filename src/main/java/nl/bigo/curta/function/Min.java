package nl.bigo.curta.function;

public class Min extends Function {

    public Min() {
        super("min");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.min(super.getDouble(0, params), super.getDouble(1, params));
    }
}
