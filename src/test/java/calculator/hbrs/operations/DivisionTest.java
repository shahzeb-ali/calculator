package calculator.hbrs.operations;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DivisionTest {

	@Test
	void testOp() {
		 Operation division = new Division();
		 assertThrows(ArithmeticException.class, () -> { division.op(3, 0); });
		 
	}

}
