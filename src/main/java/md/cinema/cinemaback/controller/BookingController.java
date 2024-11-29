package md.cinema.cinemaback.controller;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.BookingDTO;
import md.cinema.cinemaback.dto.SeatDTO;
import md.cinema.cinemaback.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    private String getToken(String token){
        return token.startsWith("Bearer ") ? token.substring(7) : token;
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getBookings(@RequestHeader("Authorization") String token){
        String jwt = getToken(token);
        return ResponseEntity.ok(bookingService.getBookings(jwt));
    }


    @PostMapping
    public ResponseEntity<?> validateAndBook(@RequestBody BookingDTO bookingDTO,
                                             @RequestHeader("Authorization") String token){
        String jwt = getToken(token);
        bookingService.validateAndBook(bookingDTO,jwt);
        return ResponseEntity.ok("Booking made successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelBooking(@RequestHeader("Authorization") String token, @PathVariable Long id){
        String jwt = getToken(token);
        bookingService.cancelBooking(jwt, id);
        return ResponseEntity.ok("Booking cancelled successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SeatDTO>> getFreeSeats(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.getFreeSeats(id));
    }
}
