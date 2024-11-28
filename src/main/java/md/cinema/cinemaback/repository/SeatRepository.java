package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
