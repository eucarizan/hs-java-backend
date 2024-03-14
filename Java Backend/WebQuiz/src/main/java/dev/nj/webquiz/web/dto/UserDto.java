package dev.nj.webquiz.web.dto;

import jakarta.validation.constraints.*;

public record UserDto (

    @NotBlank
    @Pattern(regexp = "\\w+(\\.\\w+){0,2}@\\w+\\.\\w+", message = "Invalid email address")
    String email,

    @NotBlank
    @Size(min = 5, message = "At least 5 characters are required")
    String password)
{
}
