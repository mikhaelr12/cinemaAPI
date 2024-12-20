package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.BookingDTO;
import md.cinema.cinemaback.dto.SeatDTO;

import java.util.List;

public interface BookingService {
    void validateAndBook(BookingDTO bookingDTO, String jwt);

    List<BookingDTO> getBookings(String jwt);

    void cancelBooking(String jwt, Long id);


    List<SeatDTO> getFreeSeats(Long screeningId);
}
