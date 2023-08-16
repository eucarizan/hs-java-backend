import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {

    @Test
    public void testNumberIs11() {
        int number = 11;
        assertThat(Number.sign(number)).isEqualTo(1);
    }

    @Test
    public void testNumberIs1() {
        int number = 1;
        assertThat(Number.sign(number)).isEqualTo(1);
    }

    @Test
    public void testNumberIs0() {
        int number = 0;
        assertThat(Number.sign(number)).isEqualTo(0);
    }

    @Test
    public void testNumberIsMinus3() {
        int number = -3;
        assertThat(Number.sign(number)).isEqualTo(-1);
    }

    @ParameterizedTest(name = "{0} is {1} (1 - positive, -1 - negative)")
    @CsvSource({"11, 1", "1, 1", "0, 0", "-3, -1"})
    public void testIntCompare(int number, int expected) {
        assertEquals(expected, Number.intCompare(number));
    }
}
