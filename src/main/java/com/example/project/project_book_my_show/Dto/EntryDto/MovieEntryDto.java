package com.example.project.project_book_my_show.Dto.EntryDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Builder
public class MovieEntryDto {
    String name;

    LocalDate releaseDate;

//    List<ShowEntryDto> show;
}
