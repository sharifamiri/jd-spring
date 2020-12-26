package com.cybertek.entity;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity {

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;

    @JoinColumn(name = "user_account_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Ticket(Integer seatNumber, Integer rowNumber, LocalDateTime localDateTime) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.dateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                ", dateTime=" + dateTime +
                '}';
    }
}
