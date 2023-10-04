package com.example.CinemaRoomREST.dictionary;

public enum ErrorMsgs {
    OUT_OF_BOUNDS("The number of a row or a column is out of bounds!"),
    NOT_AVAILABLE_TICKET("The ticket has been already purchased!");

    final String error;

    ErrorMsgs(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
