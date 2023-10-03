package com.example.CinemaRoomREST;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    int totalRows;
    int totalColumns;
    List<Seat> availableSeats;

    public Cinema() {
        this.totalRows = 9;
        this.totalColumns = 9;
        this.availableSeats = generateSeats();
    }

    private List<Seat> generateSeats() {
        List<Seat> seatList = new ArrayList<>();
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                Seat seat = new Seat(i, j);
                seatList.add(seat);
            }
        }

        return seatList;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    //    @Override
//    public String toString() {
//        return "{\n\"total_rows\":" + totalRows + "," +
//                "\n\"total_columns\":" + totalColumns + "," +
//                "\n\"available_seats\":" + seats + "\n}";
//    }
}
