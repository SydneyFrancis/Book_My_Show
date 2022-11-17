package com.example.project.project_book_my_show.Service.Implementation;

import com.example.project.project_book_my_show.Converter.TheatreConverter;
import com.example.project.project_book_my_show.Dto.EntryDto.TheatreEntryDto;
import com.example.project.project_book_my_show.Dto.ResponseDto.TheatreResponseDto;
import com.example.project.project_book_my_show.Enum.SeatType;
import com.example.project.project_book_my_show.Model.TheatreEntity;
import com.example.project.project_book_my_show.Model.TheatreSeatEntity;
import com.example.project.project_book_my_show.Repository.TheatreRepository;
import com.example.project.project_book_my_show.Repository.TheatreSeatRepository;
import com.example.project.project_book_my_show.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TheatreServiceImpl implements TheatreService {


    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public TheatreEntryDto addTheatre(TheatreEntryDto theatreDto) {
        TheatreEntity theatreEntity = TheatreConverter.convertDtoToEntity(theatreDto);
        List<TheatreSeatEntity> seats = createTheatreSeats();

        for(TheatreSeatEntity theatreSeatEntity : seats){
            theatreSeatEntity.setTheatre(theatreEntity);
        }

        theatreEntity = theatreRepository.save(theatreEntity);
        return theatreDto;
    }

    List<TheatreSeatEntity> createTheatreSeats(){
        List<TheatreSeatEntity> seats = new ArrayList<>();
        seats.add(getTheatreSeat("1A",100,SeatType.Classic));
        seats.add(getTheatreSeat("1B",100,SeatType.Classic));
        seats.add(getTheatreSeat("1C",100,SeatType.Classic));
        seats.add(getTheatreSeat("1D",100,SeatType.Classic));
        seats.add(getTheatreSeat("1E",100,SeatType.Classic));

        seats.add(getTheatreSeat("2A",100,SeatType.Classic));
        seats.add(getTheatreSeat("2B",100,SeatType.Classic));
        seats.add(getTheatreSeat("2C",100,SeatType.Classic));
        seats.add(getTheatreSeat("2D",100,SeatType.Classic));
        seats.add(getTheatreSeat("2E",100,SeatType.Classic));

        theatreSeatRepository.saveAll(seats);
        return  seats;
    }

    TheatreSeatEntity getTheatreSeat(String seatNo, int rate, SeatType seatType){
        return TheatreSeatEntity.builder().seatNo(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int ID) {
         TheatreEntity theatreEntity = theatreRepository.findById(ID).get();

         TheatreResponseDto theatreResponseDto = TheatreConverter.convertEntityToDto(theatreEntity);
         return theatreResponseDto;
    }
}
