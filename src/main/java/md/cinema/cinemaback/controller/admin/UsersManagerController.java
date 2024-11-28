package md.cinema.cinemaback.controller.admin;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.UserDTO;
import md.cinema.cinemaback.service.UsersManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/user-manager")
@AllArgsConstructor

public class UsersManagerController {

    private UsersManagerService usersManagerService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(usersManagerService.getUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserRole(@PathVariable Long id, @RequestBody UserDTO userDTO){
        usersManagerService.updateUserRole(id,userDTO);
        return ResponseEntity.ok("Role updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        usersManagerService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
