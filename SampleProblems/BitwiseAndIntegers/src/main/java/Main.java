public class Main {
    public static void main(String[] args) {
        int number1 = 38;
        int number2 = 54;

        number1 = number1 << 2;
        number2 = number2 >> 1;
        int result = number2 ^ number1;
    }
}