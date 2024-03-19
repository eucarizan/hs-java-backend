package dev.nj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private final List<Car> cars;

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(List<Car> carList) {
        this.cars.addAll(carList);
    }

    public List<Car> carList() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return getName();
    }
}
