package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter @Setter
@Builder
public class MovieDTO {
    private Long movieId;
    private String title;
    private String description;
    private Time duration;
    private String image;
    private String genreName;
}
