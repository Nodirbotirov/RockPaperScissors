package nodBotirov.Production.service;

import nodBotirov.Production.dto.UserRequestDTO;
import nodBotirov.Production.dto.UserResponseDTO;
import nodBotirov.Production.entity.User;
import nodBotirov.Production.exception.UserNotFoundException;
import nodBotirov.Production.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setWins(dto.getWins());

        User saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getUsername(),
                saved.getWins()
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );
    }

    public User addWin(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );

        user.setWins(user.getWins() + 1);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found with id: " + id)
                );

        userRepository.delete(user);
    }

    public void addWinByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        )
                );
        user.setWins(user.getWins() + 1);

        userRepository.save(user);
    }
}
