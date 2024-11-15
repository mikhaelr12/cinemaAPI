package md.cinema.cinemaback.repository;

import md.cinema.cinemaback.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
