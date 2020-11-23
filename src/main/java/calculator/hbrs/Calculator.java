package calculator.hbrs;

import calculator.hbrs.exception.CalculatorException;
import calculator.hbrs.exception.UnknownOperationException;
import calculator.hbrs.operations.Operation;

import java.util.Map;

public class Calculator {
    private Map<Character, Operation> operations;

    public Calculator(Map<Character, Operation> operations) {
        this.operations = operations;
    }

    public CalculationResult calculate(double x, double y, char op) throws CalculatorException {
        if (!this.operations.containsKey(op)) {
            throw new UnknownOperationException(op);
        }

        try {
            double result = this.operations.get(op).op(x, y);

            return new CalculationResult(x, y, result, op);
        } catch (ArithmeticException e) {
            throw new CalculatorException(e);
        }

    }
}

