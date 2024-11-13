package md.cinema.cinemaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "md.cinema")
public class CinemaBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackApplication.class, args);
    }

}
