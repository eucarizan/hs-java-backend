public class CoffeeMachine {
    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cups;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int cups) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
    }

    private int totalCups() {
        int totalWater = water / 200;
        int totalMilk = milk / 50;
        int totalCoffeeBeans = coffeeBeans / 15;

        return Math.min(totalWater, Math.min(totalMilk, totalCoffeeBeans));
    }

    private String canMakeCoffee() {
        StringBuilder sb = new StringBuilder();
        int totalCups = totalCups();
        if (cups == totalCups) {
            sb.append("Yes, I can make that amount of coffee");
        } else if (cups <= totalCups) {
            sb.append("Yes, I can make that amount of coffee");
            sb.append(String.format(" (and even %d more than that)", totalCups - cups));
        } else {
            sb.append(String.format("No, I can make only %d cup(s) of coffee", totalCups));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return canMakeCoffee();
    }
}
