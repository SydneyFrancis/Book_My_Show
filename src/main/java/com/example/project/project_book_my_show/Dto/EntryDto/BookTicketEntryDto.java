package com.example.project.project_book_my_show.Dto.EntryDto;

import com.example.project.project_book_my_show.Enum.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class BookTicketEntryDto {
    Set<String> requestedSeats;

    int ID;

    int showID;

    SeatType seatType;
}
