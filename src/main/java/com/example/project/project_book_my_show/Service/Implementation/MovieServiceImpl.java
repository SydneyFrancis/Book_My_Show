package com.example.project.project_book_my_show.Service.Implementation;

import com.example.project.project_book_my_show.Converter.MovieConverter;
import com.example.project.project_book_my_show.Dto.EntryDto.MovieEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.MovieResponseDto;
import com.example.project.project_book_my_show.Model.MovieEntity;
import com.example.project.project_book_my_show.Repository.MovieRepository;
import com.example.project.project_book_my_show.Service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

@Slf4j
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieDto) {


        log.info("Adding movie",movieDto);


//
        MovieEntity movieEntity = MovieConverter.convertDtoTOEntity(movieDto);
        movieEntity = movieRepository.save(movieEntity);
        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int ID) {
        MovieEntity movieEntity = movieRepository.findById(ID).get();

        MovieResponseDto movieDto = MovieConverter.convertEntityToDto(movieEntity);
        return  movieDto;
    }
}
