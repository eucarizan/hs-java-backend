import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            String nums = scanner.nextLine();
            int sum1 = 0;
            int sum2 = 0;
            final int half = 3;
            for (int i = 0; i < half; i++) {
                sum1 += Character.getNumericValue(nums.charAt(i));
            }
            for (int i = half; i < nums.length(); i++) {
                sum2 += Character.getNumericValue(nums.charAt(i));
            }
            String lucky = sum1 == sum2 ? "Lucky" : "Regular";
            System.out.println(lucky);
        }
    }
}