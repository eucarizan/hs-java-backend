# Proper arguments

## Description
Imagine that you have to test this class:

```java
public class Calculator {
private CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
        this.engine = engine;
    }

    public int sum(int a, int b) {
        return engine.calculate(a, b, "+");
    }
}
```

This is the corresponding unit test:

```java
class CalculatorTest {
private CalculatorEngine engine = mock(CalculatorEngine.class);
private Calculator calculator = new Calculator(engine);

    @Test
    void test() {
        when(engine.calculate(eq(2), 3, anyString())).thenReturn(5);

        int result = calculator.sum(2, 3);

        assertEquals(5, result);
    }
}
```

What will happen if you run it?

## Options and answer
- [ ] The test will not compile
- [ ] The test will fail with AssertionFailedError
- [ ] The test will be successfully passed
- [x] The test will fail with InvalidUseOfMatchersException

## Tags
- errorless code
- testing tools and libraries
- mockito