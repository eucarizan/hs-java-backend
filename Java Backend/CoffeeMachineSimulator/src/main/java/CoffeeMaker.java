import java.util.Arrays;

public class CoffeeMaker {
    CoffeeMachine coffeeMachine =  new CoffeeMachine();

    public String takeOrder(String command) {
        String[] parts = command.split(", ");

        Order order = Order.valueOf(parts[0].toUpperCase());
        return switch (order) {
            case BUY -> buy(getCoffeeType(Integer.parseInt(parts[1])));
            case FILL -> {
                int[] refill = Arrays.stream(parts).skip(1).mapToInt(Integer::parseInt).toArray();
                yield fill(refill[0], refill[1], refill[2], refill[3]);
            }
            case TAKE -> take();
            case REMAINING -> coffeeMachine.toString();
        };
    }

    private String buy(CoffeeType type) {
        return coffeeMachine.updateMachine("BUY",
                type.getWater(),
                type.getMilk(),
                type.getBeans(),
                type.getCups(),
                type.getCost());
    }

    private String fill(int water, int milk, int beans, int cups) {
        return coffeeMachine.updateMachine("FILL" ,water, milk, beans, cups, 0);
    }

    private String take() {
        int money = coffeeMachine.getMoney();
        coffeeMachine.setMoney(0);
        return String.format("I gave you $%d", money);
    }

    private CoffeeType getCoffeeType(int num) {
        CoffeeType type = CoffeeType.findByNum(num);

        if (type != null) {
            return type;
        }

        throw new IllegalStateException("Unexpected value: " + num);
    }

}

enum Order {
    BUY, FILL, TAKE, REMAINING
}
