package dev.nj.webcalendar.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EventDto(
        @NotBlank(message = "Event name is required.")
        String event,
        //TODO: custom validator
        @NotNull(message = "Event date is required.")
        LocalDate date) {
}
