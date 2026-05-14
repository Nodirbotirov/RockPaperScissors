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

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    public User addWin(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        user.setWins(user.getWins() + 1);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow();

        userRepository.delete(user);
    }
}
