package com.example.CinemaRoomREST.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Seat {
    int row;
    int column;
    int price;
    boolean available;
    String token;

    public Seat(int row, int column, boolean available) {
        this.row = row;
        this.column = column;
        this.price = row <= 4 ? 10 : 8;
        this.available = available;
        this.token = "";
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

    @JsonIgnore
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @JsonIgnore
    public String getToken() {
        return token;
    }

    public void generateToken() {
        token = UUID.randomUUID().toString();
    }

    public void resetToken() {
        token = "";
    }

}
