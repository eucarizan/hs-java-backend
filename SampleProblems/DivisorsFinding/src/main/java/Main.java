public class Main {
    public static void main(String[] args) {
        boolean result = isPrime(5977);
        boolean result2 = isPrime(119);
    }

    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i != 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}