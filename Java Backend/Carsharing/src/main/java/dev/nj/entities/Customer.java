package dev.nj.entities;

public record Customer(
        int id,
        String name,
        int carId
) {

    public Customer(String name) {
        this(-1, name, -1);
    }

    public String info() {
        return String.format("%d. %s", id, name);
    }
}
