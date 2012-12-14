package curta.function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Min extends Function {

    public Min() {
        super("min");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, Integer.MAX_VALUE, params);

        List<Double> numbers = super.getNumbers(params);

        return Collections.min(numbers);
    }
}
