package md.cinema.cinemaback.controller.admin;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.ScreeningDTO;
import md.cinema.cinemaback.service.ScreeningManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/screening-manager")
@AllArgsConstructor
public class ScreeningManagerController {

    private ScreeningManagerService screeningManagerService;

    @PostMapping
    public ResponseEntity<?> addScreening(@RequestBody ScreeningDTO screeningDTO) {
        screeningManagerService.addScreening(screeningDTO);
        return ResponseEntity.ok("Screening added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScreening(@PathVariable Long id) {
        screeningManagerService.deleteScreening(id);
        return ResponseEntity.ok("Screening deleted");
    }
}
