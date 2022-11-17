package com.example.project.project_book_my_show.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "Theatre_name")
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;


    private String address;

    private String city;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowEntity> all_shows;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheatreSeatEntity> no_of_seats;
}
