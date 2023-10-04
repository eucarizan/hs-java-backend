package com.example.CinemaRoomREST.services;

import com.example.CinemaRoomREST.dictionary.ErrorMsgs;
import com.example.CinemaRoomREST.models.Cinema;
import com.example.CinemaRoomREST.models.Seat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private Cinema cinema;

    public Cinema getAvailableSeatsInfo() {
        return cinema;
    }

    public ResponseEntity<String> purchaseTicket(Seat requestedSeat) {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> seatInfo;

        Optional<Seat> seatOptional = Arrays.stream(cinema.getSeatsClone())
                .filter(s -> s.getRow() == requestedSeat.getRow() && s.getColumn() == requestedSeat.getColumn())
                .findFirst();

        if (seatOptional.isEmpty()) {
            seatInfo = new ResponseEntity(Map.of("error", ErrorMsgs.OUT_OF_BOUNDS.toString()), HttpStatus.BAD_REQUEST);
        } else if (!seatOptional.get().isAvailable()) {
            seatInfo = new ResponseEntity(Map.of("error", ErrorMsgs.NOT_AVAILABLE_TICKET.toString()), HttpStatus.BAD_REQUEST);
        } else {
            try {
                seatInfo = new ResponseEntity(objectMapper.writeValueAsString(seatOptional.get()), HttpStatus.OK);
                seatOptional.get().setAvailable(false);
            } catch (JsonProcessingException e) {
                seatInfo = new ResponseEntity(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return seatInfo;
    }

}
