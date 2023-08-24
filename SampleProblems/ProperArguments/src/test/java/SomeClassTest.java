import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    private final CalculatorEngine engine = mock(CalculatorEngine.class);
    private final Calculator calculator = new Calculator(engine);

    @Test
    void test() {
        when(engine.calculate(eq(2), 3, anyString())).thenReturn(5);

        int result = calculator.sum(2, 3);

        assertEquals(5, result);
    }
}