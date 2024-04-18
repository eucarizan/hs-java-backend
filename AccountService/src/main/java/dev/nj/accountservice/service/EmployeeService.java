package dev.nj.accountservice.service;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.web.dto.UserResponseDto;

public interface EmployeeService {
    UserResponseDto getUser(User user);
}
