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
              * the second parameter shows how many consecutive numbers are to be printed;
            - two natural numbers and properties to search for;
            - a property preceded by minus must not be present in numbers;
            - separate the parameters with one space;
            - enter 0 to exit."""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("")
                .replaceAll("\\s+", "");

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
                      happy: true
                        sad: false
                       even: false
                        odd: true"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testRangeOfNumber() {
        String expected = """
                9 is palindromic, spy, square, jumping, sad, odd
                   10 is duck, jumping, happy, even
                   11 is palindromic, sad, odd
                   12 is jumping, sad, even
                   13 is happy, odd
                   14 is buzz, sad, even
                   15 is sunny, sad, odd"""
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
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("9 3 DRAKE").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithValidProperty() {
        String expected = """
               10 is duck, jumping, happy, even
               20 is duck, sad, even
               30 is duck, sad, even"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("9 3 duck").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithValidAndInvalidProperty() {
        String expected = """
                The properties [POLINDROMIC] is wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1 2 sunny polindromic").replaceAll("\\s+", "");;

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithTwoInvalidProperties() {
        String expected = """
                The properties [BAZZ, POLINDROMIC] are wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]"""
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
               3 is palindromic, spy, sunny, jumping, sad, odd
               8 is palindromic, spy, sunny, jumping, sad, even"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 2 sunny palindromic").replaceAll("\\s+", "");;

        assertEquals(expected, result);
    }

    @Test
    void testNumberRangeWith3ValidProperties() {
        String expected = """
                10101 is buzz, duck, palindromic, jumping, sad, odd
                12121 is palindromic, jumping, sad, odd
                12321 is palindromic, square, jumping, happy, odd
                32123 is buzz, palindromic, jumping, sad, odd
                32323 is palindromic, jumping, sad, odd
                34343 is palindromic, jumping, sad, odd"""
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
                1 is palindromic, spy, square, jumping, happy, odd
                    2 is palindromic, spy, jumping, sad, even
                    3 is palindromic, spy, sunny, jumping, sad, odd
                    4 is palindromic, spy, square, jumping, sad, even
                    5 is palindromic, spy, jumping, sad, odd
                    6 is palindromic, spy, jumping, sad, even
                    7 is buzz, palindromic, spy, jumping, happy, odd
                    8 is palindromic, spy, sunny, jumping, sad, even
                    9 is palindromic, spy, square, jumping, sad, odd
                   10 is duck, jumping, happy, even"""
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

    @Test
    void testHappyNumber() {
        String expected = """
                1 is palindromic, spy, square, jumping, happy, odd
                    7 is buzz, palindromic, spy, jumping, happy, odd
                   10 is duck, jumping, happy, even
                   13 is happy, odd
                   19 is happy, odd"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 5 happy")
                .replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void test74() {
        String expected = """
                7 is buzz, palindromic, spy, jumping, happy, odd
                  231 is buzz, gapful, spy, sad, odd
                 1421 is buzz, spy, sad, odd
                15211 is buzz, spy, happy, odd
                21511 is buzz, spy, happy, odd
                22211 is buzz, spy, sad, odd
                31311 is buzz, spy, sad, odd
                51121 is buzz, spy, happy, odd
                112161 is buzz, spy, happy, odd
                121611 is buzz, spy, happy, odd
                216111 is buzz, gapful, spy, happy, odd
                611121 is buzz, spy, happy, odd
                1111127 is buzz, spy, sad, odd
                1111217 is buzz, spy, sad, odd
                1111271 is buzz, spy, sad, odd"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 15 odd spy -duck spy buzz")
                .replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void testMinusEven() {
        String expected = """
                1 is palindromic, spy, square, jumping, happy, odd
                3 is palindromic, spy, sunny, jumping, sad, odd
                5 is palindromic, spy, jumping, sad, odd"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 3 -EVEN")
                .replaceAll("\\s+", "");

        assertEquals(expected, result);
    }
}
