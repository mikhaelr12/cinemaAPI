package md.cinema.cinemaback.exception;

import java.io.Serial;

public class ScreeningException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public ScreeningException(String message) {
        super(message);
    }
}
