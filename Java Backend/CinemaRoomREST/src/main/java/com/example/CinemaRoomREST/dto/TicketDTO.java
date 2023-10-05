package com.example.CinemaRoomREST.dto;

import com.example.CinemaRoomREST.models.Ticket;

public class TicketDTO {
    String token;
    Ticket ticket;

    public TicketDTO(String token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public Ticket getTicket() {
        return ticket;
    }
}

