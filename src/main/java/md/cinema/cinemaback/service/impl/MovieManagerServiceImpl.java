package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.MovieManagerDTO;
import md.cinema.cinemaback.entity.Genre;
import md.cinema.cinemaback.entity.Movie;
import md.cinema.cinemaback.exception.MovieException;
import md.cinema.cinemaback.repository.GenreRepository;
import md.cinema.cinemaback.repository.MovieRepository;
import md.cinema.cinemaback.service.MovieManagerService;
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
public class MovieManagerServiceImpl implements MovieManagerService {

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    private String saveImage(MultipartFile image) {
        if(image.isEmpty())
            return null;
        try {
            String uploadDir = "src/main/resources/static/images/";
            String fileName = image.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            return "/images/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @Override
    public void addMovie(MovieManagerDTO movieManagerDTO) {
        String imagePath = saveImage(movieManagerDTO.getImage());
        Genre genre = genreRepository.findById(movieManagerDTO.getGenreId()).get();
        movieRepository.save(Movie.builder()
                        .title(movieManagerDTO.getTitle())
                        .description(movieManagerDTO.getDescription())
                        .genre(genre)
                        .image(imagePath)
                        .duration(movieManagerDTO.getDuration())
                .build());
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.findById(id).ifPresent(movieRepository::delete);
    }

    @Override
    public void updateMovie(Long id, MovieManagerDTO movieManagerDTO) {
        String imagePath = saveImage(movieManagerDTO.getImage());

        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            if(!movieManagerDTO.getDescription().isEmpty())
                movie.get().setDescription(movieManagerDTO.getDescription());
            if(!movieManagerDTO.getTitle().isEmpty())
                movie.get().setTitle(movieManagerDTO.getTitle());
            if(!movieManagerDTO.getImage().isEmpty())
                movie.get().setImage(imagePath);
        }
        else{
            throw new MovieException("No movie found");
        }
        movieRepository.save(movie.get());
    }

}
