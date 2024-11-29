package md.cinema.cinemaback.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @Builder
public class BookingDTO {
    private Long screeningId;
    private Long userId;
    private List<Long> seatIds;
    private Double totalPrice;
}
