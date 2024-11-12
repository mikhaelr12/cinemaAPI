package md.cinema.cinemaback.dto;

import lombok.Getter;
import lombok.Setter;
import md.cinema.cinemaback.enums.Role;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;
    private Role role;
}

