package dev.njeu.web.mapper;

import dev.njeu.entities.User;
import dev.njeu.web.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User toEntity(UserDto userDto) {
        return new User().setUsername(userDto.email())
                .setPassword(passwordEncoder.encode(userDto.password()));
    }
}
