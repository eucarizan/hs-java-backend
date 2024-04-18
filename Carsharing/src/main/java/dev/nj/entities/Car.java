package dev.nj.entities;

public record Car(int id, String name) {

    public Car(String name) {
        this(-1, name);
    }

    public String info() {
        return String.format("%d. %s", id, name);
    }
}
