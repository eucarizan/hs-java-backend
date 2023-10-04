package com.example.CinemaRoomREST.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Seat {
    int row;
    int column;
    int price;
    boolean available;

    public Seat(int row, int column, boolean available) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.available = available;
    }

//    public Seat(@JsonProperty("row") int row, @JsonProperty("column") int column) {
//        this.row = row;
//        this.column = column;
//    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean bought) {
        this.available = bought;
    }


}
