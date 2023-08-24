import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Alien", "Hello humans!",
                32, "2034-03-25"));
        messages.add(new Message("Pirate", "All hands on deck!",
                -2, "2034-01-05"));
        messages.add(new Message("User765214", "Bump!",
                1, "2033-02-17"));
        messages.add(new Message("Unregistered", "This message was marked as spam",
                -18, "2033-01-14"));
        System.out.println("before sort:");
        messages.forEach(System.out::println);

        Messages.sortByDate(messages);
        System.out.println();
        System.out.println("after sort:");
        messages.forEach(msg -> System.out.println("\"" + msg + "\","));
    }
}