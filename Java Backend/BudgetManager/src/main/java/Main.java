import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = List.of("Almond 250gm $35.43",
                "LEGO DUPLO Town Farm Animals $10.10",
                "Sensodyne Pronamel Toothpaste $19.74",
                "Hershey's milk chocolate bars $8.54",
                "Gildan LT $8.61");
        Basket basket = new Basket();
        System.out.println(basket.processCart(input));
    }
}