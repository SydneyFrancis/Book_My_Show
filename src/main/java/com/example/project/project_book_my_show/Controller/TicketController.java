package com.example.project.project_book_my_show.Controller;

import com.example.project.project_book_my_show.Dto.EntryDto.BookTicketEntryDto;
import com.example.project.project_book_my_show.Dto.EntryDto.TheatreEntryDto;
import com.example.project.project_book_my_show.Dto.TicketDto;
import com.example.project.project_book_my_show.Service.Implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/bookTheatre")
    public ResponseEntity BookTicket(@RequestBody BookTicketEntryDto bookTicketEntryDto){
        ticketService.bookTicket(bookTicketEntryDto);
        return  new ResponseEntity<>("TicketBooked", HttpStatus.OK);
    }

    @GetMapping("/getTicket")
    public ResponseEntity<TicketDto> getTicket(@RequestParam("id")int ID){
        return new ResponseEntity<>(ticketService.getTicket(ID),HttpStatus.FOUND);
    }


}
