package nl.bigo.curta.function;

public class ToDegrees extends Function {

    public ToDegrees() {
        super("toDegrees");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.toDegrees(super.getDouble(0, params));
    }
}
