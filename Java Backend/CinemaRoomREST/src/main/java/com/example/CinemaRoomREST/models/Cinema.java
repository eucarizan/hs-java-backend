package com.example.CinemaRoomREST.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Cinema {
    final int rows = 9;
    final int columns = 9;
    Seat[] seats = new Seat[rows * columns];
    int income = 0;
    int purchased = 0;

    public Cinema() {
        if (seats[0] == null) {
            generateSeats();
        }
    }

    private void generateSeats() {
        for (int i = 1, k = 0; i <= rows; i++) {
            for (int j = 1; j <= columns; j++, k++) {
                seats[k] = new Seat(i, j, true);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @JsonIgnore
    public Seat[] getSeatsClone() {
        return seats.clone();
    }

    public Seat[] getSeats() {
        return Arrays.stream(seats).filter(Seat::isAvailable).toArray(Seat[]::new);
    }

    @JsonIgnore
    public long getAvailableSeats() {
        return Arrays.stream(seats).filter(Seat::isAvailable).count();
    }

    @JsonIgnore
    public int getIncome() {
        return income;
    }

    public void adjustIncome(int price) {
        this.income += price;
    }

    @JsonIgnore
    public int getPurchased() {
        return purchased;
    }

    public void adjustPurchased(int increment) {
        this.purchased += increment;
    }
}
