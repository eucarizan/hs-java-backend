package dev.nj.webquiz.services.impl;

import dev.nj.webquiz.entities.User;
import dev.nj.webquiz.exceptions.UserAlreadyExistsException;
import dev.nj.webquiz.repositories.UserRepository;
import dev.nj.webquiz.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository repository;

    @Autowired
    public RegisterServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerUser(User user) throws UserAlreadyExistsException {
        if (repository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException();
        }
        repository.save(user);
    }

}
