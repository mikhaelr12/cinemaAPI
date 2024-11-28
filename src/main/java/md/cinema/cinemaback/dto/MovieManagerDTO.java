package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;
import java.time.LocalTime;

@Getter @Setter
@Builder
public class MovieManagerDTO {
    private String title;
    private String description;
    private LocalTime duration;
    private Long genreId;
    private MultipartFile image;
}
