package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;

@Getter @Setter
@Builder
public class MovieDTO {
    private Long movieId;
    private String title;
    private String description;
    private LocalTime duration;
    private String image;
    private String genreName;
}
