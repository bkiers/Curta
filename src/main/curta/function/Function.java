package curta.function;

import java.util.ArrayList;
import java.util.List;

public abstract class Function {

    public final String id;

    public Function(String id) {

        if(id == null) {
            throw new RuntimeException("Function id cannot be null");
        }

        this.id = id;
    }

    protected final void checkNumberOfParams(int minNumber, int maxNumber, Object... params) {

        int numberOfParameters = params == null ? 0 : params.length;

        if(numberOfParameters < minNumber) {
            throw new RuntimeException("the function " + id + " must have at least " + minNumber +
                    " parameters, encountered " + numberOfParameters + " parameters");
        }

        if(numberOfParameters > maxNumber) {
            throw new RuntimeException("the function " + id + " can have at most " + maxNumber +
                    " parameters, encountered " + numberOfParameters + " parameters");
        }
    }

    protected final List<Double> getNumbers(Object... params) {

        List<Double> numbers = new ArrayList<Double>();

        if(params != null) {

            for(Object o : params) {

                if(o == null || !(o instanceof Number)) {
                    throw new RuntimeException("the function " + id + " is only expected " +
                            "to have numbers as parameter, encountered parameter: " + o);
                }

                numbers.add(((Number)o).doubleValue());
            }
        }

        return numbers;
    }

    public abstract Object eval(Object... params);
}
