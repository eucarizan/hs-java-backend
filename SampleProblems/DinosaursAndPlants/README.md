# Dinosaurs and plants

## Description
Take a look at the following code and select all correct answers:

```java
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
```
## Choices and answer
- [ ] It throws an SQLException
- [x] It inserts a record into the dinosaurs table
- [ ] It rollbacks a transaction
- [ ] It inserts records into the dinosaurs and plants tables

## Tags
- jdbc
- jdbc transactions