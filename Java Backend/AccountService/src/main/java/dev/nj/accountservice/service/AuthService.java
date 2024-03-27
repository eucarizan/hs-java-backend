package dev.nj.accountservice.service;

import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.SignUpResponseDto;

public interface AuthService {
    SignUpResponseDto register(SignUpDto signUpDto);
}
