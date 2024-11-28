package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void validateAndBook(BookingDTO bookingDTO, String jwt);

    List<BookingDTO> getBookings(String jwt);

    void cancelBooking(String jwt, Long id);
}
