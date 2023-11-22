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
    void buyCoffeeSuccessTest() {
        String expected = "I have enough resources, making you a coffee!";
        String input = "buy, 3";
        String result = coffeeMaker.takeOrder(input);

        assertEquals(expected, result);
    }

    @Test
    void buyCoffeeInsufficientWaterTest() {
        String expected = "Sorry, not enough water!";
        String order1 = "buy, 3";
        String order2 = "buy, 2";
        coffeeMaker.takeOrder(order1);
        String result = coffeeMaker.takeOrder(order2);

        assertEquals(expected, result);
    }

    @Test
    void refillMachineTest() {
        String expected = "filled";
        String input = "fill, 2000, 500, 100, 10";
        String result = coffeeMaker.takeOrder(input);

        assertEquals(expected, result);
    }

    @Test
    void takeMoneyTest() {
        String expected = "I gave you $550";
        String result = coffeeMaker.takeOrder("take");

        assertEquals(expected, result);
    }

    @Test
    void showRemainingTest() {
        String expected = """
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money""";
        String result = coffeeMaker.takeOrder("remaining");

        assertEquals(expected, result);
    }
}