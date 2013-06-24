package nl.bigo.curta.function;

public class Random extends Function {

    public Random() {
        super("random");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(0, 0, params);

        return Math.random();
    }
}
