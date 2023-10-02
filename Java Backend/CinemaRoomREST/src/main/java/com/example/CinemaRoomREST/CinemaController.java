package com.example.CinemaRoomREST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    Cinema cinema = new Cinema();

    @GetMapping("/seats")
    public String returnSeats() {
        return cinema.toString();
    }

}
