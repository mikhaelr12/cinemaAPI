package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.UserDTO;

import java.util.List;

public interface UsersManagerService {
    List<UserDTO> getUsers();

    void updateUserRole(Long userId, UserDTO userDTO);

    void deleteUser(Long id);
}
