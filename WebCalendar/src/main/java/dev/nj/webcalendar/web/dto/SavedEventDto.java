package dev.nj.webcalendar.web.dto;

import java.time.LocalDate;

public record SavedEventDto(
        String message,
        String event,
        LocalDate date) {
}
