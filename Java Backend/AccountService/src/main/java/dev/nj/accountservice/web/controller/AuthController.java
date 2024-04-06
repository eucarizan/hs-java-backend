package dev.nj.accountservice.web.controller;

import dev.nj.accountservice.service.AuthService;
import dev.nj.accountservice.web.dto.SignUpDto;
import dev.nj.accountservice.web.dto.UserResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody @Valid SignUpDto signUpDto) {
        return ResponseEntity.ok(authService.register(signUpDto));
    }
}
