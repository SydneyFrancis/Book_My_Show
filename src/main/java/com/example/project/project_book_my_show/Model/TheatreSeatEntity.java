package com.example.project.project_book_my_show.Model;


import com.example.project.project_book_my_show.Enum.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class TheatreSeatEntity {

    @Id
    private int ID;

    private String seatNo;

    private int rate;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;

}
