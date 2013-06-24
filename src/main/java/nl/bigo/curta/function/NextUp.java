package nl.bigo.curta.function;

public class NextUp extends Function {

    public NextUp() {
        super("nextUp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.nextUp(super.getDouble(0, params));
    }
}
