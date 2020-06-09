package salon.api.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import salon.api.dto.GenericResponseDto;
import salon.api.dto.JwtResponseDto;
import salon.api.dto.UsernamePasswordDto;
import salon.api.model.User;
import salon.api.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public GenericResponseDto register(User user) {
        GenericResponseDto responseDto = new GenericResponseDto();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (!userRepository.userExists(user.getEmail())) {
            userRepository.addUser(user);
        } else {
            responseDto.getErrors().add("User with the specified username already exists.");
        }
        return responseDto;
    }

    public JwtResponseDto authenticate(UsernamePasswordDto request) throws Exception {
        authenticate(request.getEmail(), request.getPassword());
        final User userDetails = userRepository.getUser(request.getEmail());
        final String token = jwtTokenService.generateToken(userDetails.getEmail());
        return new JwtResponseDto(userDetails.getId(), userDetails.getEmail(), token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public User getCurrentUser() {
        String loggedInUsername = ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return userRepository.getUser(loggedInUsername);
    }


}
