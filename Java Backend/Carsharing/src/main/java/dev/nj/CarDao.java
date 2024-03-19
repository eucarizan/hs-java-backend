package dev.nj;

import java.util.List;

public interface CarDao {
    List<Car> findAll(int id);
    void add(String name, int comp_id);
}
