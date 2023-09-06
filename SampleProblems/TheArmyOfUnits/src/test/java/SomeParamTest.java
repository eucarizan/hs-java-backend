import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "when Army.withUnits({0}), then {1}")
    @DisplayName("param test")
    @CsvSource(value = {
            "0 : no army",
            "3 : pack",
            "110 : throng",
            "912 : zounds",
            "1000 : legion",
    }, delimiter = ':')
    public void test(int input, String expected) {
        String result = Army.withUnits(input);

        assertEquals(expected, result);
    }

    @Test
    public void testWithUnitsForZero() {
        assertEquals("no army", Army.withUnits(0));
    }

    @Test
    public void testWithUnitsForSingleUnit() {
        assertEquals("pack", Army.withUnits(1));
    }

    @Test
    public void testWithUnitsForSmallThrong() {
        assertEquals("pack", Army.withUnits(19));
    }

    @Test
    public void testWithUnitsForThrongBoundary() {
        assertEquals("throng", Army.withUnits(20));
    }

    @Test
    public void testWithUnitsForLargeThrong() {
        assertEquals("throng", Army.withUnits(249));
    }

    @Test
    public void testWithUnitsForZoundsBoundary() {
        assertEquals("zounds", Army.withUnits(250));
    }

    @Test
    public void testWithUnitsForLargeZounds() {
        assertEquals("zounds", Army.withUnits(999));
    }

    @Test
    public void testWithUnitsForLegionBoundary() {
        assertEquals("legion", Army.withUnits(1000));
    }

    @Test
    public void testWithUnitsForLargeLegion() {
        assertEquals("legion", Army.withUnits(1000000));
    }

}
