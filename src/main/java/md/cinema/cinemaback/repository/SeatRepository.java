package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByRoomId(Long id);
}
