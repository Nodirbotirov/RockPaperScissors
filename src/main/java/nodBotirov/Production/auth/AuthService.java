package nodBotirov.Production.auth;

import nodBotirov.Production.entity.User;
import nodBotirov.Production.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterRequest request) {
        boolean exists =
                userRepository
                        .findByUsername(
                                request.getUsername()
                        )
                        .isPresent();
        if (exists) {
            throw new RuntimeException(
                    "Username already exists"
            );
        }

        User user = new User();

        user.setWins(0);

        userRepository.save(user);
    }


}
