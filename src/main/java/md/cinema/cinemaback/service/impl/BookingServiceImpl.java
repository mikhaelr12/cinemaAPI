package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.BookingDTO;
import md.cinema.cinemaback.entity.*;
import md.cinema.cinemaback.exception.ScreeningException;
import md.cinema.cinemaback.exception.UserException;
import md.cinema.cinemaback.repository.BookingRepository;
import md.cinema.cinemaback.repository.ScreeningRepository;
import md.cinema.cinemaback.repository.SeatRepository;
import md.cinema.cinemaback.repository.UserRepository;
import md.cinema.cinemaback.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final JwtServiceImpl jwtService;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;

    private User getUser(String jwtToken) {
        String username = jwtService.extractUsername(jwtToken);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException("No user found"));
    }

    private List<Long> getSeatsId(List<Long> seatIds) {
        List<Long> seatsIds = new ArrayList<>();
        for(Long seatId : seatIds){
            seatRepository.findById(seatId).ifPresent(seat -> seatsIds.add(seat.getId()));
        }
        return seatsIds;
    }

    private List<Long> getReservedSeats(List<Booking> bookings) {
        List<Long> reservedSeats = new ArrayList<>();
        for (Booking booking : bookings) {
            for (Seat seat : booking.getSeats()) {
                reservedSeats.add(seat.getId());
            }
        }
        return reservedSeats;
    }


    private void validateNewBookingSeats(List<Long> newBookingSeats,
                                         List<Long> reservedSeats,
                                         Optional<Screening> screening){
        Room screeningRoom = screening.get().getRoom();
        for(Long seatId : newBookingSeats){
            if(reservedSeats.contains(seatId)){
                throw new ScreeningException("Seat " + seatId + " is already booked");
            }

            Seat seat = seatRepository.findById(seatId).get();
            if(!seat.getRoom().getId().equals(screeningRoom.getId())){
                throw new ScreeningException("Seat " + seatId + " does not belong to screening room");
            }
        }
    }


    @Override
    public void validateAndBook(BookingDTO bookingDTO, String jwt) {
        User user = getUser(jwt);

        Optional<Screening> screening = screeningRepository.findById(bookingDTO.getScreeningId());
        if (screening.isEmpty()) {
            throw new ScreeningException("Screening not found for ID: " + bookingDTO.getScreeningId());
        }

        List<Booking> bookings = bookingRepository.findByScreeningId(bookingDTO.getScreeningId());
        List<Long> reservedSeats = getReservedSeats(bookings);

        List<Long> newBookingSeats = getSeatsId(bookingDTO.getSeatIds());
        validateNewBookingSeats(newBookingSeats, reservedSeats, screening);

        Double price = newBookingSeats.size() * screening.get().getPrice();

        bookingRepository.save(Booking.builder()
                .seats(seatRepository.findAllById(newBookingSeats))
                .totalPrice(price)
                .userId(user.getId())
                .screening(screening.get())
                .build());
    }
}
