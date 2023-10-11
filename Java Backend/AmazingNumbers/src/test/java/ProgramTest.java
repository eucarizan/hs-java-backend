import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramTest {
    @Test
    void testEmptyInput() {
        String expected = """
                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - two natural numbers and a property to search for;
                - separate the parameters with one space;
                - enter 0 to exit.""";

        String output = Program.processRequest("").trim();

        assertEquals(expected, output);
    }

    @Test
    void testShouldHandleNotANumber() {
        String output = Program.processRequest("one").trim();

        assertEquals("The first parameter should be a natural number or zero.", output);
    }

    @Test
    void testNumberZero() {
        String output = Program.processRequest("0").trim();

        assertEquals("Goodbye!", output);
    }

    @Test
    void testNegativeNumber() {
        String output = Program.processRequest("-1").trim();

        assertEquals("The first parameter should be a natural number or zero.", output);
    }

    @Test
    void testValidNumber() {
        String expected = """
                Properties of 1
                       buzz: false
                       duck: false
                palindromic: true
                     gapful: false
                        spy: true
                     square: true
                      sunny: false
                    jumping: true
                       even: false
                        odd: true"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testRangeOfNumber() {
        String expected = """
                9 is palindromic, spy, square, jumping, odd
                   10 is duck, jumping, even
                   11 is palindromic, odd
                   12 is jumping, even
                   13 is odd
                   14 is buzz, even
                   15 is sunny, odd"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("9 7").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testRangeOfNumberZero2ndParam() {
        String expected = "The second parameter should be a natural number.";

        String output = Program.processRequest("9 0").trim();

        assertEquals(expected, output);
    }

    @Test
    void testRangeOfNumberNegative2ndParam() {
        String expected = "The second parameter should be a natural number.";

        String output = Program.processRequest("9 -10").trim();

        assertEquals(expected, output);
    }

    @Test
    void testNumberWithInvalidProperty() {
        String expected = """
                The property [DRAKE] is wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]""".replaceAll("\\s+", "");

        String output = Program.processRequest("9 3 DRAKE").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithValidProperty() {
        String expected = """
               10 is duck, jumping, even
               20 is duck, even
               30 is duck, even"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("9 3 duck").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithValidAndInvalidProperty() {
        String expected = """
                The properties [POLINDROMIC] is wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1 2 sunny polindromic").replaceAll("\\s+", "");;

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithTwoInvalidProperties() {
        String expected = """
                The properties [BAZZ, POLINDROMIC] are wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 2 bazz polindromic").replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeMutuallyExclusiveEvenOdd() {
        String expected = """
                The request contains mutually exclusive properties: [EVEN, ODD]
                There are no numbers with these properties."""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 7 even odd").replaceAll("\\s+", "");;

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeMutuallyExclusiveDuckSpy() {
        String expected = """
                The request contains mutually exclusive properties: [DUCK, SPY]
                There are no numbers with these properties."""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 7 duck spy").replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeMutuallyExclusiveSunnySquare() {
        String expected = """
                The request contains mutually exclusive properties: [SUNNY, SQUARE]
                There are no numbers with these properties."""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 7 sunny square").replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeWith2ValidProperties() {
        String expected = """
               3 is palindromic, spy, sunny, jumping, odd
               8 is palindromic, spy, sunny, jumping, even"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 2 sunny palindromic").replaceAll("\\s+", "");;

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeWith3ValidProperties() {
        String expected = """
                10101 is buzz, duck, palindromic, jumping, odd
                          12121 is palindromic, jumping, odd
                          12321 is palindromic, square, jumping, odd
                          32123 is buzz, palindromic, jumping, odd
                          32323 is palindromic, jumping, odd
                          34343 is palindromic, jumping, odd"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("999 6 jumping odd palindromic").replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testJumpingNumberForSingleDigit() {
        for (int i = 1; i < 10; i++) {
            String result = Program.processRequest(String.valueOf(i));
            Assertions.assertTrue(result.contains("jumping"));
        }
    }


    @Test
    void testNumberRangeForPropertyJumping() {
        String expected = """
                1 is palindromic, spy, square, jumping, odd
                    2 is palindromic, spy, jumping, even
                    3 is palindromic, spy, sunny, jumping, odd
                    4 is palindromic, spy, square, jumping, even
                    5 is palindromic, spy, jumping, odd
                    6 is palindromic, spy, jumping, even
                    7 is buzz, palindromic, spy, jumping, odd
                    8 is palindromic, spy, sunny, jumping, even
                    9 is palindromic, spy, square, jumping, odd
                   10 is duck, jumping, even"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 10 JUMPING").replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeWithExcludeProperty() {
        List<String> list = List.of(
                "-even, -odd",
                "-even, even",
                "-odd, odd",
                "duck, spy",
                "-duck, -spy",
                "-duck, duck",
                "-spy, spy",
                "sunny, square",
                "-sunny, -square",
                "-sunny, sunny",
                "-square, square",
                "-buzz, buzz",
                "-palindromic, palindromic",
                "-gapful, gapful",
                "-jumping, jumping"
        );

        for (String str : list) {
            String[] parts = str.split(", ");
            String expected = String.format("""
                The request contains mutually exclusive properties: [%s, %s]
                There are no numbers with these properties.""", parts[0].toUpperCase(), parts[1].toUpperCase())
                    .replaceAll("\\s+", "")
                    ;

            String result = Program.processRequest(
                    String.format("1 3 %s %s", parts[0], parts[1]))
                    .replaceAll("\\s+", "")
                    ;

            assertEquals(expected, result);
        }
    }
}
