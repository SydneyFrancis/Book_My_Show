package com.example.project.project_book_my_show.Service;

import com.example.project.project_book_my_show.Dto.EntryDto.MovieEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {

//    add movie

    MovieResponseDto addMovie(MovieEntryDto movieDto) throws Exception;

    MovieResponseDto getMovie(int ID);
}
