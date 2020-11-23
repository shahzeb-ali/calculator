package calculator.hbrs.operations;

public class Addition implements Operation {
    @Override
    public double op(double x, double y) {
        return x + y;
    }
}
