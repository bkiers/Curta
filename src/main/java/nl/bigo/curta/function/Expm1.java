package nl.bigo.curta.function;

public class Expm1 extends Function {

    public Expm1() {
        super("expm1");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.expm1(super.getDouble(0, params));
    }
}
