package nl.bigo.curta.function;

public class Round extends Function {

    public Round() {
        super("round");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.round(super.getDouble(0, params));
    }
}
