package salon.api.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import salon.api.repository.UserServiceRepository;

import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class UserServiceController {

    private final UserServiceRepository userServiceRepository;

    public UserServiceController(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }


    @GetMapping("/default")
    public List<String> getDefaultServices() {
        return userServiceRepository.getDefaultServices();
    }
}
