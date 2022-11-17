package com.example.project.project_book_my_show.Dto.ResponseDto;

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

    List<ShowResponseDto> showDto;
}
