package com.example.project.project_book_my_show.Service;

import com.example.project.project_book_my_show.Dto.EntryDto.TheatreEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.TheatreResponseDto;

public interface TheatreService {

//    add theatre

    TheatreEntryDto addTheatre(TheatreEntryDto theatreDto);

    TheatreResponseDto getTheatre(int ID);
}
