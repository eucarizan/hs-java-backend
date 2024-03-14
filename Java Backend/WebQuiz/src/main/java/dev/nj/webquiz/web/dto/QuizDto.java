package dev.nj.webquiz.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record QuizDto(
        long id,
        @NotBlank
        String title,
        @NotBlank
        String text,
        @NotNull
        @Size(min = 2, message = "At least 2 options are required")
        String[] options,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        int[] answer
) {
}
