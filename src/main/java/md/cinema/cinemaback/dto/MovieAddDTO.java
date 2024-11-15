package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Time;

@Getter @Setter
@Builder
public class MovieAddDTO {
    private String title;
    private String description;
    private Time duration;
    private Long genreId;
    private MultipartFile image;
}
