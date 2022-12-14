package com.example.project.project_book_my_show.Service;

import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.ShowResponseDto;
import org.springframework.stereotype.Service;

public interface ShowService {

    void addShow(ShowEntryDto showDto);

//    get show
    ShowResponseDto getShow(int ID);
}
