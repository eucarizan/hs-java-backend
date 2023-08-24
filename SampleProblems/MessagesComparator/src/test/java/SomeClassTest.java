import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    @DisplayName("given unsorted messages, when sort by message content length, then messages sorted")
    void test1() {
        List<String> expected = List.of(
                "We",
                "in",
                "came",
                "Hello",
                "peace!",
                "humans!"
        );

        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Hello"));
        messages.add(new Message("humans!"));
        messages.add(new Message("We"));
        messages.add(new Message("came"));
        messages.add(new Message("in"));
        messages.add(new Message("peace!"));

        Messages.sort(messages);

        List<String> result = new ArrayList<>();
        messages.forEach(message -> result.add(message.getContent()));

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("when messages sorted by author, then messages sorted")
    void test2() {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Alien", "Hello humans!",
                32, "2034-03-25"));
        messages.add(new Message("Pirate", "All hands on deck!",
                -2, "2034-01-05"));
        messages.add(new Message("User765214", "Bump!",
                1, "2033-02-17"));
        messages.add(new Message("Unregistered", "This message was marked as spam",
                -18, "2033-01-14"));

        Messages.sortByAuthor(messages);

        List<String> expected = List.of(
                "2034-03-25 Alien wrote: Hello humans! (32)",
                "2034-01-05 Pirate wrote: All hands on deck! (-2)",
                "2033-01-14 Unregistered wrote: This message was marked as spam (-18)",
                "2033-02-17 User765214 wrote: Bump! (1)"
        );

        List<String> result = new ArrayList<>();
        messages.forEach(message -> result.add(message.toString()));

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("when messages sorted by date, then messages sorted")
    void test3() {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message("Alien", "Hello humans!",
                32, "2034-03-25"));
        messages.add(new Message("Pirate", "All hands on deck!",
                -2, "2034-01-05"));
        messages.add(new Message("User765214", "Bump!",
                1, "2033-02-17"));
        messages.add(new Message("Unregistered", "This message was marked as spam",
                -18, "2033-01-14"));

        Messages.sortByDate(messages);

        List<String> expected = List.of(
                "2033-01-14 Unregistered wrote: This message was marked as spam (-18)",
                "2033-02-17 User765214 wrote: Bump! (1)",
                "2034-01-05 Pirate wrote: All hands on deck! (-2)",
                "2034-03-25 Alien wrote: Hello humans! (32)"
        );

        List<String> result = new ArrayList<>();
        messages.forEach(message -> result.add(message.toString()));

        assertEquals(expected, result);
    }
}
