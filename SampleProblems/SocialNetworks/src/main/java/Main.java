import java.util.Scanner;

abstract class SocialNetwork {
    public void connect() {
        login();
        postMessage();
        logout();
    }

    public abstract void login();

    public abstract void postMessage();

    public abstract void logout();

    public static void print(String network, String method) {
        switch (method) {
            case "login" -> System.out.println("Log into " + network);
            case "post" -> System.out.println("Post: Hello, " + network + "!");
            case "logout" -> System.out.println("Log out of " + network);
        }
    }
}

class Instagram extends SocialNetwork {
    @Override
    public void login() {
        print("Instagram", "login");
    }

    @Override
    public void postMessage() {
        print("Instagram", "post");
    }

    @Override
    public void logout() {
        print("Instagram", "logout");
    }
}


class Facebook extends SocialNetwork {
    @Override
    public void login() {
        print("Facebook", "login");
    }

    @Override
    public void postMessage() {
        print("Facebook", "post");
    }

    @Override
    public void logout() {
        print("Facebook", "logout");
    }
}

// Do not change the code below
public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        SocialNetwork network = null;
        if ("facebook".equalsIgnoreCase(type)) {
            network = new Facebook();
        } else if ("instagram".equalsIgnoreCase(type)) {
            network = new Instagram();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        network.connect();
    }
}