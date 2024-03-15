package dev.nj;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
