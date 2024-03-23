package dev.nj.webcalendar.entities;

import java.time.LocalDate;

public record CalendarEvent(
        int id,
        String name,
        LocalDate localDate) {
}
