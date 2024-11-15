package md.cinema.cinemaback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_seq")
    @SequenceGenerator(name = "movie_id_seq", sequenceName = "movie_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "duration", nullable = false)
    private Time duration;

    @Column(name = "image", nullable = false)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", foreignKey = @ForeignKey(name = "FK_GENRE_MOVIE"))
    private Genre genre;
}

