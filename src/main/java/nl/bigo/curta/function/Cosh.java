package nl.bigo.curta.function;

public class Cosh extends Function {

    public Cosh() {
        super("cosh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cosh(super.getDouble(0, params));
    }
}
