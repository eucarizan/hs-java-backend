package dev.nj.accountservice.service.impl;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.service.EmployeeService;
import dev.nj.accountservice.web.dto.UserResponseDto;
import dev.nj.accountservice.web.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    UserMapper mapper;

    @Override
    public UserResponseDto getUser(User user) {
        return mapper.toResponseDto(user);
    }
}
