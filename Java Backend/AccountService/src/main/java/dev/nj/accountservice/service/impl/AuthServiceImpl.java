package dev.nj.accountservice.service.impl;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.service.AuthService;
import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.SignUpResponseDto;
import dev.nj.accountservice.web.mapper.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    SignUpMapper mapper;

    @Override
    public SignUpResponseDto register(SignUpDto signUpDto) {
        User user = mapper.toEntity(signUpDto);
        return mapper.toResponseDto(user);
    }
}
