package md.cinema.cinemaback.controller;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.ScreeningDTO;
import md.cinema.cinemaback.service.ScreeningService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@AllArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<ScreeningDTO>> getScreenings() {
        return ResponseEntity.ok(screeningService.getScreenings());
    }
}
