package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import md.cinema.cinemaback.enums.Role;

@Getter @Setter @Builder
public class UserDTO {
    private String username;
    private String password;
    private Role role;
}

