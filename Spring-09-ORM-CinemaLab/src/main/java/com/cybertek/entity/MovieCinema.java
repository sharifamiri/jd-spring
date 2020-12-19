package com.cybertek.entity;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    public MovieCinema(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
