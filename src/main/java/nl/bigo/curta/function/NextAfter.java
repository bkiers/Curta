package nl.bigo.curta.function;

public class NextAfter extends Function {

    public NextAfter() {
        super("nextAfter");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.nextAfter(super.getDouble(0, params), super.getDouble(1, params));
    }
}
