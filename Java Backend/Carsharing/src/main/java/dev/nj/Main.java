package dev.nj;

import org.h2.jdbcx.JdbcDataSource;

public class Main {
    static final String DB_URL = "jdbc:h2:./src/carsharing/db/";
    private static final String CREATE_DB = "CREATE TABLE COMPANY(" +
            "id INTEGER PRIMARY KEY," +
            "name VARCHAR_IGNORECASE(50));";
    private static final String DROP_DB = "DROP TABLE IF EXISTS COMPANY;";

    public static void main(String[] args) {
        String url = DB_URL + getDatabaseFileName(args);
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(url);

        DbClient dbClient = new DbClient(dataSource);
        dbClient.run(DROP_DB);
        dbClient.run(CREATE_DB);
    }

    private static String getDatabaseFileName(String[] args) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if ("-databaseFileName".equals(args[i])) {
                if (i + 1 < args.length) {
                    out.append(args[i + 1]);
                }
            }
        }
        return out.toString();
    }
}