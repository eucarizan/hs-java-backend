import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} parse(url) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "sampleTestWithPass ; https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost ; " +
                    "[pass : 12345, port : 8080, cookie : not found, host : localhost, password : 12345]",
            "sampleTestWithoutPass ; https://target.com/index.html?port=8080&cookie=&host=localhost ; " +
                    "[port : 8080, cookie : not found, host : localhost]"
    }, delimiter = ';')
    public void test(String name, String input, String expected) {
        String result = ParseUrl.parse(input).toString();

        assertEquals(expected, result);
    }

    @Test
    public void testParseUrlWithMissingValues() {
        String url = "https://target.com/index.html?pass=&port=&cookie=&host=";
        List<String> expected = List.of("pass : not found", "port : not found", "cookie : not found", "host : not found");
        assertEquals(expected, ParseUrl.parse(url));
    }

    @Test
    public void testParseUrlWithSpecialCharacters() {
        String url = "https://target.com/index.html?pass=%20%26%3D&port=8080&cookie=&host=localhost";
        List<String> expected = List.of("pass : %20%26%3D", "port : 8080", "cookie : not found", "host : localhost", "password : %20%26%3D");
        assertEquals(expected, ParseUrl.parse(url));
    }

    @Test
    public void testParseUrlWithEmptyQuery() {
        String url = "https://target.com/index.html?";
        List<String> expected = List.of();
        assertEquals(expected, ParseUrl.parse(url));
    }

    @Test
    public void testParseUrlWithOnlyPassword() {
        String url = "https://target.com/index.html?pass=secret";
        List<String> expected = List.of("pass : secret", "password : secret");
        assertEquals(expected, ParseUrl.parse(url));
    }

    @Test
    public void testParseUrlWithMultiplePasswords() {
        String url = "https://target.com/index.html?pass=12345&password=secret";
        List<String> expected = List.of("pass : 12345", "password : secret", "password : 12345");
        assertEquals(expected, ParseUrl.parse(url));
    }

    @Test
    public void testParseUrlWithSpecialCharactersInPassword() {
        String url = "https://target.com/index.html?pass=%20%26%3D%23";
        List<String> expected = List.of("pass : %20%26%3D%23", "password : %20%26%3D%23");
        assertEquals(expected, ParseUrl.parse(url));
    }

}
