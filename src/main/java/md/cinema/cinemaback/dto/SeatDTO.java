package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @Builder
public class SeatDTO {
    private List<Long> seats;
}
