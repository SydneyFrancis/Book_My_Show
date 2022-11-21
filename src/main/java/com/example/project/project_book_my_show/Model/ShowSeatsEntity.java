package com.example.project.project_book_my_show.Model;


import com.example.project.project_book_my_show.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShowSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    private String seatNo;

    private int rate;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;


    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity show;
}
