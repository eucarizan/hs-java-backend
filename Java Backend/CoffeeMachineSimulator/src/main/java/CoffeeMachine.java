public class CoffeeMachine {
    public static String makeCoffee(int water, int milk, int coffeeBeans, int cups) {
        Coffee coffee = new Coffee(water, milk, coffeeBeans, cups);
        return coffee.toString();
    }

}
