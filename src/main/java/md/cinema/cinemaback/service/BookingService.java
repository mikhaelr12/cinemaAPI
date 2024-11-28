package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.BookingDTO;

public interface BookingService {
    void validateAndBook(BookingDTO bookingDTO, String jwt);
}
