package dev.njeu.service.impl;

import dev.njeu.entities.User;
import dev.njeu.exceptions.UserAlreadyExistsException;
import dev.njeu.repositories.UserRepository;
import dev.njeu.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository repository;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public void registerUser(User user) throws UserAlreadyExistsException {
        if (repository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException();
        }
        repository.save(user);
    }
}
