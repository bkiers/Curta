package nl.bigo.curta.function;

public class ASin extends Function {

    public ASin() {
        super("asin");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.asin(super.getDouble(0, params));
    }
}
