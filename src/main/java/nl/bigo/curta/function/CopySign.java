package nl.bigo.curta.function;

public class CopySign extends Function {

    public CopySign() {
        super("copySign");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(2, 2, params);

        return Math.copySign(super.getDouble(0, params), super.getDouble(1, params));
    }
}
