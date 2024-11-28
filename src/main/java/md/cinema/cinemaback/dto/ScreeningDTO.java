package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@Builder
public class ScreeningDTO {
    private Long id;
    private Long movieId;
    private Long roomId;
    private LocalTime screenTime;
    private LocalDate screenDate;
}
