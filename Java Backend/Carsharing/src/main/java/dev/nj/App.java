package dev.nj;

import java.util.List;
import java.util.Scanner;

public class App {
    static final String MENU = """
            1. Log in as a manager
            0. Exit
            """;

    static final String MANAGER_MENU = """
            1. Company list
            2. Create a company
            0. Back
            """;

    static final String COMP_MENU = """
            '%s' company
            1. Car list
            2. Create a car
            0. Back
            """;

    private static DbDao dbDao;

    private static Scanner sc;

    public static void start(String arg) {
        dbDao = new DbDao(arg);
        sc = new Scanner(System.in);

        System.out.println(MENU);
        int choice = Integer.parseInt(sc.nextLine());
        while (choice != 0) {
            managerApp();
            System.out.println(MENU);
            choice = Integer.parseInt(sc.nextLine());
        }

        sc.close();
    }

    public static void managerApp() {

        System.out.println(MANAGER_MENU);
        int choice = Integer.parseInt(sc.nextLine());
        while (choice != 0) {

            if (choice == 1) {
                String show = showCompanies();
                System.out.println(show);
            } else if (choice == 2) {
                String create = createCompany();
                System.out.println(create);
            }

            System.out.println(MANAGER_MENU);
            choice = Integer.parseInt(sc.nextLine());
        }
    }

    public static String showCompanies() {
        StringBuilder out = new StringBuilder();
        List<Company> companies = dbDao.findAllCompanies();

        if (companies.isEmpty()) {
            out.append("The company list is empty!");
        } else {
            String companyOut = listCompanies(companies);
            out.append(companyOut);
        }

        return out.toString();
    }

    public static String createCompany() {
        System.out.println("Enter the company name:");
        String name = sc.nextLine();
        dbDao.addCompany(name);

        return "The company was created!";
    }

    public static String createCar(int id) {
        System.out.println("Enter the car name:");
        String name = sc.nextLine();
        dbDao.addCar(name, id);

        return "The car was added!";
    }

    public static String listCompanies(List<Company> companies) {
        StringBuilder out = new StringBuilder();

        out.append("Choose the company:\n");
        companies.forEach(c -> out.append(String.format("%d. %s%n", c.getId(), c.getName())));
        out.append("0. Back\n");
        String companyMsg = out.toString();
        System.out.println(companyMsg);
        int companyId = Integer.parseInt(sc.nextLine());

        while (companyId != 0) {
            int num = 1;
            if (companies.get(companyId - 1) != null) {
                num = showCompanyMenu(companies.get(companyId - 1));
            }

            if (num == 0) {
                break;
            }
            System.out.println(companyMsg);
            companyId = Integer.parseInt(sc.nextLine());
        }

        return "";
    }

    public static int showCompanyMenu(Company company) {
        List<Car> carList;

        String compMenu = String.format(COMP_MENU, company.getName());
        System.out.println(compMenu);
        int companyMenuChoice = Integer.parseInt(sc.nextLine());

        while (companyMenuChoice != 0) {
            carList = dbDao.findAllCars(company.getId());
            if (companyMenuChoice == 1) {
                if (carList.isEmpty()) {
                    System.out.println("The car list is empty!");
                } else {
                    System.out.println("Car list:");
                    for (int i = 0; i < carList.size(); i++) {
                        String carStr = String.format("%d. %s%n", i + 1, carList.get(i).getName());
                        System.out.print(carStr);
                    }
                }
            } else if (companyMenuChoice == 2) {
                String createdCar = createCar(company.getId());
                System.out.println(createdCar);
            }

            System.out.println("\n"+compMenu);
            companyMenuChoice = Integer.parseInt(sc.nextLine());
        }
        return 0;
    }
}
