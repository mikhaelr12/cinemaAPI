package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getMovies();
}
