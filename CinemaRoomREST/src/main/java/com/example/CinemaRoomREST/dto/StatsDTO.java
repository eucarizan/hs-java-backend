package com.example.CinemaRoomREST.dto;

public class StatsDTO {
    int income;
    long available;
    int purchased;

    public StatsDTO(int income, long available, int purchased) {
        this.income = income;
        this.available = available;
        this.purchased = purchased;
    }

    public int getIncome() {
        return income;
    }

    public long getAvailable() {
        return available;
    }

    public int getPurchased() {
        return purchased;
    }
}
