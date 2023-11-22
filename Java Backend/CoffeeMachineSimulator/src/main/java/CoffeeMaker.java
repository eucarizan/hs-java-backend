public class CoffeeMaker {
    public static String makeCoffee(int water, int milk, int coffeeBeans, int cups) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(water, milk, coffeeBeans, cups);
        return coffeeMachine.toString();
    }

}
