package dev.nj.accountservice.web.mapper;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.SignUpResponseDto;
import org.springframework.stereotype.Component;

@Component
public class SignUpMapper {
    public User toEntity(SignUpDto signUpDto) {
        return new User(
                signUpDto.name(),
                signUpDto.lastname(),
                signUpDto.email(),
                signUpDto.password()
        );
    }

    public SignUpResponseDto toResponseDto(User user) {
        return new SignUpResponseDto(
                user.getName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
