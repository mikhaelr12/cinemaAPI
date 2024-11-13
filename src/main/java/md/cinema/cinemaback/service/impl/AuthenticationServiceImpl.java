package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.UserDTO;
import md.cinema.cinemaback.entity.User;
import md.cinema.cinemaback.enums.Role;
import md.cinema.cinemaback.exception.UserException;
import md.cinema.cinemaback.repository.UserRepository;
import md.cinema.cinemaback.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(UserDTO input) {
        var user = userRepository.findByUsername(input.getUsername());
        if (user.isPresent()) {
            throw new UserException("Username is already in use");
        }
        User newUser = new User();
        if(input.getRole() == null)
            newUser.setRole(Role.USER);
        else
            newUser.setRole(input.getRole());
        newUser.setUsername(input.getUsername());
        newUser.setPassword(passwordEncoder.encode(input.getPassword()));
        userRepository.save(newUser);
    }

    public User authenticate(UserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }
}
