package dev.njeu.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotNull
        @Pattern(regexp = "\\w+(\\.\\w+){0,2}@\\w+\\.\\w+")
        String email,
        @NotBlank
        @Size(min = 8)
        String password
) {
}
