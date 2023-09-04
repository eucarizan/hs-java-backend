import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @Test
    public void testTernaryOperatorWithTrueCondition() {
        Predicate<Integer> condition = x -> x > 5;
        Function<Integer, String> ifTrue = x -> "Greater than 5";
        Function<Integer, String> ifFalse = x -> "Less than or equal to 5";

        Function<Integer, String> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        String result = operator.apply(10);
        assertEquals("Greater than 5", result);
    }

    @Test
    public void testTernaryOperatorWithFalseCondition() {
        Predicate<Integer> condition = x -> x > 5;
        Function<Integer, String> ifTrue = x -> "Greater than 5";
        Function<Integer, String> ifFalse = x -> "Less than or equal to 5";

        Function<Integer, String> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        String result = operator.apply(3);
        assertEquals("Less than or equal to 5", result);
    }

    //    @Test
//    public void testTernaryOperatorWithDifferentTypes() {
//        Predicate<String> condition = str -> str.length() > 5;
//        Function<String, Integer> ifTrue = str -> str.length();
//        Function<String, Double> ifFalse = str -> Double.parseDouble(str);
//
//        Function<String, Number> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);
//
//        Number result1 = operator.apply("HelloWorld");
//        Number result2 = operator.apply("3.14");
//
//        assertTrue(result1 instanceof Integer);
//        assertTrue(result2 instanceof Double);
//    }
    @Test
    public void testTernaryOperatorWithNullCondition() {
        Predicate<Integer> condition = null;
        Function<Integer, String> ifTrue = x -> "True";
        Function<Integer, String> ifFalse = x -> "False";

        Function<Integer, String> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        // When the condition is null, it should always choose the "ifFalse" branch.
        String result = operator.apply(42);
        assertEquals("False", result);
    }

    @Test
    public void testTernaryOperatorWithNullIfTrueFunction() {
        Predicate<Integer> condition = x -> x > 5;
        Function<Integer, String> ifTrue = null;
        Function<Integer, String> ifFalse = x -> "False";

        Function<Integer, String> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        // When the "ifTrue" function is null, it should always choose the "ifFalse" branch.
        String result = operator.apply(10);
        assertEquals("False", result);
    }

    @Test
    public void testTernaryOperatorWithNullIfFalseFunction() {
        Predicate<Integer> condition = x -> x > 5;
        Function<Integer, String> ifTrue = x -> "True";
        Function<Integer, String> ifFalse = null;

        Function<Integer, String> operator = Operator.ternaryOperator(condition, ifTrue, ifFalse);

        // When the "ifFalse" function is null, it should always choose the "ifTrue" branch.
        String result = operator.apply(3);
        assertEquals("True", result);
    }
}
