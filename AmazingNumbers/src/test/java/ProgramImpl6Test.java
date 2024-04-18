import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramImpl6Test {

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
        // - two natural numbers and two properties to search for;

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
                       even: false
                        odd: true"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testRangeOfNumber() {
        String expected = """
                9 is palindromic, spy, square, odd
                   10 is duck, even
                   11 is palindromic, odd
                   12 is even
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
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]""".replaceAll("\\s+", "");

        String output = Program.processRequest("9 3 DRAKE").replaceAll("\\s+", "");

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithValidProperty() {
        String expected = """
               10 is duck, even
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
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]"""
                .replaceAll("\\s+", "");

        String output = Program.processRequest("1 2 sunny polindromic").replaceAll("\\s+", "");;

        assertEquals(expected, output);
    }

    @Test
    void testNumberRangeWithTwoInvalidProperties() {
        String expected = """
                The properties [BAZZ, POLINDROMIC] are wrong.
                Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]"""
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
               3 is palindromic, spy, sunny, odd
               8 is palindromic, spy, sunny, even"""
                .replaceAll("\\s+", "");

        String result = Program.processRequest("1 2 sunny palindromic").replaceAll("\\s+", "");;

        assertEquals(expected, result);
    }

    // TODO - test number in range with valid three properties
    @Test
    void testNumberRangeWith3ValidProperties() {
        String expected = """
                    9 is palindromic, spy, square, odd
                  121 is palindromic, gapful, square, odd
                10201 is duck, palindromic, square, odd
                12321 is palindromic, square, odd
                14641 is palindromic, gapful, square, odd
                94249 is palindromic, square, odd"""
                .replaceAll("\\s+", "");

        /*
        String expected = """
                10,101 is buzz, duck, palindromic, jumping, odd
                          12,121 is palindromic, jumping, odd
                          12,321 is palindromic, square, jumping, odd
                          32,123 is buzz, palindromic, jumping, odd
                          32,323 is palindromic, jumping, odd
                          34,343 is palindromic, jumping, odd""";
         */

        String result = Program.processRequest("3 6 square odd palindromic").replaceAll("\\s+", "");;
        // 999 6 jumping odd palindromic

        assertEquals(expected, result);
    }
}
