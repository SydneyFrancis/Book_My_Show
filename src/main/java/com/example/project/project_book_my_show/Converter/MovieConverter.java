package com.example.project.project_book_my_show.Converter;

import com.example.project.project_book_my_show.Dto.EntryDto.MovieEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.MovieResponseDto;
import com.example.project.project_book_my_show.Model.MovieEntity;

public class MovieConverter {

    public static MovieEntity convertDtoTOEntity(MovieEntryDto movieDto){
        return MovieEntity.builder().releaseDate(movieDto.getReleaseDate())
                .name(movieDto.getName()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){
        return  MovieResponseDto.builder().ID(movieEntity.getID()).name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate()).build();
    }
}
