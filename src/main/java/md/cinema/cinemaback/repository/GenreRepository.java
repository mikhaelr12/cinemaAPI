package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
