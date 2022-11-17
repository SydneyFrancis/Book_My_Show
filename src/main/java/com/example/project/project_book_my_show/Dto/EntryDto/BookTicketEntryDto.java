package com.example.project.project_book_my_show.Dto.EntryDto;

import com.example.project.project_book_my_show.Enum.SeatType;

import java.util.Set;

public class BookTicketEntryDto {
    Set<String> requestedSeats;

    int ID;

    int showID;

    SeatType seatType;
}
