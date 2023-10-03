package com.example.CinemaRoomREST;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    int row;
    int column;
    int price;

    @JsonIgnore
    boolean bought;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.bought = false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    @Override
    public String toString() {
        return "{\n\t\"row\": " + row +
                ",\n\t\"column\": " + column +
                ",\n\t\"price\": " + price +
                "\n}";
    }
}
