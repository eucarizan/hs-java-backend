package dev.nj;

import java.util.List;

public class DbCustomerDao {
    public static final String DROP_CUSTOMERS_DB = "DROP TABLE IF EXISTS CUSTOMER;";
    public static final String CREATE_CUSTOMER_DB =
            "CREATE TABLE CUSTOMER (" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR_IGNORECASE(50) NOT NULL UNIQUE," +
                    "rented_car_id INT," +
                    "FOREIGN KEY (rented_car_id) REFERENCES CAR (id)" +
                    ");";
    private static final String SELECT_ALL = "SELECT * FROM CUSTOMER;";
    private static final String INSERT_DATA = "INSERT INTO CUSTOMER (name, rented_car_id) VALUES ('%s', -1);";
    private static final String RENT_UPDATE = "UPDATE CUSTOMER SET rented_car_id = %d WHERE id = %d";
    private static final String RETURN_UPDATE = "UPDATE CUSTOMER SET rented_car_id = -1 WHERE id = %d";

    private final DbClient dbClient;

    public DbCustomerDao(DbClient dbClient) {
        this.dbClient = dbClient;
    }

    public List<Customer> findAll() {
        return dbClient.selectForCustomerList(SELECT_ALL);
    }

    public void add(String name) {
        dbClient.run(String.format(INSERT_DATA, name));
    }

    public void rent(int carId, int customerId) {
        dbClient.run(String.format(RENT_UPDATE, carId, customerId));
    }

    public void returnCar(int customerId) {
        dbClient.run(String.format(RETURN_UPDATE, customerId));
    }
}
