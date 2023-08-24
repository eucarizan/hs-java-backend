import java.util.List;

public class Messages {
    public static List<Message> sort(List<Message> messages) {
        messages.sort(new MessageContentComparator());
        return messages;
    }
}
