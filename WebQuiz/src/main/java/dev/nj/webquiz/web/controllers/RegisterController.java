package dev.nj.webquiz.web.controllers;

import dev.nj.webquiz.exceptions.UserAlreadyExistsException;
import dev.nj.webquiz.services.RegisterService;
import dev.nj.webquiz.web.dto.UserDto;
import dev.nj.webquiz.web.mapper.UserMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
