package com.example.CinemaRoomREST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    Cinema cinema = new Cinema();

    @GetMapping("/seats")
    public Cinema returnSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseSeat(@RequestBody Seat requestedSeat) {
        if (requestedSeat.getRow() > 9 || requestedSeat.getRow() < 1 || requestedSeat.getColumn() > 9 || requestedSeat.getColumn() < 1) {
            return ResponseEntity.badRequest().body("{\n\t\"error\": \"The number of a row or a column is out of bounds!\"\n}");
        }

        final int tens = 10;
        int index = (requestedSeat.getRow() - 1) * tens +
                requestedSeat.getColumn() - (requestedSeat.getRow() - 1) - 1;

        if (cinema.getAvailableSeats().get(index).isBought()) {
            return ResponseEntity.badRequest().body("{\n\t\"error\": \"The ticket has been already purchased!\"\n}");
        }

        cinema.getAvailableSeats().get(index).setBought(true);
        Seat purchasedSeat = cinema.getAvailableSeats().get(index);

        return ResponseEntity.ok(purchasedSeat.toString());
    }
}
