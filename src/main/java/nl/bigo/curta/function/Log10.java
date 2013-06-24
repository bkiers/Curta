package nl.bigo.curta.function;

public class Log10 extends Function {

    public Log10() {
        super("log10");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.log10(super.getDouble(0, params));
    }
}
