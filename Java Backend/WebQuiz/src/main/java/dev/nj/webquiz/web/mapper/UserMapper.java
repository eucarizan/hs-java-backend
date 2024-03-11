package dev.nj.webquiz.web.mapper;

import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.web.dto.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final PasswordEncoder encoder;

    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User toEntity(UserDto dto) {
        return new User(dto.email(), encoder.encode(dto.password()));
    }
}
