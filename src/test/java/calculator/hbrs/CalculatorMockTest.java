package calculator.hbrs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import calculator.hbrs.exception.CalculatorException;
import calculator.hbrs.exception.UnknownOperationException;
import calculator.hbrs.operations.Addition;
import calculator.hbrs.operations.Division;
import calculator.hbrs.operations.Operation;

class CalculatorMockTest {

	Calculator clc;
	Map<Character, Operation> m;

	@BeforeEach
	void setup() throws CalculatorException {

		Operation add = Mockito.mock(Addition.class);

		Operation div = Mockito.mock(Division.class);

		m = Map.ofEntries(Map.entry('+', new Addition()), Map.entry('/', new Division()));

		clc = new Calculator(m);

		Mockito.when(add.op(1, 2)).thenReturn(3.0);
		Mockito.when(div.op(2, 1)).thenReturn(2.0);
		Mockito.when(div.op(4.0, 0.0)).thenThrow(new ArithmeticException());

	}

	@Test
	void testCalculatorAdd() throws CalculatorException {
		CalculationResult cr = new CalculationResult(1.0, 2.0, 3.0, '+');
		assertEquals(clc.calculate(1, 2, '+').toString(), cr.toString());
	}

	@Test
	void testCalculatordiv() throws CalculatorException {
		CalculationResult cr = new CalculationResult(2.0, 1.0, 2.0, '/');
		assertEquals(clc.calculate(2, 1, '/').toString(), cr.toString());

	}

	@Test
	void ArithmeticExceptionTest() {

		assertThrows(CalculatorException.class, () -> clc.calculate(4.0, 0.0, '/'));
	}

	@Test
	void UnknownOperationExceptionTest() {
		assertThrows(UnknownOperationException.class, () -> clc.calculate(4.0, 0.0, '#'));
	}

}
