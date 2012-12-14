package curta.function;

import java.util.Collections;
import java.util.List;

public class Max extends Function {

    public Max() {
        super("max");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, Integer.MAX_VALUE, params);

        List<Double> numbers = super.getNumbers(params);

        return Collections.max(numbers);
    }
}
