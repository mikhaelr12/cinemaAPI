package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.MovieDTO;
import md.cinema.cinemaback.entity.Movie;
import md.cinema.cinemaback.repository.MovieRepository;
import md.cinema.cinemaback.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    @Override
    public List<MovieDTO> getMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream().map(m -> MovieDTO.builder()
                .movieId(m.getId())
                .title(m.getTitle())
                .description(m.getDescription())
                .duration(m.getDuration())
                .image(m.getImage().startsWith("/images/") ? m.getImage() : "/images/" + m.getImage())
                .genreName(m.getGenre().getName())
                .build()
        ).collect(toList());
    }
}
