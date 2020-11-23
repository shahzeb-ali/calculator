package calculator.hbrs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import calculator.hbrs.exception.CalculatorException;
import calculator.hbrs.exception.UnknownOperationException;
import calculator.hbrs.operations.Addition;
import calculator.hbrs.operations.Division;
import calculator.hbrs.operations.Operation;

class CalculatorTest {

	@Test
	void testCalculateException() {

		assertThrows(UnknownOperationException.class, () -> {
			new Calculator(Map.ofEntries(Map.entry('#', new Addition()))).calculate(3, 6, '+');
		});
	}

	@Test
	void testCalculateValues() throws CalculatorException {

		Calculator clc =new  Calculator(Map.ofEntries(Map.entry('+', new Addition()), Map.entry('/', new Division()))) ;
		
		Operation add = Mockito.mock(Addition.class);
		Operation div = Mockito.mock(Division.class);
	
		
		Mockito.when(clc.calculate(1.0, 2.0, '+')).thenReturn(new CalculationResult(1.0,2.0,3.0,'+'));


		
		CalculationResult clcResult = new CalculationResult(3.0, 6.0, 9.0, '+');
		assertEquals(clcResult.toString(),
				new Calculator(Map.ofEntries(Map.entry('+', new Addition()))).calculate(3, 6, '+').toString());
	}
}
