package salon.api.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salon.api.model.Bookings;
import salon.api.model.OperationResult;
import salon.api.model.UserServices;
import salon.api.repository.UserServiceRepository;
import salon.api.service.UserServiceService;

import java.util.List;

@RestController
@RequestMapping("/service")
@CrossOrigin
public class UserServiceController {

    private final UserServiceRepository userServiceRepository;
    private final UserServiceService userServiceService;

    public UserServiceController(UserServiceRepository userServiceRepository, UserServiceService userServiceService) {
        this.userServiceRepository = userServiceRepository;
        this.userServiceService = userServiceService;
    }


    @GetMapping("/default")
    public List<String> getDefaultServices() {
        return userServiceRepository.getDefaultServices();
    }

    @PostMapping("/add")
    public ResponseEntity<OperationResult> addService(@RequestBody UserServices service) {
        OperationResult result = userServiceService.addUserService(service);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }


}
