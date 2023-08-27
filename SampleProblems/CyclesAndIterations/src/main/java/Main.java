public class Main {
    public static void main(String[] args) {
        fibonacci();
    }

    static void fibonacci() {
        int prev = 0;
        int current = 1;
        for (int i = 0; i <= 25; i++) {
            int swap = prev;
            prev = current;
            current += swap;
            System.out.println(current);
        }
    }
}