package md.cinema.cinemaback.controller.admin;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.MovieManagerDTO;
import md.cinema.cinemaback.service.MovieManagerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-manager")
@AllArgsConstructor
public class MovieManagerController {

    private final MovieManagerService movieResourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addMovie(@ModelAttribute MovieManagerDTO movieManagerDTO){
        movieResourceService.addMovie(movieManagerDTO);
        return ResponseEntity.ok("New movie added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieResourceService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody MovieManagerDTO movieManagerDTO){
        movieResourceService.updateMovie(id, movieManagerDTO);
        return ResponseEntity.ok("Movie updated");
    }
}
