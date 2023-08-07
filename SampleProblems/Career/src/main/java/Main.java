import java.util.Scanner;

abstract class Career {

    public void execute() {
        // write your code here ...
    }

    // write your code here ...

    // Do not change the code below
    public void dream() {
        System.out.println("Dream big!");
    }

    public void plan() {
        System.out.println("Draw a plan!");
    }

    public void study() {
        System.out.println("Study!");
    }
}

class Engineer {
    // write your code here ...
}

class DataScientist {
    // write your code here ...
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        Career plan = null;
        if ("engineer".equalsIgnoreCase(type)) {
            plan = new Engineer();
        } else if ("scientist".equalsIgnoreCase(type)) {
            plan = new DataScientist();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        plan.execute();
    }
}
