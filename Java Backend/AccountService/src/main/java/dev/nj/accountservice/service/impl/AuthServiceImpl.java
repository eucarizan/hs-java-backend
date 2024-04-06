package dev.nj.accountservice.service.impl;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.exceptions.UserExistException;
import dev.nj.accountservice.repositories.UserRepository;
import dev.nj.accountservice.service.AuthService;
import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.UserResponseDto;
import dev.nj.accountservice.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserMapper mapper;
    @Autowired
    UserRepository repository;

    @Override
    public UserResponseDto register(SignUpDto signUpDto) throws UserExistException {
        User user = mapper.toEntity(signUpDto);

        if (repository.findByUsername(user.getEmail()).isPresent()) {
            throw new UserExistException();
        }

        repository.save(user);
        return mapper.toResponseDto(user);
    }
}
