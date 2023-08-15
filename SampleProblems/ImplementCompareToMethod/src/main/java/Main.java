import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {"Tom-22-185-65", "Bob-22-175-85", "Kris-30-180-90"};

        List<Person> people = new ArrayList<>();
        for (String input : inputs) {
            String[] peopleStr = input.split("-");
            Person person = new Person(peopleStr[0], Integer.parseInt(peopleStr[1]), Integer.parseInt(peopleStr[2]), Integer.parseInt(peopleStr[3]));

            people.add(person);
        }

        people.stream().sorted().forEach(System.out::println);
    }
}
