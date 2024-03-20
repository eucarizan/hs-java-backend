package dev.nj.webcalendar.entities;

import java.time.LocalDateTime;

public record CalendarEvent(
        int id,
        String name,
        LocalDateTime dateTime) {
}
