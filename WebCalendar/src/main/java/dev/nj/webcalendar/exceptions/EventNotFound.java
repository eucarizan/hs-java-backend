package dev.nj.webcalendar.exceptions;

public class EventNotFound extends RuntimeException {
    public EventNotFound(String message) {
        super(message);
    }
}
