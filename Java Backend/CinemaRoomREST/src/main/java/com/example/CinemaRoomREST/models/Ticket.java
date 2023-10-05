package com.example.CinemaRoomREST.models;

public class Ticket {
    int row;
    int column;
    int price;

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
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
}
