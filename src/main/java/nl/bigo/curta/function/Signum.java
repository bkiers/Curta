package nl.bigo.curta.function;

public class Signum extends Function {

    public Signum() {
        super("signum");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.signum(super.getDouble(0, params));
    }
}
