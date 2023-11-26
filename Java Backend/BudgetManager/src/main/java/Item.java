public record Item(String name, double price, Category category) {

    @Override
    public String toString() {
        return String.format("%s $%.2f", name, price);
    }
}
