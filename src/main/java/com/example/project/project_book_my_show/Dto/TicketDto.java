package com.example.project.project_book_my_show.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int ID;

    String allotedSeats;

    double amount;

    ShowDto showDto;

    UserDto userDto;
}
