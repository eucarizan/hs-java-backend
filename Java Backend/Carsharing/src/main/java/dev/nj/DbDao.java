package dev.nj;

import org.h2.jdbcx.JdbcDataSource;

import java.util.List;

public class DbDao {
    static final String DB_URL = "jdbc:h2:./src/carsharing/db/";
    private final DbCompanyDao dbCompanyDao;
    private final DbCarDao dbCarDao;

    public DbDao(String args) {
        String url = DB_URL + args;
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(url);

        DbClient dbClient = new DbClient(dataSource);
        dbCompanyDao = new DbCompanyDao(dbClient);
        dbCarDao = new DbCarDao(dbClient);

        dbClient.run(DbCarDao.DROP_CARS_DB);
        dbClient.run(DbCompanyDao.DROP_DB);
        dbClient.run(DbCompanyDao.CREATE_DB);
        dbClient.run(DbCarDao.CREATE_CAR_DB);
    }

    public List<Company> findAllCompanies() {
        return dbCompanyDao.findAll();
    }

    public List<Car> findAllCars(int id) {
        return dbCarDao.findAll(id);
    }

    public void addCompany(String name) {
        dbCompanyDao.add(name);
    }

    public void addCar(String name, int comp_id) {
        dbCarDao.add(name, comp_id);
    }

}
