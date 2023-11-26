public class Person {
    private double balance;
    private final Basket basket = new Basket();

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBalance() {
        return String.format("Balance: $%.2f", balance);
    }

    public void addPurchase(Item item) {
        this.balance -= item.price();
        basket.addToCart(item);
    }

    public String showPurchase(String category) {
        return basket.showCart(category);
    }

}
