package com.example.project.project_book_my_show.Converter;

import com.example.project.project_book_my_show.Dto.EntryDto.TheatreEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.TheatreResponseDto;
import com.example.project.project_book_my_show.Model.TheatreEntity;

public class TheatreConverter {

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreDto){
        return TheatreEntity.builder().name(theatreDto.getName())
                .address(theatreDto.getAddress()).city(theatreDto.getCity()).build();
    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theatreEntity){
        return TheatreResponseDto.builder().ID(theatreEntity.getID()).name(theatreEntity.getName())
                .address(theatreEntity.getAddress()).city(theatreEntity.getCity()).
                build();
    }
}
