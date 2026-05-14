package nodBotirov.Production.service;

import nodBotirov.Production.entity.User;
import nodBotirov.Production.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser() {

        User user = new User(
                "Nodir",
                5
        );

        userRepository.save(user);

        System.out.println("User saved");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
