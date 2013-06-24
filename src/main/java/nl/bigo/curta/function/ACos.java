package nl.bigo.curta.function;

public class ACos extends Function {

    public ACos() {
        super("acos");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.acos(super.getDouble(0, params));
    }
}
