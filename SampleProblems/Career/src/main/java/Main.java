import java.util.Scanner;

abstract class Career {

    public void execute() {
        // write your code here ...
        dream();

        plan();

        study();

        work();
    }

    // write your code here ...
    public abstract void work();

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

class Engineer extends Career {
    // write your code here ...
    @Override
    public void work() {
        System.out.println("Work as a Full Stack Engineer");
    }
}

class DataScientist extends Career {
    // write your code here ...
    @Override
    public void work() {
        System.out.println("Work as a Data Scientist");
    }
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
