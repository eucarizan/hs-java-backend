package dev.nj.database;

import dev.nj.entities.Car;
import dev.nj.entities.Company;
import dev.nj.entities.Customer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarSharingDb {

    private final DataSource dataSource;
    private static final String CREATE_COMPANY_TABLE = """
        CREATE TABLE IF NOT EXISTS COMPANY(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            NAME VARCHAR(50) UNIQUE NOT NULL
        )
        """;
    private static final String CREATE_CAR_TABLE = """
        CREATE TABLE IF NOT EXISTS CAR(
            ID INT AUTO_INCREMENT PRIMARY KEY,
            NAME VARCHAR(50) UNIQUE NOT NULL,
            COMPANY_ID INT NOT NULL,
            CONSTRAINT FK_COMPANY FOREIGN KEY (COMPANY_ID)
            REFERENCES COMPANY(ID)
        )
        """;
    private static final String CREATE_CUSTOMER_TABLE = """
            CREATE TABLE IF NOT EXISTS CUSTOMER(
                ID INT AUTO_INCREMENT PRIMARY KEY,
                NAME VARCHAR(50) UNIQUE NOT NULL,
                RENTED_CAR_ID INT,
                CONSTRAINT FK_RENTED_CAR FOREIGN KEY (RENTED_CAR_ID)
                REFERENCES CAR(ID)
            )
            """;
    private static final String INSERT_COMPANY = "INSERT INTO COMPANY(NAME) VALUES (?)";
    private static final String INSERT_CAR = "INSERT INTO CAR(NAME, COMPANY_ID) VALUES(?, ?)";
    private static final String INSERT_CUSTOMER = "INSERT INTO CUSTOMER(NAME) VALUES(?)";
    private static final String SELECT_COMPANIES = "SELECT * FROM COMPANY";
    private static final String SELECT_COMPANY_CARS = "SELECT * FROM CAR WHERE COMPANY_ID = ? ORDER BY ID";
    private static final String SELECT_CUSTOMERS = "SELECT * FROM CUSTOMERS";

    public CarSharingDb(DataSource dataSource) {
        this.dataSource = dataSource;
        initDb();
    }

    private void initDb() {
        run(CREATE_COMPANY_TABLE);
        run(CREATE_CAR_TABLE);
        run(CREATE_CUSTOMER_TABLE);
    }

    public void run(String query) {
        try(Connection con = dataSource.getConnection();
            Statement st = con.createStatement()){
            st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCompany(String companyName) {
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_COMPANY)){
            ps.setString(1, companyName);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCar(String carName, int companyId) {
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_CAR)){
            ps.setString(1, carName);
            ps.setInt(2, companyId);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCustomer(String customerName) {
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER)) {
            ps.setString(1, customerName);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Company> findAllCompanies() {
        try(Connection con = dataSource.getConnection();
            Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(SELECT_COMPANIES);
            if (rs.isBeforeFirst()) {
                List<Company> companyList = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("NAME");
                    companyList.add(new Company(id, name));
                }
                return companyList;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }


    public List<Car> findCarsByCompanyId(int companyId) {
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(SELECT_COMPANY_CARS)){
            ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                List<Car> carList = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("NAME");
                    carList.add(new Car(id, name));
                }
                return carList;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

    public List<Customer> findAllCustomers() {
        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SELECT_CUSTOMERS)) {
            List<Customer> customerList = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("NAME");
                customerList.add(new Customer(name));
            }
            return customerList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }

}
