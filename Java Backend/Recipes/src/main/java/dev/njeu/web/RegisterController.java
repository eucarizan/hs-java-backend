package dev.njeu.web;

import dev.njeu.service.RegisterService;
import dev.njeu.web.dto.UserDto;
import dev.njeu.web.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    private final RegisterService service;
    private final UserMapper mapper;

    @Autowired
    public RegisterController(RegisterService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserDto userDto) {
        service.registerUser(mapper.toEntity(userDto));
        return ResponseEntity.ok().build();
    }
}
