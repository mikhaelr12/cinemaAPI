package md.cinema.cinemaback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Scanner;

@Entity
@Table(name = "screenings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_id_seq")
    @SequenceGenerator(name = "screening_id_seq", sequenceName = "screening_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "screening_time")
    private LocalDateTime screeningTime;
}

