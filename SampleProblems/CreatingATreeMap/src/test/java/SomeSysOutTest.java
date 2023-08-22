//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//// junit4
//import org.junit.Test;
//import static org.assertj.core.api.Assertions.assertThat;
//
//// junit5
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SomeSysOutTest {
//    private final PrintStream standardOut = System.out;
//    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//
//    @BeforeEach // @Before
//    public void setUp() {
//        System.setOut(new PrintStream(outputStreamCaptor));
//    }
//
//    @AfterEach // @After
//    public void tearDown() {
//        System.setOut(standardOut);
//    }
//
//    @Test
//    public void test() {
//        Assert.assertEquals("Expected output", outputStreamCaptor.toString());
//    }
//}
