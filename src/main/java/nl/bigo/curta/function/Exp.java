package nl.bigo.curta.function;

public class Exp extends Function {

    public Exp() {
        super("exp");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.exp(super.getDouble(0, params));
    }
}
