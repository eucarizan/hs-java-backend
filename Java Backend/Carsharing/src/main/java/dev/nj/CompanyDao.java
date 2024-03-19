package dev.nj;

import java.util.List;

public interface CompanyDao {
    List<Company> findAll();
    void add(String name);
}
