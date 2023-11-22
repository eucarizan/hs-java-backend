import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeMachineTest {

    CoffeeMaker coffeeMaker;

    @BeforeEach
    void setUp() {
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    void buyCoffeeTest() {
        String expected = """
                The coffee machine has:
                200 ml of water
                440 ml of milk
                108 g of coffee beans
                8 disposable cups
                $556 of money
                """.trim().replaceAll("\\s+", "");

        String input = "buy, 3";

        String result = coffeeMaker.takeOrder(input)
                .trim().replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void refillMachineTest() {
        String expected = """
                The coffee machine has:
                2400 ml of water
                1040 ml of milk
                220 g of coffee beans
                19 disposable cups
                $550 of money
                """.trim().replaceAll("\\s+", "");

        String input = "fill, 2000, 500, 100, 10";

        String result = coffeeMaker.takeOrder(input)
                .trim().replaceAll("\\s+", "");

        assertEquals(expected, result);
    }

    @Test
    void takeMoneyTest() {
        String expected = """
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $0 of money""";//.trim().replaceAll("\\s+", "");
        String result = coffeeMaker.takeOrder("take");

        assertEquals("550", result);
        assertEquals(expected, coffeeMaker.afterTake());
    }
}