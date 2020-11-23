package calculator.hbrs.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    @Test
    void opReturnsExpectedResult() {
        Operation addition = new Addition();

        assertEquals(2.0, addition.op(1.0, 1.0));
    }
}
