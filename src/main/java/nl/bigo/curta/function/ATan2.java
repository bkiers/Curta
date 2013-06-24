package nl.bigo.curta.function;

public class ATan2 extends Function {

    public ATan2() {
        super("atan2");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.atan2(super.getDouble(0, params), super.getDouble(1, params));
    }
}
