package nl.bigo.curta.function;

public class Cbrt extends Function {

    public Cbrt() {
        super("cbrt");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cbrt(super.getDouble(0, params));
    }
}
