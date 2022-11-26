package com.example.project.project_book_my_show.Dto.ResponseDto;

import com.example.project.project_book_my_show.Model.ShowSeatsEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class ShowResponseDto {

    int ID;

    LocalDate showDate;

    LocalTime showTime;

    String theatreName;

    String movieName;

    List<ShowSeatsEntity> seats;
}
