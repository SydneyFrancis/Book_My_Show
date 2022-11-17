package com.example.project.project_book_my_show.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class ShowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private LocalDate showDate;

    private LocalTime showTime;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "theatre_id")
    private TheatreEntity theatre;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketEntity> ticketEntities;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    @JsonIgnore

    private List<ShowSeatsEntity> showSeatsEntities;


}
