import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] parts = "2312 213 812 28 -283 -234 -123 23 3123 123 0 123 -34 -78 -9876".split(" ");

        System.out.println(Arrays.toString(AbsValues.sort(parts)));
    }
}