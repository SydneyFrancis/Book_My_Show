package com.example.project.project_book_my_show.Converter;

import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.ShowResponseDto;
import com.example.project.project_book_my_show.Model.ShowEntity;

public class ShowConverter {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){
        return ShowEntity.builder().showDate(showDto.getShowDate())
                .showTime(showDto.getShowTime()).build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity show){
        return ShowResponseDto.builder().ID(show.getID()).showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .build();
    }
}
