package nodBotirov.Production.repository;

import nodBotirov.Production.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface UserRepository extends JpaRepository<User, Long> {

}
