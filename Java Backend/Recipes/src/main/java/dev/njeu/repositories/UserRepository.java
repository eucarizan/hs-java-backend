package dev.njeu.repositories;

import dev.njeu.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    /**
     * method to implement the functional interface of the Authentication Manager bean.
     * @param username the authentication provided username as search key
     * @return the User entity as UserDetails type to suit the interface if found, or else Optional.empty()
     */
    Optional<User> findByUsername(String username);
}
