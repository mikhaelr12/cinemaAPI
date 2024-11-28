package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    List<Screening> findByScreeningDateAndRoomId(LocalDate screenDate, Long roomId);
}
