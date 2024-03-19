package dev.nj;

import java.util.List;

public class DbCarDao implements CarDao{

    public static final String DROP_CARS_DB = "DROP TABLE IF EXISTS CAR;";
    public static final String CREATE_CAR_DB =
            "CREATE TABLE CAR(" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR_IGNORECASE(50) NOT NULL UNIQUE," +
                    "company_id INT NOT NULL," +
                    "FOREIGN KEY (company_id) REFERENCES COMPANY (id)" +
                    ");";
    private static final String SELECT_ALL = "SELECT * FROM CAR WHERE company_id = %d ORDER BY id";
    private static final String INSERT_DATA = "INSERT INTO CAR (name, company_id) VALUES ('%s', %d)";

    private final DbClient dbClient;

    public DbCarDao(DbClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public List<Car> findAll(int id) {
        return dbClient.selectForCarList(String.format(SELECT_ALL, id));
    }

    @Override
    public void add(String name, int comp_id) {
        dbClient.run(String.format(INSERT_DATA, name, comp_id));
    }
}
