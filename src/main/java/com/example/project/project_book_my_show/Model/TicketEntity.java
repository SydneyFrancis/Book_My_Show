package com.example.project.project_book_my_show.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "Tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String allottedSeats;

    private double amount;


    @CreatedDate
    private Date bookedAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private ShowEntity showEntity;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowSeatsEntity> Seats;


}
