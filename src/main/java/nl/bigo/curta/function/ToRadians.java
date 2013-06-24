package nl.bigo.curta.function;

public class ToRadians extends Function {

    public ToRadians() {
        super("toRadians");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.toRadians(super.getDouble(0, params));
    }
}
