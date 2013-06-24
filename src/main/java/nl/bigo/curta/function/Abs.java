package nl.bigo.curta.function;

public class Abs extends Function {

    public Abs() {
        super("abs");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.abs(super.getDouble(0, params));
    }
}
