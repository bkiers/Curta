package nl.bigo.curta.function;

public class Sqrt extends Function {

    public Sqrt() {
        super("sqrt");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.sqrt(super.getDouble(0, params));
    }
}
