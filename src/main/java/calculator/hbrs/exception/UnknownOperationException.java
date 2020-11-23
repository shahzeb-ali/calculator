package calculator.hbrs.exception;

public class UnknownOperationException extends CalculatorException {
    public UnknownOperationException(char op) {
        super(String.format("Unknown operation %s", op));
    }
}
