import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String test1 = "4235 2345 6543 1234";
        String test3 = "2221 234y 2345 1234";
        String test4 = "2221 2341 2345 1234";
        String test7 = "2578 2345 1234 6499";
        String test8 = "371449635398431";

        /*
        Visa
        Card number does not exist
        MasterCard
        MasterCard
        AmericanExpress
         */

        ArrayList<String> tests = new ArrayList<>(
                List.of(test1, test3, test4, test7, test8));

        tests.stream()
                .map(t -> t.replaceAll(" ", ""))
                .forEach(num -> System.out.println(BankCard.findNetwork(num)));
    }
}