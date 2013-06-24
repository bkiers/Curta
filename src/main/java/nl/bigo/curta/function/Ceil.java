package nl.bigo.curta.function;

public class Ceil extends Function {

    public Ceil() {
        super("ceil");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.ceil(super.getDouble(0, params));
    }
}
