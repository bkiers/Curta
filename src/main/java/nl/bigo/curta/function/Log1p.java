package nl.bigo.curta.function;

public class Log1p extends Function {

    public Log1p() {
        super("log1p");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.log1p(super.getDouble(0, params));
    }
}
