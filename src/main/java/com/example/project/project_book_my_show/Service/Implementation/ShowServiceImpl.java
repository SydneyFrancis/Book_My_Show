package com.example.project.project_book_my_show.Service.Implementation;

import com.example.project.project_book_my_show.Converter.ShowConverter;
import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.ShowResponseDto;
import com.example.project.project_book_my_show.Model.*;
import com.example.project.project_book_my_show.Repository.MovieRepository;
import com.example.project.project_book_my_show.Repository.ShowRepository;
import com.example.project.project_book_my_show.Repository.ShowSeatsRepository;
import com.example.project.project_book_my_show.Repository.TheatreRepository;
import com.example.project.project_book_my_show.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService
{

    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatsRepository showSeatsRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showDto);

        MovieEntity movieEntity = movieRepository.findById(showEntity.getID()).get();

        TheatreEntity theatreEntity = theatreRepository.findById(showDto.getTheatre().getID()).get();

        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        generateShowEntitySeats(theatreEntity.getNo_of_seats(),showEntity);

        showEntity = showRepository.save(showEntity);

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);


        return showResponseDto;
    }

    public void generateShowEntitySeats(List<TheatreSeatEntity> seatEntities,ShowEntity show){
        List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();

        for(TheatreSeatEntity tse : seatEntities){
            ShowSeatsEntity showSeats = ShowSeatsEntity.builder().seatNo(tse.getSeatNo())
                    .seatType(tse.getSeatType()).rate(tse.getRate()).build();

            showSeatsEntities.add(showSeats);
        }
        showSeatsRepository.saveAll(showSeatsEntities);

        for(ShowSeatsEntity showSeats : showSeatsEntities){
            showSeats.setShow(show);
        }

    }
}