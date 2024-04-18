package dev.nj.entities;

import java.util.List;

public record Company(int id, String name, List<Car> carList) {

    public Company(String name) {
        this(-1, name, null);
    }

    public Company(int id, String name) {
        this(id, name, null);
    }

    public String info() {
        return String.format("%d. %s", id, name);
    }
}