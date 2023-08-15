public class Person implements Comparable<Person> {
    private final String name;
    private final int age;
    private final int height;
    private final int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (name.equals(otherPerson.getName())) {
            return age - otherPerson.getAge();
        }
        return name.compareTo(otherPerson.getName());
    }

    @Override
    public String toString() {
        return name +
                " " + age +
                " " + height +
                " " + weight;
    }
}
