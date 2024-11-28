package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.UserDTO;
import md.cinema.cinemaback.entity.User;
import md.cinema.cinemaback.repository.UserRepository;
import md.cinema.cinemaback.service.UsersManagerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsersManagerServiceImpl implements UsersManagerService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> UserDTO.builder()
                .username(u.getUsername())
                .role(u.getRole())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void updateUserRole(Long userId, UserDTO userDTO) {
        User user = userRepository.findById(userId).orElse(null);
        user.setRole(userDTO.getRole());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }
}
