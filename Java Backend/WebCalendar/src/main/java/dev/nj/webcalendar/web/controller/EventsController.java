package dev.nj.webcalendar.web.controller;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventsController {

    @Autowired
    EventsService service;

    @GetMapping("/today")
    public ResponseEntity<List<CalendarEvent>> getEvents() {
        return ResponseEntity.ok(service.getAllCalendarEvent());
    }
}
