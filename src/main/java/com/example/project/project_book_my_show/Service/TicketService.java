package com.example.project.project_book_my_show.Service;

import com.example.project.project_book_my_show.Dto.TicketDto;

public interface TicketService {

    TicketDto getTicket(int ID);

    TicketDto bookTicket(BookTicketReqDto bookTicketReqDto);
}
