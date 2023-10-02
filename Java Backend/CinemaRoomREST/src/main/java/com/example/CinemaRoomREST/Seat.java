package com.example.CinemaRoomREST;

public class Seat {
    int row;
    int column;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "\n\t{\n\t\"row\":" + row +
                ",\n\t\"column\":" + column +
                "\n\t}";
    }
}
