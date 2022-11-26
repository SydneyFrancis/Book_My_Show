package com.example.project.project_book_my_show.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
public class ShowResponseDto {

    int ID;

    LocalDate showDate;

    LocalTime showTime;

    String theatreName;

    String movieName;
}
