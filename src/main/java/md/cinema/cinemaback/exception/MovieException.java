package md.cinema.cinemaback.exception;

import java.io.Serial;

public class MovieException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public MovieException(String message) {
        super(message);
    }

}
