import java.util.Arrays;

public class CoffeeMaker {
    CoffeeMachine coffeeMachine;

    public String takeOrder(String command) {
        coffeeMachine = new CoffeeMachine();
        String[] parts = command.split(", ");
        int[] refill = Arrays.stream(parts).skip(1).mapToInt(Integer::parseInt).toArray();

        Order order = Order.valueOf(parts[0].toUpperCase());
        return switch (order) {
            case BUY -> buy(getCoffeeType(Integer.parseInt(parts[1])));
            case FILL -> fill(refill[0], refill[1], refill[2], refill[3]);
            case TAKE -> take();
        };
    }

    private String buy(CoffeeType type) {
        coffeeMachine.updateMachine(
                -1 * type.getWater(),
                -1 * type.getMilk(),
                -1 * type.getBeans(),
                -1 * type.getCups(),
                type.getCost());
        return coffeeMachine.toString();
    }

    private String fill(int water, int milk, int beans, int cups) {
        coffeeMachine.updateMachine(water, milk, beans, cups, 0);
        return coffeeMachine.toString();
    }

    private String take() {
        int money = coffeeMachine.getMoney();
        coffeeMachine.setMoney(-1 * money);
        return String.valueOf(money);
    }

    public String afterTake() {
        return coffeeMachine.toString();
    }

    private static CoffeeType getCoffeeType(int num) {
        return switch (num) {
            case 1 -> CoffeeType.ESPRESSO;
            case 2 -> CoffeeType.LATTE;
            case 3 -> CoffeeType.CAPPUCCINO;
            default -> throw new IllegalStateException("Unexpected value: " + num);
        };
    }

}

enum Order {
    BUY, FILL, TAKE
}
