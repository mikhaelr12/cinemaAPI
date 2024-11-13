package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.UserDTO;
import md.cinema.cinemaback.entity.User;

public interface AuthenticationService {
    void signup(UserDTO input);

    User authenticate(UserDTO input);
}
