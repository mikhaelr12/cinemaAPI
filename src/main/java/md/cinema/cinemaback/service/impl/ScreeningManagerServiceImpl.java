package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.ScreeningDTO;
import md.cinema.cinemaback.entity.Movie;
import md.cinema.cinemaback.entity.Room;
import md.cinema.cinemaback.entity.Screening;
import md.cinema.cinemaback.repository.MovieRepository;
import md.cinema.cinemaback.repository.RoomRepository;
import md.cinema.cinemaback.repository.ScreeningRepository;
import md.cinema.cinemaback.service.ScreeningManagerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreeningManagerServiceImpl implements ScreeningManagerService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;

    private boolean isOverlapping(Screening existingScreening, ScreeningDTO newScreening, Movie movie) {
        LocalDateTime existingStart = LocalDateTime.of(existingScreening.getScreeningDate(),
                existingScreening.getScreeningTime());
        LocalDateTime newStart = LocalDateTime.of(newScreening.getScreenDate(),
                newScreening.getScreenTime());

        long durationInMinutes = movie.getDuration().toSecondOfDay()/60;

        LocalDateTime existingEnd = existingStart.plusMinutes(durationInMinutes);
        LocalDateTime newEnd = newStart.plusMinutes(durationInMinutes);

        return newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart);
    }

    @Override
    public void addScreening(ScreeningDTO screeningDTO) {
        Movie movie = movieRepository.findById(screeningDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie not found for ID: " + screeningDTO.getMovieId()));

        Room room = roomRepository.findById(screeningDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found for ID: " + screeningDTO.getRoomId()));

        List<Screening> screenings = screeningRepository.findByScreeningDateAndRoomId(
                screeningDTO.getScreenDate(), screeningDTO.getRoomId());

        boolean isOverlapping = screenings.stream()
                .anyMatch(existingScreening -> isOverlapping(existingScreening, screeningDTO, movie));

        if (isOverlapping) {
            throw new RuntimeException("The screening time overlaps with an existing screening.");
        }

        Screening newScreening = Screening.builder()
                .movie(movie)
                .room(room)
                .screeningDate(screeningDTO.getScreenDate())
                .screeningTime(screeningDTO.getScreenTime())
                .price(screeningDTO.getPrice())
                .build();
        screeningRepository.save(newScreening);
    }

    @Override
    public void deleteScreening(Long id) {
        screeningRepository.findById(id).ifPresent(screeningRepository::delete);
    }
}
