package dev.nj.accountservice.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SignUpDto(
        @NotBlank
        String name,
        @NotBlank
        String lastname,
        @NotBlank
        @Pattern(regexp = "\\w+(\\.\\w+){0,2}@acme.com", message = "Invalid email address")
        String email,
        @NotBlank
        String password
) {
}
