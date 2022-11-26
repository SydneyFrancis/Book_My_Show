package com.example.project.project_book_my_show.Dto.ResponseDto;

import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Model.ShowEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Builder
@Data
public class MovieResponseDto {
    int ID;

    String name;

    LocalDate releaseDate;

    List<ShowEntity> show;
}
