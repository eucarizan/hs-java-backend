package dev.nj;

import org.h2.jdbcx.JdbcDataSource;

import java.util.List;

public class DbCompanyDao implements CompanyDao {
    static final String DB_URL = "jdbc:h2:./src/carsharing/db/";
    private static final String DROP_DB = "DROP TABLE IF EXISTS COMPANY;";
    private static final String CREATE_DB =
            "CREATE TABLE COMPANY(" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR_IGNORECASE(50) NOT NULL UNIQUE" +
                    ");";
    private static final String SELECT_ALL = "SELECT * FROM COMPANY ORDER BY id";
    private static final String INSERT_DATA = "INSERT INTO COMPANY (name) VALUES ('%s')";

    private final DbClient dbClient;

    public DbCompanyDao(String args) {
        String url = DB_URL + args;
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(url);

        dbClient = new DbClient(dataSource);
        dbClient.run(DROP_DB);
        dbClient.run(CREATE_DB);
    }

    @Override
    public List<Company> findAll() {
        return dbClient.selectForList(SELECT_ALL);
    }

    @Override
    public void add(String name) {
        dbClient.run(String.format(
                INSERT_DATA, name));
    }
}
