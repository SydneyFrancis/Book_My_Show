package com.example.project.project_book_my_show.Dto.EntryDto;

import com.example.project.project_book_my_show.Dto.ResponseDto.MovieResponseDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.TheatreResponseDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;



@Data
@Builder
public class ShowEntryDto {

    LocalDate showDate;

    LocalTime showTime;

    TheatreResponseDto theatre;

    MovieResponseDto movie;
}
