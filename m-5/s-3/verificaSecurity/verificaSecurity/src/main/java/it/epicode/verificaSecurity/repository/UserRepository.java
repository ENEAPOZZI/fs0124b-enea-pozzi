package it.epicode.verificaSecurity.repository;

import it.epicode.verificaSecurity.data.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsernameAndPassword(String username, String password);
    Optional<User> findOneByUsername(String username);

    Optional<User> findById(long id);
}

