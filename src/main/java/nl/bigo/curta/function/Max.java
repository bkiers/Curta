package nl.bigo.curta.function;

public class Max extends Function {

    public Max() {
        super("max");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.max(super.getDouble(0, params), super.getDouble(1, params));
    }
}
