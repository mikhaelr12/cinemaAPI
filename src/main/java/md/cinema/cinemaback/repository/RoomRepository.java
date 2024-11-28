package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
