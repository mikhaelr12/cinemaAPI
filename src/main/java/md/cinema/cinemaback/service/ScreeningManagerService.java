package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.ScreeningDTO;

public interface ScreeningManagerService {
    void addScreening(ScreeningDTO screeningDTO);

    void deleteScreening(Long id);
}
