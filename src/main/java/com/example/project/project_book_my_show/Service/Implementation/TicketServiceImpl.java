package com.example.project.project_book_my_show.Service.Implementation;

import com.example.project.project_book_my_show.Converter.TicketConverter;
import com.example.project.project_book_my_show.Dto.TicketDto;
import com.example.project.project_book_my_show.Model.ShowEntity;
import com.example.project.project_book_my_show.Model.ShowSeatsEntity;
import com.example.project.project_book_my_show.Model.TicketEntity;
import com.example.project.project_book_my_show.Model.UserEntity;
import com.example.project.project_book_my_show.Repository.ShowRepository;
import com.example.project.project_book_my_show.Repository.TicketRepository;
import com.example.project.project_book_my_show.Repository.UserRepository;
import com.example.project.project_book_my_show.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;


    @Override
    public TicketDto getTicket(int ID) {
        return null;
    }

    @Override
    public TicketDto bookTicket(BookTicketReqDto bookTicketReqDto) {

        UserEntity user = userRepository.findById(bookTicketReqDto.getID()).get();

        ShowEntity show = showRepository.findById(bookTicketReqDto.getShowID()).get();

        Set<String> requestedSeats = bookTicketReqDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntities = show.getShowSeatsEntities();

        List<ShowSeatsEntity> bookedSeats = showSeatsEntities.stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketReqDto.getSeatType()) && !seat.isBooked() &&
                        requestedSeats.contains(seat.getSeatNo())).collect(Collectors.toList());

        if(requestedSeats.size() != bookedSeats.size()){
            throw new Error("All seats not available");
        }

        TicketEntity ticketEntity = TicketEntity.builder().user(user).showEntity(show).Seats(bookedSeats)
                .build();

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntitylist : bookedSeats){
            showSeatsEntitylist.setBooked(true);
            showSeatsEntitylist.setBookedAt(new Date());
            showSeatsEntitylist.setTicket(ticketEntity);
            amount = amount + showSeatsEntitylist.getRate();
        }

        ticketEntity.setAllottedSeats(String.valueOf(bookedSeats));
        ticketEntity.setAmount(amount);

//        connect in the show and

        ticketEntity = ticketRepository.save(ticketEntity);

        return TicketConverter.convertEntityToDto(ticketEntity);
    }
}
