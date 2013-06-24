package nl.bigo.curta.function;

public class Tanh extends Function {

    public Tanh() {
        super("tanh");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.tanh(super.getDouble(0, params));
    }
}
