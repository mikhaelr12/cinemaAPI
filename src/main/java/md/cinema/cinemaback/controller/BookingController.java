package md.cinema.cinemaback.controller;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.BookingDTO;
import md.cinema.cinemaback.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    private String getToken(String token){
        return token.startsWith("Bearer ") ? token.substring(7) : token;
    }

    @PostMapping
    public ResponseEntity<?> validateAndBook(@RequestBody BookingDTO bookingDTO,
                                             @RequestHeader("Authorization") String token){
        String jwt = getToken(token);
        bookingService.validateAndBook(bookingDTO,jwt);
        return ResponseEntity.ok("Booking made successfully");
    }
}
