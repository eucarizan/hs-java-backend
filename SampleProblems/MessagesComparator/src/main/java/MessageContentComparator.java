import java.util.Comparator;

public class MessageContentComparator implements Comparator<Message> {

    @Override
    public int compare(Message msg1, Message msg2) {
        int firstLength = msg1.getContent().length();
        int secondLength = msg2.getContent().length();
        return Integer.compare(firstLength, secondLength);
    }
}
