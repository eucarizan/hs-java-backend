package com.example.CinemaRoomREST.controllers;

import com.example.CinemaRoomREST.models.Cinema;
import com.example.CinemaRoomREST.models.Seat;
import com.example.CinemaRoomREST.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    private final BookingService bookingService;

    @Autowired
    public CinemaController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/seats")
    public Cinema returnSeats() {
        return bookingService.getAvailableSeatsInfo();
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseSeat(@RequestBody Seat requestedSeat) {
        return bookingService.purchaseTicket(requestedSeat);
    }
}
