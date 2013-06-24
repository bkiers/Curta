package nl.bigo.curta.function;

public class Pow extends Function {

    public Pow() {
        super("pow");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.pow(super.getDouble(0, params), super.getDouble(1, params));
    }
}
