package dev.nj.accountservice.web.controller;

import dev.nj.accountservice.entities.User;
import dev.nj.accountservice.service.EmployeeService;
import dev.nj.accountservice.web.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empl")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/payment")
    public ResponseEntity<UserResponseDto> getUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(employeeService.getUser(user));
    }
}
