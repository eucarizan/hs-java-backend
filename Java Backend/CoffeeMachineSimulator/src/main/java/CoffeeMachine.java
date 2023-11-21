public class CoffeeMachine {
    public static String makeCoffee(int cups) {
        Coffee coffee = new Coffee(cups);
        return coffee.toString();
    }

}
