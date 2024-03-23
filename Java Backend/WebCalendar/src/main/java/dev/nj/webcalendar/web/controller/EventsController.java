package dev.nj.webcalendar.web.controller;

import dev.nj.webcalendar.entities.CalendarEvent;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/event")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping("/today")
    public ResponseEntity<List<CalendarEvent>> getEventsToday() {
        return ResponseEntity.ok(eventsService.getAllCalendarEvent());
    }

    // TODO: POST method - create event
    @PostMapping
    public ResponseEntity<SavedEventDto> saveEvent(@RequestBody @Valid EventDto dto) {
        return ResponseEntity.ok(eventsService.save(dto));
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
}
