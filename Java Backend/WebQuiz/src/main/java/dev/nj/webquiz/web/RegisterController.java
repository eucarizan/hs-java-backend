package dev.nj.webquiz.web;

import dev.nj.webquiz.exceptions.UserAlreadyExistsException;
import dev.nj.webquiz.services.RegisterService;
import dev.nj.webquiz.web.dto.UserDto;
import dev.nj.webquiz.web.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @ExceptionHandler(UserAlreadyExistsException.class)
    ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException uaeException) {
        return new ResponseEntity<>(Map.of("error", "User already exists"), HttpStatus.BAD_REQUEST);
    }
}
