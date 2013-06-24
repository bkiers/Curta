package nl.bigo.curta.function;

public class Log extends Function {

    public Log() {
        super("log");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.log(super.getDouble(0, params));
    }
}
