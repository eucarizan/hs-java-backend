public class Coffee {
    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cups;

    public Coffee(int cups) {
        this.cups = cups;
        water = 200 * cups;
        milk = 50 * cups;
        coffeeBeans = 15 * cups;
    }

    @Override
    public String toString() {
        return String.format("""
                For %s cups of coffee you will need:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                """, cups, water, milk, coffeeBeans);
    }
}
