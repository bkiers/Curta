package nl.bigo.curta.function;

public class Hypot extends Function {

    public Hypot() {
        super("hypot");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.hypot(super.getDouble(0, params), super.getDouble(1, params));
    }
}
