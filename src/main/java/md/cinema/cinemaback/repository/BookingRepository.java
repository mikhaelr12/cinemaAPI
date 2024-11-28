package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByScreeningId(Long id);

    List<Booking> findByUserId(Long id);

}
