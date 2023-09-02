public class ManufacturingController {

    static int numOfProducts = 0;

    public static String requestProduct(String product) {
        numOfProducts++;
        return numOfProducts + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return numOfProducts;
    }
}
