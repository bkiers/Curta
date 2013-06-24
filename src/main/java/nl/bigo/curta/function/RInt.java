package nl.bigo.curta.function;

public class RInt extends Function {

    public RInt() {
        super("rint");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.rint(super.getDouble(0, params));
    }
}
