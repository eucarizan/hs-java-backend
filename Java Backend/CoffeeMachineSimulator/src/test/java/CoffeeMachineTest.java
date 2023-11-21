import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeMachineTest {
    @Test
    void shouldMakeCoffee() {
        String expected = """
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!""".trim();

        assertEquals(expected, CoffeeMachine.makeCoffee().trim());
    }
}