import java.util.Comparator;
import java.util.List;

public class Messages {
    public static void sort(List<Message> messages) {
        messages.sort(new MessageContentComparator());
    }

    public static void sortByDate(List<Message> messages) {
        messages.sort(new MessageDateComparator());
    }

    public static void sortByAuthor(List<Message> messages) {
        messages.sort(new MessageAuthorComparator());
    }

    public static void sortByDateLambda(List<Message> messages) {
        messages.sort((m1, m2) -> m1.getCreated().compareTo(m2.getCreated()));
    }

    public static void sortByLikesDescThenAuthorLambda(List<Message> messages) {
        messages.sort(Comparator
                .comparing(Message::getLikes)
                .reversed()
                .thenComparing(Message::getFrom)
        );
    }
}
