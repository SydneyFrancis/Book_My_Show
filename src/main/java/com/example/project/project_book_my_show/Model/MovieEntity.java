package com.example.project.project_book_my_show.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;

    private LocalDate releaseDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> showEntities;
}
