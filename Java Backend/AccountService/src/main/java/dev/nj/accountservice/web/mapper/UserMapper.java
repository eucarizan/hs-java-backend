package dev.nj.accountservice.web.mapper;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    PasswordEncoder encoder;

    public User toEntity(SignUpDto signUpDto) {
        return new User(
                signUpDto.name(),
                signUpDto.lastname(),
                signUpDto.email(),
                encoder.encode(signUpDto.password())
        );
    }

    public UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail()
        );
    }
}
