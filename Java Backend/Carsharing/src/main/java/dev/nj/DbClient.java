package dev.nj;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbClient {
    private final DataSource dataSource;

    public DbClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void run(String str) {
        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement()
        ) {
            statement.execute(str);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Company> selectForCompanyList(String query) {
        List<Company> companies = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
            Statement statement = con.createStatement();
             ResultSet resultSetItem = statement.executeQuery(query)) {
            while (resultSetItem.next()) {
                int id = resultSetItem.getInt("id");
                String name = resultSetItem.getString("name");
                Company company = new Company(id, name);
                companies.add(company);
            }
            return companies;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return companies;
    }

    public List<Car> selectForCarList(String query) {
        List<Car> cars = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             Statement statement = con.createStatement();
             ResultSet resultSetItem = statement.executeQuery(query)) {
            while (resultSetItem.next()) {
                int id = resultSetItem.getInt("id");
                String name = resultSetItem.getString("name");
                int comp_id = resultSetItem.getInt("company_id");
                Car car = new Car(id, name, comp_id);
                cars.add(car);
            }
            return cars;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cars;
    }
}
