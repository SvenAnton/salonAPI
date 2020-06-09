package salon.api.controller;


import org.springframework.web.bind.annotation.*;
import salon.api.dto.*;
import salon.api.model.User;
import salon.api.repository.UserRepository;
import salon.api.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public GenericResponseDto register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public JwtResponseDto authenticate(@RequestBody UsernamePasswordDto request) throws Exception {
        return userService.authenticate(request);
    }

    @GetMapping("/currentUser")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }


}
