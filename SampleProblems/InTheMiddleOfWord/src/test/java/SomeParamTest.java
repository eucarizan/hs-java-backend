 import org.junit.jupiter.params.ParameterizedTest;
 import org.junit.jupiter.params.provider.CsvSource;

 import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

     @ParameterizedTest(name = "Test{index}({2}): ({0}) middle of a word in ({1})")
     @CsvSource(value = {
             "Gramm:Java is the most popular programming language:YES",
             "Press:Regular expressions is hard to read, isnt it?:YES",
             "some:Wow! How awesome is that!:NO"
     }, delimiter = ':')
    public void test(String part, String line, String expected) {
         assertEquals(expected, MiddleOfWord.find(part, line));
    }
}
