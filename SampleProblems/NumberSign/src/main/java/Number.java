public class Number {
    public static int sign(int number) {
        return number == 0 ? 0 : number / Math.abs(number);
    }

    public static int intCompare(int number) {
        return Integer.compare(number, 0);
    }
}
