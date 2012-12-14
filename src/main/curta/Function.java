package curta;

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

    protected final Double getNumber(int index, Object... params) {

        Object o = params[index];

        if(o == null || !(o instanceof Number)) {
            throw new RuntimeException("parameter " + (index + 1) + " in function " + id +
                    " is expected to be a number, encountered: " + o);
        }

        return (Double)o;
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

/*
static double abs(double a)
static double acos(double a)
static double asin(double a)
static double atan(double a)
static double atan2(double y, double x)
static double cbrt(double a)
static double ceil(double a)
static double copySign(double magnitude, double sign)
static double cos(double a)
static double cosh(double x)
static double exp(double a)
static double expm1(double x)
static double floor(double a)
static int getExponent(double d)
static double hypot(double x, double y)
static double IEEEremainder(double f1, double f2)
static double log(double a)
static double log10(double a)
static double log1p(double x)
static double max(double a, double b)
static double min(double a, double b)
static double nextAfter(double start, double direction)
static double nextUp(double d)
static double pow(double a, double b)
static double random()
static double rint(double a)
static long round(double a)
static double scalb(double d, int scaleFactor)
static double signum(double d)
static double sin(double a)
static double sinh(double x)
static double sqrt(double a)
static double tan(double a)
static double tanh(double x)
static double toDegrees(double angrad)
static double toRadians(double angdeg)
static double ulp(double d)
*/