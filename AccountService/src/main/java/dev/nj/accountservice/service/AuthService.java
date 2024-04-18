package dev.nj.accountservice.service;

import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.UserResponseDto;

public interface AuthService {
    UserResponseDto register(SignUpDto signUpDto);
}
