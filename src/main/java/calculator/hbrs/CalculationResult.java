package calculator.hbrs;

public class CalculationResult {

    private String result;

    public CalculationResult(double x, double y, double z, char op) {
        this.result = String.format("%.1f %s %.1f = %.1f", x, op, y, z);
    }

    @Override
    public String toString() {
        return this.result;
    }
}
