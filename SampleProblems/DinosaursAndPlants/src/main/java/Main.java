import org.sqlite.SQLiteDataSource;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/main/resources/dinosaurs.db";

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

//        testConnection(dataSource);
        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS DINOSAURS(" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "domain TEXT NOT NULL)"
                );

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS PLANTS(" +
                        "id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "kingdom TEXT NOT NULL)"
                );

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String insertDinosaur = "INSERT INTO dinosaurs (id, name, domain) VALUES (?, ?, ?)";
        String insertPlant = "INSERT INTO plants (id, name, kingdom) VALUES (?, ?, ?)";

        try (Connection con = dataSource.getConnection()) {
            con.setAutoCommit(false);
            try (PreparedStatement dinosaurPreparedStatement = con.prepareStatement(insertDinosaur);
                 PreparedStatement plantPreparedStatement = con.prepareStatement(insertPlant)) {

                dinosaurPreparedStatement.setInt(1, 1);
                dinosaurPreparedStatement.setString(2, "Triceratops");
                dinosaurPreparedStatement.setString(3, "Eukaryota");
                dinosaurPreparedStatement.executeUpdate();

                con.commit();

                plantPreparedStatement.setInt(1, 1);
                plantPreparedStatement.setString(2, "Rose");
                plantPreparedStatement.setString(3, "Plantae");
                plantPreparedStatement.executeUpdate();
            } catch (SQLException e) {
                con.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                ResultSet rs1 = statement.executeQuery("SELECT * FROM dinosaurs");

                while (rs1.next()) {
                    int id = rs1.getInt(1);
                    String name = rs1.getString(2);
                    String domain = rs1.getString(3);

                    System.out.printf("dino%d: %s lives in %s%n", id, name, domain);
                }

                ResultSet rs2 = statement.executeQuery("SELECT * FROM dinosaurs");

                while (rs2.next()) {
                    int id = rs2.getInt(1);
                    String name = rs2.getString(2);
                    String domain = rs2.getString(3);

                    System.out.printf("plant%d: %s lives in %s%n", id, name, domain);
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testConnection(SQLiteDataSource dataSource) {
        try (Connection con = dataSource.getConnection()) {
            if (con.isValid(5)) {
                System.out.println("Connection is valid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}