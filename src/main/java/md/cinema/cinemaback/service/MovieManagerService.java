package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.MovieManagerDTO;

public interface MovieManagerService {
    void addMovie(MovieManagerDTO movieManagerDTO);

    void deleteMovie(Long id);

    void updateMovie(Long id, MovieManagerDTO movieAddDTO);
}
