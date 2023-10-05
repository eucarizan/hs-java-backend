package com.example.CinemaRoomREST.dto;

import com.example.CinemaRoomREST.models.Ticket;

public class SeatDTO {
    Ticket ticket;

    public SeatDTO(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
