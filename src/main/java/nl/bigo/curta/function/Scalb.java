package nl.bigo.curta.function;

public class Scalb extends Function {

    public Scalb() {
        super("scalb");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.scalb(super.getDouble(0, params), super.getLong(1, params).intValue());
    }
}
