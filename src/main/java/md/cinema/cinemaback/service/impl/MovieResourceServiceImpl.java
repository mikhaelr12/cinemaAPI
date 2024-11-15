package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.MovieAddDTO;
import md.cinema.cinemaback.entity.Genre;
import md.cinema.cinemaback.entity.Movie;
import md.cinema.cinemaback.repository.GenreRepository;
import md.cinema.cinemaback.repository.MovieRepository;
import md.cinema.cinemaback.service.MovieResourceService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieResourceServiceImpl implements MovieResourceService {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    @Override
    public void addMovie(MovieAddDTO movieAddDTO) {
        String imagePath = saveImage(movieAddDTO.getImage());
        Genre genre = genreRepository.findById(movieAddDTO.getGenreId()).get();
        movieRepository.save(Movie.builder()
                        .title(movieAddDTO.getTitle())
                        .description(movieAddDTO.getDescription())
                        .genre(genre)
                        .image(imagePath)
                        .duration(movieAddDTO.getDuration())
                .build());
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent())  movieRepository.delete(movie.get());
    }

    private String saveImage(MultipartFile image) {
        try {
            String uploadDir = "src/main/resources/static/images/";
            String fileName = image.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "/images/" + fileName; // Relative path
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }
}
