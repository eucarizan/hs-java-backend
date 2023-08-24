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

        List<String> result = new ArrayList<>();

        Messages.sort(messages);
        messages.forEach(message -> result.add(message.toString()));

        assertEquals(expected, result);
    }
}
