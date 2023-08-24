public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "=" + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
