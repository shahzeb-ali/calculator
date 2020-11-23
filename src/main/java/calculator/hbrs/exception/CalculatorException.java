package calculator.hbrs.exception;

public class CalculatorException extends Exception {

    public CalculatorException(Exception e) {
        super(e);
    }

    public CalculatorException(String message) {
        super(message);
    }
}
