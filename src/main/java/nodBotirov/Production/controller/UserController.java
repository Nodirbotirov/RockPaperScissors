package nodBotirov.Production.controller;

import nodBotirov.Production.dto.UserRequestDTO;
import nodBotirov.Production.dto.UserResponseDTO;
import nodBotirov.Production.entity.User;
import nodBotirov.Production.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {

        return userService.createUser(dto);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PutMapping("/users/{id}/win")
    public User addWin(@PathVariable Long id) {

        return userService.addWin(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }
}
