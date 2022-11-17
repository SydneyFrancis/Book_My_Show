package com.example.project.project_book_my_show.Converter;

import com.example.project.project_book_my_show.Dto.TicketDto;
import com.example.project.project_book_my_show.Model.TicketEntity;

public class TicketConverter {

    public static TicketDto convertEntityToDto(TicketEntity ticketEntity){
        return TicketDto.builder().ID(ticketEntity.getID()).amount(ticketEntity.getAmount())
                .allotedSeats(ticketEntity.getAllottedSeats()).build();
    }
}
