package nl.bigo.curta.function;

public class Cos extends Function {

    public Cos() {
        super("cos");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.cos(super.getDouble(0, params));
    }
}
