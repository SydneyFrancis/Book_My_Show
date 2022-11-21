package com.example.project.project_book_my_show.Dto;

import com.example.project.project_book_my_show.Dto.EntryDto.ShowEntryDto;
import com.example.project.project_book_my_show.Dto.EntryDto.UserEntryDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketDto {

    int ID;

    String allotedSeats;

    double amount;

    int showID;

    int userID;
}
