import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<String> addresses = new ArrayList<>(List.of(
                "127.0.0.1",
                "256.0.0.1",
                "127.0.1",
                "192.168.123.231",
                "-1.0.0.1",
                "127.0.0.1.",
                "127.0.249.1",
                "255.255.255.255"
        ));

        addresses.stream()
                .map(IPAddress::check)
                .forEach(System.out::println);

        /*
        YES
        NO
        NO
        YES
        NO
        NO
        YES
        YES
         */
    }
}