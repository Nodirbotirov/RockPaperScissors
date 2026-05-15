package nodBotirov.Production.repository;

import nodBotirov.Production.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
