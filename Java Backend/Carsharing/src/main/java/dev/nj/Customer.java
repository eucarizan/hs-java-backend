package dev.nj;

public class Customer {
    private int id;
    private String name;
    private int car_id;

    public Customer(int id, String name, int car_id) {
        this.id = id;
        this.name = name;
        this.car_id = car_id;
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

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }
}
