package dev.nj.accountservice.web.dto;

public record UserResponseDto(
        long id,
        String name,
        String lastname,
        String email
) {
}
