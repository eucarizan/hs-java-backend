package dev.njeu.service;

import dev.njeu.entities.User;
import dev.njeu.exceptions.UserAlreadyExistsException;

public interface RegisterService {
    /**
     * persist the user (with encoded password), if its username does not exist already (unique username).
     * @throws UserAlreadyExistsException (HttpStatus = 400) if there is an entity with this username already
     */
    void registerUser(User user) throws UserAlreadyExistsException;
}
