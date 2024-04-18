package com.example.CinemaRoomREST.services;

import com.example.CinemaRoomREST.dictionary.ErrorMsgs;
import com.example.CinemaRoomREST.dto.SeatDTO;
import com.example.CinemaRoomREST.dto.StatsDTO;
import com.example.CinemaRoomREST.dto.TicketDTO;
import com.example.CinemaRoomREST.models.Cinema;
import com.example.CinemaRoomREST.models.Seat;
import com.example.CinemaRoomREST.models.Ticket;
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
//            seatInfo = ResponseEntity.badRequest().body(ErrorMsgs.OUT_OF_BOUNDS.toString());
            seatInfo = new ResponseEntity(Map.of("error", ErrorMsgs.OUT_OF_BOUNDS.toString()),
                    HttpStatus.BAD_REQUEST);
        } else if (!seatOptional.get().isAvailable()) {
            seatInfo = new ResponseEntity(Map.of("error", ErrorMsgs.NOT_AVAILABLE_TICKET.toString()),
                    HttpStatus.BAD_REQUEST);
        } else {
            try {
                Seat seat = seatOptional.get();
                seat.generateToken();
                Ticket ticket = new Ticket(seat.getRow(), seat.getColumn(), seat.getPrice());
                TicketDTO ticketDTO = new TicketDTO(seat.getToken(), ticket);
                seatInfo = new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(ticketDTO), HttpStatus.OK);
                cinema.adjustPurchased(1);
                cinema.adjustIncome(seat.getPrice());
                seat.setAvailable(false);
            } catch (JsonProcessingException e) {
                seatInfo = new ResponseEntity(Map.of("error", e.getMessage()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return seatInfo;
    }

    public ResponseEntity<String> returnTicket(String token) {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> seatInfo;

        Optional<Seat> seatOptional = Arrays.stream(cinema.getSeatsClone())
                .filter(seat -> token.equals(seat.getToken()))
                .findFirst();

        if (seatOptional.isEmpty()) {
            seatInfo = new ResponseEntity(Map.of("error", ErrorMsgs.WRONG_TOKEN.toString()),
                    HttpStatus.BAD_REQUEST);
        } else {
            try {
                Seat seat = seatOptional.get();
                Ticket ticket = new Ticket(seat.getRow(), seat.getColumn(), seat.getPrice());
                SeatDTO seatDTO = new SeatDTO(ticket);
                seatInfo = new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter()
                        .writeValueAsString(seatDTO), HttpStatus.OK);
                cinema.adjustPurchased(-1);
                cinema.adjustIncome(-1 * seat.getPrice());
                seat.setAvailable(true);
                seat.resetToken();
            } catch (JsonProcessingException e) {
                seatInfo = new ResponseEntity(Map.of("error", e.getMessage()),
                        HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return seatInfo;
    }

    public ResponseEntity<String> getStats(String password) {
        if (!"super_secret".equals(password)) {
            return new ResponseEntity(Map.of("error", ErrorMsgs.WRONG_PASSWORD.toString()), HttpStatus.UNAUTHORIZED);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseEntity<String> cinemaStats;
        StatsDTO statsDTO = new StatsDTO(cinema.getIncome(), cinema.getAvailableSeats(), cinema.getPurchased());
        try {
            cinemaStats = new ResponseEntity<>(objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(statsDTO), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            cinemaStats = new ResponseEntity(Map.of("error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return cinemaStats;
    }

}
