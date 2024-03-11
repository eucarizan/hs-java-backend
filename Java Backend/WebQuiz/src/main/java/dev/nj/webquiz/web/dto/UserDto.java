package dev.nj.webquiz.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDto (

    @NotNull
    @Email
    String email,

    @NotBlank
    @Size(min = 5)
    String password)
{
}
