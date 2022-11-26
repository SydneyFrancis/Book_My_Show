package com.example.project.project_book_my_show.Dto.ResponseDto;

import com.example.project.project_book_my_show.Model.ShowEntity;
import com.example.project.project_book_my_show.Model.TheatreSeatEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TheatreResponseDto {
    int ID;

    String  name;

    String address;

    String city;

//    Seats
    List<TheatreSeatEntity> theatreSeat;

    List<ShowEntity> show;
}
