package md.cinema.cinemaback.service.impl;

import lombok.AllArgsConstructor;
import md.cinema.cinemaback.dto.ScreeningDTO;
import md.cinema.cinemaback.entity.Screening;
import md.cinema.cinemaback.repository.ScreeningRepository;
import md.cinema.cinemaback.service.ScreeningService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningRepository screeningRepository;

    @Override
    public List<ScreeningDTO> getScreenings() {

        List<Screening> screenings = screeningRepository.findAll();
        return screenings.stream()
                .map(s -> ScreeningDTO.builder()
                        .id(s.getId())
                        .screenTime(s.getScreeningTime())
                        .movieId(s.getMovie().getId())
                        .roomId(s.getRoom().getId())
                        .screenTime(s.getScreeningTime())
                        .screenDate(s.getScreeningDate())
                        .build()
                ).collect(Collectors.toList());
    }


}
