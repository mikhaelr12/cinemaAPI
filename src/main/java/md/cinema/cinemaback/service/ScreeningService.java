package md.cinema.cinemaback.service;

import md.cinema.cinemaback.dto.ScreeningDTO;

import java.util.List;

public interface ScreeningService {
    List<ScreeningDTO> getScreenings();
}
