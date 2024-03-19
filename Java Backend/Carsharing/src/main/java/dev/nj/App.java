package dev.nj;

import java.util.List;
import java.util.Scanner;

public class App {
    static final String MENU = """
            1. Log in as a manager
            0. Exit""";

    static final String MANAGER_MENU = """
            1. Company list
            2. Create a company
            0. Back
            """;

    private static DbCompanyDao dbCompanyDao;

    public static String start(String arg) {
        StringBuilder out = new StringBuilder();
        dbCompanyDao = new DbCompanyDao(arg);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(MENU);
            out.append(MENU);
            int choice = Integer.parseInt(sc.nextLine());
            while (choice != 0) {
                out.append(managerApp(sc));
                System.out.println(MENU);
                choice = Integer.parseInt(sc.nextLine());
            }
        }

        return out.toString();
    }

    public static String managerApp(Scanner sc) {
        StringBuilder out = new StringBuilder();

        System.out.println(MANAGER_MENU);
        out.append(MANAGER_MENU);
        int choice = Integer.parseInt(sc.nextLine());
        while (choice != 0) {

            if (choice == 1) {
                String show = showCompanies();
                out.append(show);
                System.out.println(show);
            } else if (choice == 2) {
                String create = createCompany(sc);
                out.append(create);
                System.out.println(create);
            }

            System.out.println(MANAGER_MENU);
            choice = Integer.parseInt(sc.nextLine());
        }


        return out.toString();
    }

    public static String showCompanies() {
        StringBuilder out = new StringBuilder();
        List<Company> companies = dbCompanyDao.findAll();

        if (companies.isEmpty()) {
            out.append("The company list is empty!");
        } else {
            out.append("Company list:\n");
            companies.forEach(c -> out.append(String.format("%d. %s%n", c.getId(), c.getName())));
        }

        return out.toString();
    }

    public static String createCompany(Scanner sc) {
        System.out.println("Enter the company name:");
        String name = sc.nextLine();
        dbCompanyDao.add(name);


        return "The company was created!";
    }
}
