package dev.nj.service.impl;

import dev.nj.database.CarSharingDb;
import dev.nj.entities.Car;
import dev.nj.entities.Company;
import dev.nj.entities.Customer;
import dev.nj.service.CarSharingDao;
import org.h2.jdbcx.JdbcDataSource;

import java.util.List;

public class CarSharingServiceImpl implements CarSharingDao {

    private final CarSharingDb db;

    public CarSharingServiceImpl(String dbName) {
        String url = "jdbc:h2:./src/carsharing/db/";
        JdbcDataSource ds = new JdbcDataSource();
        ds.setUrl(url + dbName);
        db = new CarSharingDb(ds);
    }

    @Override
    public void addCompany(Company company) {
        db.addCompany(company.name());
    }

    @Override
    public void addCar(Car car, Company company) {
        db.addCar(car.name(), company.id());
    }

    @Override
    public void addCustomer(Customer customer) {
        db.addCustomer(customer.name());
    }

    @Override
    public List<Company> findAllCompanies() {
        return db.findAllCompanies();
    }

    @Override
    public List<Car> findCarsByCompany(Company company) {
        return db.findCarsByCompanyId(company.id());
    }

    @Override
    public List<Customer> findAllCustomers() {
        return db.findAllCustomers();
    }
}