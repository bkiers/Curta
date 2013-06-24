package nl.bigo.curta.function;

public class Ulp extends Function {

    public Ulp() {
        super("ulp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.ulp(super.getDouble(0, params));
    }
}
