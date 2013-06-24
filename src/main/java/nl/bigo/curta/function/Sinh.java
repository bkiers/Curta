package nl.bigo.curta.function;

public class Sinh extends Function {

    public Sinh() {
        super("sinh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.sinh(super.getDouble(0, params));
    }
}
