package dev.nj.accountservice.web.dto;

public record SignUpResponseDto(
        String name,
        String lastname,
        String email
) {
}
