package md.cinema.cinemaback.controller;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.MovieAddDTO;
import md.cinema.cinemaback.service.MovieResourceService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie-resource")
@AllArgsConstructor
public class MovieResourceController {

    private final MovieResourceService movieResourceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addMovie(@ModelAttribute MovieAddDTO movieAddDTO){
        movieResourceService.addMovie(movieAddDTO);
        return ResponseEntity.ok("New movie added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieResourceService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted");
    }
}
