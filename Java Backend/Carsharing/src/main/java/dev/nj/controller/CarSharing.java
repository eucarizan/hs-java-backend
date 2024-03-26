package dev.nj.controller;

import dev.nj.dictionaries.Menu;
import dev.nj.entities.Car;
import dev.nj.entities.Company;
import dev.nj.service.CarSharingDao;
import dev.nj.service.impl.CarSharingServiceImpl;

import java.util.*;
import java.util.stream.IntStream;


import static dev.nj.dictionaries.Menu.*;

public class CarSharing {
    private final CarSharingDao service;
    private final Scanner scanner;
    private final Map<Menu, Runnable> navMap;
    private Menu currentMenu;
    private Company selectedCompany;
    private boolean running;


    public CarSharing(String dbName) {
        service = new CarSharingServiceImpl(dbName);
        scanner = new Scanner(System.in);
        navMap = new HashMap<>(values().length);
        loadNavigationMap();
        currentMenu = MAIN;
    }

    private void loadNavigationMap() {
        navMap.put(MAIN, this::mainMenu);
        navMap.put(MANAGER, this::managerMenu);
        navMap.put(COMPANY, this::showCompanyMenu);
    }

    public void start() {
        running = true;
        while (running) {
            navMap.get(currentMenu).run();
        }
    }

    private void toMenu(Menu menu) {
        currentMenu = menu;
    }

    private void mainMenu() {
        System.out.println("1. Log in as a manager");
        System.out.println("0. Exit");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1 -> toMenu(MANAGER);
            // TODO-01: create - login as customer
            // TODO-02: create - create customer
            case 0 -> running = false;
        }
    }

    private void managerMenu() {
        System.out.println("\n1. Company list");
        System.out.println("2. Create a company");
        System.out.println("0. Back");
        int managerOption = Integer.parseInt(scanner.nextLine());
        switch (managerOption) {
            case 1 -> showCompanyList();
            case 2 -> addCompany();
            case 0 -> toMenu(MAIN);
        }
    }

    private void addCompany() {
        System.out.println("\nEnter the company name:");
        String name = scanner.nextLine();
        service.addCompany(new Company(name));
        System.out.println("The company was created!");
    }

    private void showCompanyList() {
        List<Company> companyList = service.findAllCompanies();
        if (companyList.isEmpty()) {
            System.out.println("\nThe company list is empty!");
        } else {
            System.out.println("\nChoose a company:");
            companyList.forEach(c -> System.out.println(c.info()));
            System.out.println("0. Back");
            int companyId = Integer.parseInt(scanner.nextLine());
            if (companyId != 0) {
                Optional<Company> company = companyList.stream()
                        .filter(c -> c.id() == companyId)
                        .findFirst();
                if (company.isPresent()) {
                    selectedCompany = company.get();
                    System.out.printf("%n'%s' company:%n", selectedCompany.name());
                    toMenu(COMPANY);
                }
            }
        }
    }

    private void showCompanyMenu() {
        System.out.println("1. Car list");
        System.out.println("2. Create a car");
        System.out.println("0. Back");
        int companyOption = Integer.parseInt(scanner.nextLine());
        switch (companyOption) {
            case 1 -> showCompanyCarsList();
            case 2 -> addCarToCompany();
            case 0 -> toMenu(MANAGER);
        }
    }

    private void showCompanyCarsList() {
        List<Car> carList = service.findCarsByCompany(selectedCompany);
        if (carList.isEmpty()) {
            System.out.println("\nThe car list is empty!");
        } else {
            System.out.printf("%n'%s' cars:%n", selectedCompany.name());
            IntStream.range(0, carList.size())
                    .forEach(i -> System.out.printf("%d. %s%n", i + 1, carList.get(i).name()));
        }
    }

    private void addCarToCompany() {
        System.out.println("\nEnter the car name:");
        String carName = scanner.nextLine();
        Car car = new Car(carName);
        service.addCar(car, selectedCompany);
        System.out.println("The car was added!");
    }
}
