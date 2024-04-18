package dev.nj.service;

import dev.nj.entities.Car;
import dev.nj.entities.Company;
import dev.nj.entities.Customer;

import java.util.List;

public interface CarSharingDao {
    void addCompany(Company company);
    void addCar(Car car, Company company);
    void addCustomer(Customer customer);
    List<Company> findAllCompanies();
    List<Car> findCarsByCompany(Company company);
    List<Customer> findAllCustomers();
}
