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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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

        MovieEntity movieEntity = movieRepository.findById(showDto.getMovieID()).get();



        TheatreEntity theatreEntity = theatreRepository.findById(showDto.getTheatreID()).get();
//
//        String theatrename = theatreEntity.getName();
//        String movieName = movieEntity.getName();


        showEntity.setMovie(movieEntity);
        showEntity.setTheatre(theatreEntity);

        generateShowEntitySeats(theatreEntity.getSeats(),showEntity);

        showEntity = showRepository.save(showEntity);

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity);
        showResponseDto.setTheatreName(theatreEntity.getName());
        showResponseDto.setMovieName(movieEntity.getName());


        return showResponseDto;
    }

    @Override
    public ShowResponseDto getShow(int ID) {
        ShowEntity show = showRepository.findById(ID).get();

        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(show);
        return  showResponseDto;
    }

    public void generateShowEntitySeats(List<TheatreSeatEntity> seatEntities,ShowEntity show){
        List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();
        log.info("The list of theaterEntity Seats");
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
