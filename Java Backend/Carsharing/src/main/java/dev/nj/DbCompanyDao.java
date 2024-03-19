package dev.nj;

import java.util.List;

public class DbCompanyDao implements CompanyDao {
    public static final String DROP_DB = "DROP TABLE IF EXISTS COMPANY;";
    public static final String CREATE_DB =
            "CREATE TABLE COMPANY(" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR_IGNORECASE(50) NOT NULL UNIQUE" +
                    ");";
    private static final String SELECT_ALL = "SELECT * FROM COMPANY ORDER BY id";
    private static final String INSERT_DATA = "INSERT INTO COMPANY (name) VALUES ('%s')";

    private final DbClient dbClient;

    public DbCompanyDao(DbClient dbClient) {
        this.dbClient = dbClient;
    }

    @Override
    public List<Company> findAll() {
        return dbClient.selectForCompanyList(SELECT_ALL);
    }

    @Override
    public void add(String name) {
        dbClient.run(String.format(
                INSERT_DATA, name));
    }
}
