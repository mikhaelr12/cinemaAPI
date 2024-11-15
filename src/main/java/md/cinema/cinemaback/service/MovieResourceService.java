package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.MovieAddDTO;

public interface MovieResourceService {
    void addMovie(MovieAddDTO movieAddDTO);

    void deleteMovie(Long id);
}
