package dev.nj.webcalendar.web.controller;

import dev.nj.webcalendar.entities.CalendarEvent;
import dev.nj.webcalendar.exceptions.EventNotFound;
import dev.nj.webcalendar.service.EventsService;
import dev.nj.webcalendar.web.dto.EventDto;
import dev.nj.webcalendar.web.dto.SavedEventDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping
    public ResponseEntity<List<CalendarEvent>> getEvents(
            @RequestParam(name = "start_time", required = false) LocalDate startDate,
            @RequestParam(name = "end_time", required = false) LocalDate endDate) {
        List<CalendarEvent> events;

        if (startDate == null && endDate == null) {
            events = eventsService.getAllCalendarEvent();
            if (events.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(events);
        }

        events = eventsService.getAllEventsBetween(startDate, endDate);
        return events.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(events);
    }

    @GetMapping("/today")
    public ResponseEntity<List<CalendarEvent>> getEventsToday() {
        return ResponseEntity.ok(eventsService.getAllEventsToday(LocalDate.now()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarEvent> getEventById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventsService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SavedEventDto> saveEvent(@RequestBody @Valid EventDto dto) {
        return ResponseEntity.ok(eventsService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CalendarEvent> deleteEvent(@PathVariable("id") Long id) {
        return ResponseEntity.ok(eventsService.delete(id));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handeValidationExceptions(MethodArgumentNotValidException ex) {
        // public Map<String, String> handeValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                }
        );
        // return errors;
    }

    @ExceptionHandler(EventNotFound.class)
    public ResponseEntity<Object> handleNotFoundException(EventNotFound ex) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
